//
//  EOKeyComparisonQualifier.m
//  EOControl
//
//  Created by Mont Rothstein on 12/2/04.
//  Copyright 2004 __MyCompanyName__. All rights reserved.
//

#import "EOQualifier.h"
#import "EONull.h"


@implementation EOKeyComparisonQualifier

static EONull *null = nil;

+ (void)initialize {
	if (null == nil)
		null = [[EONull null] retain];
}

- (id)initWithLeftKey:(NSString *)_leftKey
	 operatorSelector:(SEL)_selector
			 rightKey:(NSString *)_rightKey;
{
	if (self = [super init])
	{
		self->leftKey  = [_leftKey  copyWithZone:NULL];
		self->rightKey = [_rightKey copyWithZone:NULL];
		self->operator = _selector;
	}
	return self;
}

- (void)dealloc {
	[self->leftKey  release];
	[self->rightKey release];
	[super dealloc];
}

/* accessors */

- (NSString *)leftKey {
	return self->leftKey;
}
- (NSString *)rightKey {
	return self->rightKey;
}
- (SEL)selector {
	return self->operator;
}

/* bindings */

- (EOQualifier *)qualifierWithBindings:(NSDictionary *)_bindings
				  requiresAllVariables:(BOOL)_reqAll
{
	static Class VarClass = Nil;
	NSString *newLeftKey;
	id       newRightKey;
	BOOL     needNew;
	
	if (VarClass == Nil) VarClass = [EOQualifierVariable class];
	needNew = NO;
	
	if ([self->leftKey class] == VarClass) {
		newLeftKey =
		[_bindings objectForKey:[(EOQualifierVariable *)self->leftKey key]];
		if (newLeftKey == nil) {
			if (_reqAll)
        // throw exception
				;
			else
				newLeftKey = self->leftKey;
		}
		else
			needNew = YES;
	}
	else
		newLeftKey = self->leftKey;
	
	if ([self->rightKey class] == VarClass) {
		newRightKey =
		[_bindings objectForKey:[(EOQualifierVariable *)self->rightKey key]];
		if (newRightKey == nil) {
			if (_reqAll)
        // throw exception
				;
			else
				newRightKey = self->rightKey;
		}
		else
			needNew = YES;
	}
	else
		newRightKey = self->rightKey;
	
	if (!needNew)
		return self;
	
	return [[[[self class] alloc]
                         initWithLeftKey:newLeftKey
						operatorSelector:self->operator
								rightKey:newRightKey]
		autorelease];
}

- (NSArray *)bindingKeys {
	static Class VarClass = Nil;
	Class lkClass, rkClass;
	if (VarClass == Nil) VarClass = [EOQualifierVariable class];
	
	lkClass = [self->leftKey  class];
	rkClass = [self->rightKey class];
	
	if ((lkClass == VarClass) && (rkClass == VarClass)) {
		id o[2];
		o[0] = [(EOQualifierVariable *)self->leftKey  key];
		o[1] = [(EOQualifierVariable *)self->rightKey key];
		return [NSArray arrayWithObjects:o count:2];
	}
	
	if (lkClass == VarClass)
		return [NSArray arrayWithObject:[(EOQualifierVariable *)self->leftKey key]];
	if (rkClass == VarClass) {
		return [NSArray arrayWithObject:
			[(EOQualifierVariable *)self->rightKey key]];
	}
	return [NSArray array];
}

/* keys */

- (void)addQualifierKeysToSet:(NSMutableSet *)_keys {
	/* new in WO 4.5 */
	[_keys addObject:self->leftKey];
	[_keys addObject:self->rightKey];
}

/* evaluation */

