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
public class TableviewactionRender  extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent(JTable jtables , Object o1 ,boolean bclk,boolean b1clk ,int row,int column){
    
     Component com = super.getTableCellRendererComponent(jtables, o1, bclk, b1clk, row, column);
      viewbuttonaction actionview = new viewbuttonaction();
     if(bclk==false && row%2==0)
     {
         actionview.setBackground(Color.WHITE);
     }
     else
     {
     actionview.setBackground(com.getBackground());
     }
     return actionview;
    }
    
}
    

