/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_resort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

/**
 *
 * @author shiv
 */
public class User extends JFrame{
Connection conn=null;

    public User() {   conn=SqlDatabase.dbconnet();
        setVisible(true);
    setTitle("Costumer panel || OM SAI VILLA RESORT ");
    setSize(600,600);
    setLocationRelativeTo(null);
    setResizable(false);
    
    JLabel background1 = new JLabel(new ImageIcon("image\\bg1.png")); 

add(background1);
background1.setBounds(0, 0, 600, 600);
background1.setLayout(null);
 JButton back = new JButton();   
   JPanel p = new JPanel();
   background1.add(p);
   
   p.setOpaque(false);
   p.setBounds(0, 0, 600, 600);
   p.setLayout(null);
    JPanel p1 = new JPanel();
   p.add(p1);
   p.add(back);
   back.setBounds(500,30,50,50);
  // p1.setBackground( Color.red);
   
   //p1.setOpaque();
   p1.setBounds(20, 115, 210, 260);
   p1.setLayout(null);
   JLabel newlbl  = new JLabel("<html><font size= 3>ADD USER</font></html>");
   JLabel namelbl  = new JLabel("Name");
   JTextField nametxt = new JTextField();
   JLabel idlbl  = new JLabel("Id");
   JTextField idtxt = new JTextField();
   JLabel adminidlbl  = new JLabel("Admin Id");
   JTextField adminidtxt = new JTextField();
   JLabel passlbl  = new JLabel("Password");
   JTextField passtxt = new JTextField();
   JLabel Dellbl  = new JLabel("<html><font size= 7>DELETE</font></html>");
   JLabel Namelbl  = new JLabel("Name");
   JTextField Nametxt = new JTextField();
   JButton add1btn = new JButton(new ImageIcon("image\\add.png"));
   
   p1.add(newlbl);
   p1.add(namelbl); p1.add(nametxt);
   p1.add(idlbl); p1.add(idtxt);
   p1.add(passlbl);p1.add(passtxt);
   p1.add(Dellbl);
   p1.add(Namelbl);p1.add(Nametxt);
   p1.add(add1btn);
   p1.add(adminidtxt);p1.add(adminidlbl);
   newlbl.setBounds(50, 13, 80, 30);namelbl.setBounds(30, 58, 80, 24);nametxt.setBounds(92, 58, 80, 24);
   idlbl.setBounds(30, 91, 80, 24);
   idtxt.setBounds(92, 91, 80, 24);
   adminidlbl.setBounds(30, 124, 80, 24);
   adminidtxt.setBounds(92, 124, 80, 24);
passlbl.setBounds(30, 157, 80, 24);passtxt.setBounds(92, 157, 80, 24);


   add1btn.setBounds(40, 190, 50, 50);
   
   
   
   
   
   

JPanel p2 = new JPanel();
   p.add(p2);
   
   //p2.setBackground( Color.red);
   
   //p1.setOpaque();
   p2.setBounds(20, 390, 210, 170);
   p2.setLayout(null);
   JLabel newp2lbl  = new JLabel("<html><font size= 3>REMOVE USER</font></html>");
   JLabel namep2lbl  = new JLabel("Name");
JTextField namep2txt = new JTextField();
JButton add1p2btn = new JButton(new ImageIcon("image\\remove.png"));

p2.add(newp2lbl);
   p2.add(namep2lbl); p2.add(namep2txt);p2.add(add1p2btn);
   
   
   
   newp2lbl.setBounds(30, 15, 110, 30);namep2lbl.setBounds(30, 60, 80, 24);
   namep2txt.setBounds(85, 60, 80, 24);
   add1p2btn.setBounds(50, 93, 50, 50);
   
   
   
   JTable logtbl =new JTable();
   JLabel lbl  = new JLabel("<html><font size= 7>USER DETAILS</font></html>");
   
   JScrollPane sp=new JScrollPane(logtbl,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
   
   p.add(sp);
   p.add(lbl);
   lbl.setBounds(230,60,450,45);
   sp.setBounds(250,115,330,445);
   
   
        try{
            
            String query="select* from Login ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            logtbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
        
        
        
        
        
        
        
     add1btn.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
             try{
            
            String query="insert into Login (Name, Id, Admin_Id, Password) values (? ,? ,? ,? )";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,nametxt.getText()); 
            pst.setString(2,idtxt.getText()); 
            pst.setString(3,adminidtxt.getText()); 
            pst.setString(4,passtxt.getText()); 
            pst.executeUpdate();
            
             
             
           pst.close();
         
            }
            catch(Exception e){    
            System.out.println(e);
            }
        try{
            
            String query="select* from Login ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            logtbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
        }});
        
             
             
             
             
             add1p2btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try{
             String query="DELETE FROM Login where Name='"+namep2txt.getText()+"'";
            PreparedStatement pst = conn.prepareStatement(query); 

            pst.executeUpdate();
            //t.setModel(DbUtils.resultSetToTableModel(rs));
         
         
         pst.close();
      }
            catch(Exception e){System.out.println(e);} 
            
                try{
            
            String query="select* from Login ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            logtbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
                
            }});
    
        
        
        
        
        
        
        
        
        addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
        dispose();
   
}});
        
   

        
        
    }
    
}
             
