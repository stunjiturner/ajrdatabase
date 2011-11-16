// _DBModelAdaptorPane_EOArchive_English.java
// Generated by EnterpriseObjects palette at Thursday, October 7, 2004 1:02:12 PM US/Central

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

public class _DBModelAdaptorPane_EOArchive_English extends com.webobjects.eoapplication.EOArchive {
    com.webobjects.eointerface.swing.EOTable _nsTableView0;
    com.webobjects.eointerface.swing.EOTable._EOTableColumn _eoTableColumn0;
    com.webobjects.eointerface.swing.EOTextField _nsTextField0;
    com.webobjects.eointerface.swing.EOView _nsBox0, _nsBox1, _nsCustomView0, _nsCustomView1;
    javax.swing.JButton _nsButton0, _nsButton1;

    public _DBModelAdaptorPane_EOArchive_English(Object owner, NSDisposableRegistry registry) {
        super(owner, registry);
    }

    protected void _construct() {
        Object owner = _owner();
        EOArchive._ObjectInstantiationDelegate delegate = (owner instanceof EOArchive._ObjectInstantiationDelegate) ? (EOArchive._ObjectInstantiationDelegate)owner : null;
        Object replacement;

        super._construct();


        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "view")) != null)) {
            _nsCustomView1 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (com.webobjects.eointerface.swing.EOView)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsCustomView1");
        } else {
            _nsCustomView1 = (com.webobjects.eointerface.swing.EOView)_registered(new com.webobjects.eointerface.swing.EOView(), "View");
        }

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "syncButton")) != null)) {
            _nsButton1 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (javax.swing.JButton)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsButton1");
        } else {
            _nsButton1 = (javax.swing.JButton)_registered(new javax.swing.JButton("Sync Adaptor"), "NSButton1");
        }

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "adaptorTable")) != null)) {
            _nsTableView0 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (com.webobjects.eointerface.swing.EOTable)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsTableView0");
        } else {
            _nsTableView0 = (com.webobjects.eointerface.swing.EOTable)_registered(new com.webobjects.eointerface.swing.EOTable(), "NSTableView");
        }

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "connectionBox")) != null)) {
            _nsBox1 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (com.webobjects.eointerface.swing.EOView)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsBox1");
        } else {
            _nsBox1 = (com.webobjects.eointerface.swing.EOView)_registered(new com.webobjects.eointerface.swing.EOView(), "NSBox");
        }

        _nsTextField0 = (com.webobjects.eointerface.swing.EOTextField)_registered(new com.webobjects.eointerface.swing.EOTextField(), "NSTextField2");

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "noneView")) != null)) {
            _nsCustomView0 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (com.webobjects.eointerface.swing.EOView)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsCustomView0");
        } else {
            _nsCustomView0 = (com.webobjects.eointerface.swing.EOView)_registered(new com.webobjects.eointerface.swing.EOView(), "None View");
        }

        if ((delegate != null) && ((replacement = delegate.objectForOutletPath(this, "testButton")) != null)) {
            _nsButton0 = (replacement == EOArchive._ObjectInstantiationDelegate.NullObject) ? null : (javax.swing.JButton)replacement;
            _replacedObjects.setObjectForKey(replacement, "_nsButton0");
        } else {
            _nsButton0 = (javax.swing.JButton)_registered(new javax.swing.JButton("Test Connection"), "NSButton");
        }

        _eoTableColumn0 = (com.webobjects.eointerface.swing.EOTable._EOTableColumn)_registered(new com.webobjects.eointerface.swing.EOTable._EOTableColumn(), "NSTableColumn");
        _nsBox0 = (com.webobjects.eointerface.swing.EOView)_registered(new com.webobjects.eointerface.swing.EOView(), "NSView");
    }

    protected void _awaken() {
        super._awaken();

        if (_replacedObjects.objectForKey("_nsCustomView1") == null) {
            _connect(_owner(), _nsCustomView1, "view");
        }

        if (_replacedObjects.objectForKey("_nsButton0") == null) {
            _connect(_owner(), _nsButton0, "testButton");
        }

        _nsButton1.addActionListener((com.webobjects.eointerface.swing.EOControlActionAdapter)_registered(new com.webobjects.eointerface.swing.EOControlActionAdapter(_owner(), "syncAdaptor", _nsButton1), ""));

        if (_replacedObjects.objectForKey("_nsButton1") == null) {
            _connect(_owner(), _nsButton1, "syncButton");
        }

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _connect(_nsTableView0, _owner(), "dataSource");
        }

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _connect(_nsTableView0, _owner(), "delegate");
        }

        _nsTableView0.addActionListener((com.webobjects.eointerface.swing.EOControlActionAdapter)_registered(new com.webobjects.eointerface.swing.EOControlActionAdapter(_owner(), "selectAdaptor", _nsTableView0), ""));

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _connect(_owner(), _nsTableView0, "adaptorTable");
        }

        if (_replacedObjects.objectForKey("_nsBox1") == null) {
            _connect(_owner(), _nsBox1, "connectionBox");
        }

        if (_replacedObjects.objectForKey("_nsCustomView0") == null) {
            _connect(_owner(), _nsCustomView0, "noneView");
        }

        _nsButton0.addActionListener((com.webobjects.eointerface.swing.EOControlActionAdapter)_registered(new com.webobjects.eointerface.swing.EOControlActionAdapter(_owner(), "testSettings", _nsButton0), ""));
    }

    protected void _init() {
        super._init();

        if (_replacedObjects.objectForKey("_nsCustomView1") == null) {
            if (!(_nsCustomView1.getLayout() instanceof EOViewLayout)) { _nsCustomView1.setLayout(new EOViewLayout()); }
            _nsTableView0.setSize(260, 99);
            _nsTableView0.setLocation(10, 10);
            ((EOViewLayout)_nsCustomView1.getLayout()).setAutosizingMask(_nsTableView0, EOViewLayout.MinYMargin);
            _nsCustomView1.add(_nsTableView0);
            _nsBox1.setSize(266, 279);
            _nsBox1.setLocation(7, 118);
            ((EOViewLayout)_nsCustomView1.getLayout()).setAutosizingMask(_nsBox1, EOViewLayout.MinYMargin);
            _nsCustomView1.add(_nsBox1);
            _nsButton0.setSize(106, 22);
            _nsButton0.setLocation(10, 399);
            ((EOViewLayout)_nsCustomView1.getLayout()).setAutosizingMask(_nsButton0, EOViewLayout.MinYMargin);
            _nsCustomView1.add(_nsButton0);
            _nsButton1.setSize(106, 22);
            _nsButton1.setLocation(167, 399);
            ((EOViewLayout)_nsCustomView1.getLayout()).setAutosizingMask(_nsButton1, EOViewLayout.MinYMargin);
            _nsCustomView1.add(_nsButton1);
        }

        if (_replacedObjects.objectForKey("_nsButton1") == null) {
            _setFontForComponent(_nsButton1, "Lucida Grande", 11, Font.PLAIN);
            _nsButton1.setMargin(new Insets(0, 2, 0, 2));
        }

        if (_replacedObjects.objectForKey("_nsTableView0") == null) {
            _nsTableView0.table().addColumn(_eoTableColumn0);
            _setFontForComponent(_nsTableView0.table().getTableHeader(), "Lucida Grande", 11, Font.PLAIN);
            _nsTableView0.table().setRowHeight(17);
        }

        if (_replacedObjects.objectForKey("_nsBox1") == null) {
            if (!(_nsBox1.getLayout() instanceof EOViewLayout)) { _nsBox1.setLayout(new EOViewLayout()); }
            _nsBox0.setSize(262, 262);
            _nsBox0.setLocation(2, 15);
            ((EOViewLayout)_nsBox1.getLayout()).setAutosizingMask(_nsBox0, EOViewLayout.MinYMargin);
            _nsBox1.add(_nsBox0);
            _nsBox1.setBorder(new com.webobjects.eointerface.swing._EODefaultBorder("Connection Settings", true, "Lucida Grande", 11, Font.PLAIN));
        }

        _setFontForComponent(_nsTextField0, "Lucida Grande", 13, Font.PLAIN);
        _nsTextField0.setEditable(false);
        _nsTextField0.setOpaque(false);
        _nsTextField0.setText("You do not currently have an adaptor selected, so there are no connection settings. Please select an adaptor from the above list, and then set the connection settings appropriate to that adaptor.");
        _nsTextField0.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        _nsTextField0.setSelectable(false);
        _nsTextField0.setEnabled(true);
        _nsTextField0.setBorder(null);

        if (_replacedObjects.objectForKey("_nsCustomView0") == null) {
            if (!(_nsCustomView0.getLayout() instanceof EOViewLayout)) { _nsCustomView0.setLayout(new EOViewLayout()); }
            _nsTextField0.setSize(228, 104);
            _nsTextField0.setLocation(18, 69);
            ((EOViewLayout)_nsCustomView0.getLayout()).setAutosizingMask(_nsTextField0, EOViewLayout.MinYMargin);
            _nsCustomView0.add(_nsTextField0);
        }

        if (_replacedObjects.objectForKey("_nsButton0") == null) {
            _setFontForComponent(_nsButton0, "Lucida Grande", 11, Font.PLAIN);
            _nsButton0.setMargin(new Insets(0, 2, 0, 2));
        }

        _eoTableColumn0.setMinWidth(40);
        _eoTableColumn0.setMaxWidth(1000);
        _eoTableColumn0.setPreferredWidth(240);
        _eoTableColumn0.setWidth(240);
        _eoTableColumn0.setResizable(true);
        _eoTableColumn0.setHeaderValue("");
        if ((_eoTableColumn0.getHeaderRenderer() != null)) {
        	((DefaultTableCellRenderer)(_eoTableColumn0.getHeaderRenderer())).setHorizontalAlignment(javax.swing.JTextField.LEFT);
        }
    }
}