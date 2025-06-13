/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandsignup;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author LENOVO
 */
public class viewaction_cellEditor extends DefaultCellEditor {
    

    private Tableactionevent event;
    protected viewbuttonaction viewbutton;

    public viewaction_cellEditor(JCheckBox checkBox) {
        super(checkBox);
    }

    public  viewaction_cellEditor(Tableactionevent event) {
        super(new JCheckBox());
        this.event = event;
        viewbutton = new viewbuttonaction();
        viewbutton.setOpaque(true);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        viewbutton.initEvent(event, row);
        viewbutton.setBackground(table.getSelectionBackground());
        return viewbutton;
    }
}
    