- (BOOL)evaluateWithObject:(id)_object inEvalContext:(id)_ctx {
	id   lv, rv;
	BOOL (*m)(id, SEL, id);
	
	if (_ctx == nil)
		_ctx = [NSMutableDictionary dictionaryWithCapacity:16];
	
	if ((lv = [(NSDictionary *)_ctx objectForKey:self->leftKey]) == nil) {
		lv = [_object valueForKeyPath:self->leftKey];
		if (lv == nil) lv = null;
		[(NSMutableDictionary *)_ctx setObject:lv forKey:self->leftKey];
	}
	if ((rv = [(NSDictionary *)_ctx objectForKey:self->rightKey]) == nil) {
		rv = [_object valueForKeyPath:self->rightKey];
		if (rv == nil) rv = null;
		[(NSMutableDictionary *)_ctx setObject:rv forKey:self->rightKey];
	}
	
	if ((m = (void *)[(NSObject *)lv methodForSelector:self->operator]) == NULL) {
		/* no such operator method ! */
		[lv doesNotRecognizeSelector:self->operator];
		return NO;
	}
	
	return m(lv, self->operator, rv);
}
- (BOOL)evaluateWithObject:(id)_object {
	return [self evaluateWithObject:_object inEvalContext:nil];
}

/* NSCoding */

- (void)encodeWithCoder:(NSCoder *)_coder {
	[super encodeWithCoder:_coder];
	if ([_coder allowsKeyedCoding]) {
		[_coder encodeObject:self->leftKey forKey:@"leftKey"];
		[_coder encodeObject:self->rightKey forKey:@"rightKey"];
		[_coder encodeObject:NSStringFromSelector(self->operator) forKey:@"operator"];
	} else {
		[_coder encodeObject:self->leftKey];
		[_coder encodeObject:self->rightKey];
		[_coder encodeValueOfObjCType:@encode(SEL) at:&(self->operator)];
	}
}

- (id)initWithCoder:(NSCoder *)_coder 
{
	self = [super initWithCoder:_coder];	
	if ([_coder allowsKeyedCoding]) {
		self->leftKey  = [[_coder decodeObjectForKey:@"leftKey"] retain];
		self->rightKey = [[_coder decodeObjectForKey:@"rightKey"] retain];
		self->operator = NSSelectorFromString([_coder decodeObjectForKey:@"operator"]);
	} else {
		self->leftKey  = [[_coder decodeObject] copyWithZone:[self zone]];
		self->rightKey = [[_coder decodeObject] copyWithZone:[self zone]];
		[_coder decodeValueOfObjCType:@encode(SEL) at:&(self->operator)];
	}
	return self;
}

/* Comparing */

- (BOOL)isEqualToQualifier:(EOQualifier *)_qual {
	if (![self->leftKey isEqual:[(EOKeyComparisonQualifier *)_qual leftKey]])
		return NO;
	if (![self->rightKey isEqual:[(EOKeyComparisonQualifier *)_qual rightKey]])
		return NO;
	if (sel_eq(self->operator, [(EOKeyComparisonQualifier *)_qual selector]))
		return YES;
	return NO;
}

/* description */

- (NSString *)description {
	NSMutableString *s;
	
	s = [NSMutableString stringWithCapacity:64];
	[s appendString:self->leftKey];
	[s appendString:@" "];
	[s appendString:[EOQualifier stringForOperatorSelector:self->operator]];
	[s appendString:@" "];
	[s appendString:self->rightKey];
	return s;
}

#pragma mark <EOKeyValueArchiving>

- (id)initWithKeyValueUnarchiver:(EOKeyValueUnarchiver *)_unarchiver {
    NSString *s;
    
    self->leftKey  = [[_unarchiver decodeObjectForKey:@"leftKey"]  retain];
    self->rightKey = [[_unarchiver decodeObjectForKey:@"rightKey"] retain];
    
    if ((s = [_unarchiver decodeObjectForKey:@"selectorName"]) != nil) {
        if (![s hasSuffix:@":"]) s = [s stringByAppendingString:@":"];
        self->operator = NSSelectorFromString(s);
    }
    else if ((s = [_unarchiver decodeObjectForKey:@"selector"]) != nil)
        self->operator = NSSelectorFromString(s);

    return self;
}

- (void)encodeWithKeyValueArchiver:(EOKeyValueArchiver *)_archiver {
    NSString *s;
    
    [_archiver encodeObject:[self leftKey]  forKey:@"leftKey"];
    [_archiver encodeObject:[self rightKey] forKey:@"rightKey"];
    
    s = NSStringFromSelector([self selector]);
    if ([s hasSuffix:@":"]) s = [s substringToIndex:[s length] - 1];
    [_archiver encodeObject:s forKey:@"selectorName"];
}

@end /* EOKeyComparisonQualifier */
