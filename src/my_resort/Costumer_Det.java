/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_resort;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Costumer_Det extends JFrame{
    
    
Connection conn=null;
    public Costumer_Det() {
        conn=SqlDatabase.dbconnet();
        setVisible(true);
    setTitle("Costumer panel || OM SAI VILLA RESORT ");
    setSize(600,600);
    setLocationRelativeTo(null);
    setResizable(false);
    
    JLabel background1 = new JLabel(new ImageIcon("image\\bg1.png")); 

add(background1);
background1.setBounds(0, 0, 600, 600);
background1.setLayout(null);
    
   JPanel p = new JPanel();
   background1.add(p);
   
   p.setOpaque(false);
   p.setBounds(0, 0, 600, 600);
   p.setLayout(null);
   
   
   JTable cstbl =new JTable();
   JLabel lbl  = new JLabel("<html><font size= 7>COSTUMER DETAILS</font></html>");
   //cstbl.setBackground(new Color(204,2204,204));
   JScrollPane sp=new JScrollPane(cstbl,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
   cstbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
   p.add(sp);
   p.add(lbl);
   lbl.setBounds(130,60,450,45);
   sp.setBounds(30,120,540,400);
   
   
        try{
            
            String query="select* from customer ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            cstbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
        
        
        addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
        dispose();
   
}});
        
   
   
    }
    
}
