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
public class TableactionCellRender_click  extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent(JTable jtables , Object o1 ,boolean bclk,boolean b1clk ,int row,int column){
    
     Component com = super.getTableCellRendererComponent(jtables, o1, bclk, b1clk, row, column);
      ClickAction action1 = new ClickAction();
     if(bclk==false && row%2==0)
     {
         action1.setBackground(Color.WHITE);
     }
     else
     {
     action1.setBackground(com.getBackground());
     }
     return action1;
    }
    
}
    
