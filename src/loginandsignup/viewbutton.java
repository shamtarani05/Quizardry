/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandsignup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author LENOVO
 */
public class viewbutton extends JButton {
   private boolean mousepress;
    public viewbutton()
    {        
     setContentAreaFilled(false);
     setBorder(new EmptyBorder(3,3,3,3));
     addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent me)
            {
                mousepress = true;
              //  super.mousePressed(me);
            }
            public void mouseReleased(MouseEvent me)
            {
                mousepress = false;
               // super.mouseReleased(me);
            }
        });
    }
     
     protected void paintComponent(Graphics g)
     {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D)g.create();
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON );
         int width = getWidth();
         int height = getHeight();
         int size=Math.min(width, height);
         int x = (width-size)/2;
         int y = (height - size)/2;
         if(mousepress)
         {
             g2.setColor(new Color(158,158,158));
         }
         else
         {
             g2.setColor(new Color (199,199,199));
         }
         g2.fill(new Ellipse2D.Double(x,y,size,size));
         g2.dispose();
         super.paintComponent(g);
     
         
     }
    
}
    

