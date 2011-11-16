// _DBUserInfoPane_EOArchive_English.java
// Generated by EnterpriseObjects palette at Thursday, September 30, 2004 4:05:42 PM US/Central

import com.webobjects.eoapplication.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eointerface.*;
import com.webobjects.eointerface.swing.*;
import com.webobjects.eointerface.swing.EOTable._EOTableColumn;
import com.webobjects.foundation.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.text.*;

public class _DBUserInfoPane_EOArchive_English extends com.webobjects.eoapplication.EOArchive {
    com.webobjects.eointerface.swing.EOTable _nsTableView0;
    com.webobjects.eointerface.swing.EOTable._EOTableColumn _eoTableColumn0, _eoTableColumn1;
    com.webobjects.eointerface.swing.EOTextArea _nsTextView0;
    com.webobjects.eointerface.swing.EOView _nsCustomView0, _nsSplitView0;
    javax.swing.JButton _nsButton0, _nsButton1;

    public _DBUserInfoPane_EOArchive_English(Object owner, NSDisposableRegistry registry) {
        super(owner, registry);
    }

    protected void _construct() {
        Object owner = _owner();
        EOArchive._ObjectInstantiationDelegate delegate = (owner instanceof EOArchive._ObjectInstantiationDelegate) ? (EOArchive._ObjectInstantiationDelegate)owner : null;
        Object replacement;

        super._construct();

        _eoTableColumn1 = (com.webobjects.eointerface.swing.EOTable._EOTableColumn)_registered(new com.webobjects.eointerface.swing.EOTable._EOTableColumn(), "NSTableColumn1");
        _eoTableColumn0 = (com.webobjects.eointerface.swing.EOTable._EOTableColumn)_registered(new com.webobjects.eointerface.swing.EOTable._EOTableColumn(), "NSTableColumn");

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "removeButton.nextFocusableComponent.nextFocusableComponent.nextFocusableComponent")) != null)) {
            _nsTableView0 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (com.webobjects.eointerface.swing.EOTable)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsTableView0");
        } else {
            _nsTableView0 = (com.webobjects.eointerface.swing.EOTable)_registered(new com.webobjects.eointerface.swing.EOTable(), "NSTableView");
        }

        _nsSplitView0 = (com.webobjects.eointerface.swing.EOView)_registered(new com.webobjects.eointerface.swing.EOView(), "");

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "removeButton.nextFocusableComponent")) != null)) {
            _nsButton1 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (javax.swing.JButton)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsButton1");
        } else {
            _nsButton1 = (javax.swing.JButton)_registered(new javax.swing.JButton("Add"), "NSButton");
        }

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "removeButton")) != null)) {
            _nsButton0 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (javax.swing.JButton)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsButton0");
        } else {
            _nsButton0 = (javax.swing.JButton)_registered(new javax.swing.JButton("Remove"), "NSButton1");
        }

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "removeButton.nextFocusableComponent.nextFocusableComponent")) != null)) {
            _nsCustomView0 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (com.webobjects.eointerface.swing.EOView)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsCustomView0");
        } else {
            _nsCustomView0 = (com.webobjects.eointerface.swing.EOView)_registered(new com.webobjects.eointerface.swing.EOView(), "User Info");
        }

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "keyValueTable.nextFocusableComponent")) != null)) {
            _nsTextView0 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (com.webobjects.eointerface.swing.EOTextArea)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsTextView0");
        } else {
            _nsTextView0 = (com.webobjects.eointerface.swing.EOTextArea)_registered(new com.webobjects.eointerface.swing.EOTextArea(), "NSTextView");
        }
    }

    protected void _awaken() {
        super._awaken();

        if (_replacedObjects.objectForKey("_nsTextView0") == null) {
            _connect(_owner(), _nsTextView0, "valueText");
        }

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _connect(_owner(), _nsTableView0, "keyValueTable");
        }

        _nsTableView0.addActionListener((com.webobjects.eointerface.swing.EOControlActionAdapter)_registered(new com.webobjects.eointerface.swing.EOControlActionAdapter(_owner(), "selectRow", _nsTableView0), ""));

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _connect(_nsTableView0, _owner(), "dataSource");
        }

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _connect(_nsTableView0, _owner(), "delegate");
        }

        if (_replacedObjects.objectForKey("_nsButton0") == null) {
            _connect(_owner(), _nsButton0, "removeButton");
        }

        _nsButton0.addActionListener((com.webobjects.eointerface.swing.EOControlActionAdapter)_registered(new com.webobjects.eointerface.swing.EOControlActionAdapter(_owner(), "remove", _nsButton0), ""));

        if (_replacedObjects.objectForKey("_nsButton1") == null) {
            _connect(_owner(), _nsButton1, "addButton");
        }

        _nsButton1.addActionListener((com.webobjects.eointerface.swing.EOControlActionAdapter)_registered(new com.webobjects.eointerface.swing.EOControlActionAdapter(_owner(), "add", _nsButton1), ""));

        if (_replacedObjects.objectForKey("_nsCustomView0") == null) {
            _connect(_owner(), _nsCustomView0, "view");
        }

        if (_replacedObjects.objectForKey("_nsTextView0") == null) {
            _connect(_nsTextView0, _owner(), "delegate");
        }
    }

    protected void _init() {
        super._init();
        _connect(_nsTableView0, _nsTextView0, "nextFocusableComponent");

        if (_replacedObjects.objectForKey("_nsCustomView0") == null) {
            _connect(_nsCustomView0, _nsTableView0, "nextFocusableComponent");
        }

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _connect(_nsTableView0, _nsTextView0, "nextFocusableComponent");
        }

        _eoTableColumn1.setMinWidth(41);
        _eoTableColumn1.setMaxWidth(1000);
        _eoTableColumn1.setPreferredWidth(165);
        _eoTableColumn1.setWidth(165);
        _eoTableColumn1.setResizable(true);
        _eoTableColumn1.setHeaderValue("Value");
        _eoTableColumn0.setMinWidth(40);
        _eoTableColumn0.setMaxWidth(1000);
        _eoTableColumn0.setPreferredWidth(72);
        _eoTableColumn0.setWidth(72);
        _eoTableColumn0.setResizable(true);
        _eoTableColumn0.setHeaderValue("Key");

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _nsTableView0.table().addColumn(_eoTableColumn0);
            _nsTableView0.table().addColumn(_eoTableColumn1);
            _setFontForComponent(_nsTableView0.table().getTableHeader(), "Lucida Grande", 11, Font.PLAIN);
            _nsTableView0.table().setRowHeight(17);
        }

        if (!(_nsSplitView0.getLayout() instanceof EOViewLayout)) { _nsSplitView0.setLayout(new EOViewLayout()); }
        _nsTableView0.setSize(260, 302);
        _nsTableView0.setLocation(0, 0);
        ((EOViewLayout)_nsSplitView0.getLayout()).setAutosizingMask(_nsTableView0, EOViewLayout.MinYMargin);
        _nsSplitView0.add(_nsTableView0);
        _nsTextView0.setSize(260, 72);
        _nsTextView0.setLocation(0, 311);
        ((EOViewLayout)_nsSplitView0.getLayout()).setAutosizingMask(_nsTextView0, EOViewLayout.MinYMargin);
        _nsSplitView0.add(_nsTextView0);
        _connect(_nsTextView0, _nsButton0, "nextFocusableComponent");

        if (_replacedObjects.objectForKey("_nsButton1") == null) {
            _connect(_nsButton1, _nsCustomView0, "nextFocusableComponent");
        }

        if (_replacedObjects.objectForKey("_nsButton1") == null) {
            _setFontForComponent(_nsButton1, "Lucida Grande", 11, Font.PLAIN);
            _nsButton1.setMargin(new Insets(0, 2, 0, 2));
        }

        if (_replacedObjects.objectForKey("_nsButton0") == null) {
            _connect(_nsButton0, _nsButton1, "nextFocusableComponent");
        }

        if (_replacedObjects.objectForKey("_nsButton0") == null) {
            _setFontForComponent(_nsButton0, "Lucida Grande", 11, Font.PLAIN);
            _nsButton0.setMargin(new Insets(0, 2, 0, 2));
        }

        if (_replacedObjects.objectForKey("_nsCustomView0") == null) {
            if (!(_nsCustomView0.getLayout() instanceof EOViewLayout)) { _nsCustomView0.setLayout(new EOViewLayout()); }
            _nsButton0.setSize(91, 22);
            _nsButton0.setLocation(82, 399);
            ((EOViewLayout)_nsCustomView0.getLayout()).setAutosizingMask(_nsButton0, EOViewLayout.MinYMargin);
            _nsCustomView0.add(_nsButton0);
            _nsSplitView0.setSize(260, 383);
            _nsSplitView0.setLocation(10, 10);
            ((EOViewLayout)_nsCustomView0.getLayout()).setAutosizingMask(_nsSplitView0, EOViewLayout.MinYMargin);
            _nsCustomView0.add(_nsSplitView0);
            _nsButton1.setSize(91, 22);
            _nsButton1.setLocation(182, 399);
            ((EOViewLayout)_nsCustomView0.getLayout()).setAutosizingMask(_nsButton1, EOViewLayout.MinYMargin);
            _nsCustomView0.add(_nsButton1);
        }

        if (_replacedObjects.objectForKey("_nsTextView0") == null) {
            _nsTextView0.setEditable(true);
            _nsTextView0.setOpaque(true);
            _nsTextView0.setText("");
        }
    }
}