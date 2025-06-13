/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandsignup;

/**
 *
 * @author LENOVO
 */

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class TableActionCell_Click extends DefaultCellEditor {
    

    private Tableactionevent event;
    protected ClickAction clickbutton;

    public TableActionCell_Click(JCheckBox checkBox) {
        super(checkBox);
    }

    public TableActionCell_Click(Tableactionevent event) {
        super(new JCheckBox());
        this.event = event;
        clickbutton = new ClickAction();
        clickbutton.setOpaque(true);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        clickbutton.initEvent(event, row);
        clickbutton.setBackground(table.getSelectionBackground());
        return clickbutton;
    }
}

