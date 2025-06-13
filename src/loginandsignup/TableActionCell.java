package loginandsignup;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCell extends DefaultCellEditor {
    private Tableactionevent event;
    protected ActionButton actionButton;

    public TableActionCell(JCheckBox checkBox) {
        super(checkBox);
    }

    public TableActionCell(Tableactionevent event) {
        super(new JCheckBox());
        this.event = event;
        actionButton = new ActionButton();
        actionButton.setOpaque(true);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        actionButton.initEvent(event, row);
        actionButton.setBackground(table.getSelectionBackground());
        return actionButton;
    }
}
