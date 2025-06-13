/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandsignup;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author LENOVO
 */
public class TableActionCellRender extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent(JTable jtable , Object o ,boolean b,boolean b1 ,int row,int column){
    
     Component com = super.getTableCellRendererComponent(jtable, o, b, b1, row, column);
      ActionButton action = new ActionButton();
     if(b==false && row%2==0)
     {
         action.setBackground(Color.WHITE);
     }
     else
     {
     action.setBackground(com.getBackground());
     }
     return action;
    }
    
}
