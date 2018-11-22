
package my_resort;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Employee extends JFrame {
Connection conn=null;

JButton back; 


    public Employee() {
       conn=SqlDatabase.dbconnet();
        setVisible(true);
    setTitle("Employee panel || OM SAI VILLA RESORT ");
    setSize(600,600);
    setLocationRelativeTo(null);
    setResizable(false);
    
    JLabel background1 = new JLabel(new ImageIcon("image\\bg1.png")); 

add(background1);
background1.setBounds(0, 0, 600, 600);
background1.setLayout(null);
    
   JPanel p = new JPanel();
   background1.add(p);
   JTable t =new JTable();
   JScrollPane sp3=new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
   p.setOpaque(false);
   p.setBounds(0, 0, 600, 600);
   p.setLayout(null);
   
   JPanel attnpnl = new JPanel();
   attnpnl.setOpaque(false);
   attnpnl.setBounds(0, 0, 600, 600);
   attnpnl.setLayout(null); 
   
   
   JPanel empnl = new JPanel();
   empnl.setOpaque(false);
   empnl.setBounds(0, 0, 600, 600);
   empnl.setLayout(null); 
   
   JButton attbtn  = new JButton(new ImageIcon("image\\attend.png"));
   JLabel attbtn1 = new JLabel("Attendance");
  JButton empdbtn  = new JButton(new ImageIcon("image\\emp.png"));
  JLabel empdbtn1 = new JLabel("Joining/Leaving");
  JLabel emplb = new JLabel("<html><font color= red  size= 7><u>EMPLOYEE DETAILS</u></font></html>");
   
   
   
   p.add(attbtn);
   p.add(empdbtn);
   p.add(attbtn1);
   p.add(empdbtn1);
   p.add(sp3);
   p.add(emplb);
   
   attbtn.setBounds(45,160,100,100);attbtn1.setBounds(56,220,100,100);
   empdbtn.setBounds(45,300,100,100);empdbtn1.setBounds(48,360,100,100);
   sp3.setBounds(200,110,379,400);emplb.setBounds(110,50,500,50);
   
   try{
            
            String query="select* from employee ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
         pst.close();
         rs.close();
         
         System.out.println("jhkjhj");
            }
            catch(Exception e){
            System.out.println(e);
            }
   
   
   JPanel attnpnl1 = new JPanel();
   attnpnl.add(attnpnl1);
   
   JLabel attn = new JLabel("<html><font size= 3>Enter Details</font></html>"); 
    JLabel namelbl = new JLabel("Employee name");JComboBox nametxt = new JComboBox();
    JDateChooser Date = new JDateChooser();JLabel Datelbl = new JLabel("Employee name");
    JLabel deslbl = new JLabel("Designation");JTextField cb = new JTextField();
    JButton atbtn = new JButton(new ImageIcon("image\\attend1.png"));cb.setEditable(false);
    String [] a = {"Present","Absent"};
    JComboBox status = new JComboBox(a);
    JLabel Status1 = new JLabel("Status");
    
     JTable atttbl =new JTable();
   JLabel attlbl  = new JLabel("<html><font size= 7>ATTENDANCE</font></html>");
   
   JScrollPane sp=new JScrollPane(atttbl,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
   
   
   
   
  
   
   
  
   
   String Query1 = "Select * from employee";
      try{
    PreparedStatement pst = conn.prepareStatement(Query1);
                    
                    ResultSet rs = pst.executeQuery();
                    while(rs.next())
                    {
                    String emnm= rs.getString("Name");
                    nametxt.addItem(emnm);

    }
                    pst.close();
                    rs.close();
    }
    catch(Exception et){}
      
      
      nametxt.addActionListener( new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
            
                String Query1 = "Select * from employee Where Name =?";
      try{
    PreparedStatement pst = conn.prepareStatement(Query1);
                    pst.setString(1, (String) nametxt.getItemAt(nametxt.getSelectedIndex()));
                    ResultSet rs = pst.executeQuery();
                    while(rs.next())
                    {
                    String emnm1= rs.getString("Designation");
                    cb.setText(emnm1);

    }
                    pst.close();
                    rs.close();
    }
    catch(Exception et){}
               
               
           }
       });
   
   
   
   
   
   back = new JButton(new ImageIcon("image\\back.png"));
   back.setBorder(null);
back.setContentAreaFilled(false);
   attnpnl1.setBounds(10,80,580,110);
   attnpnl1.setLayout(null);
   
   
   attnpnl1.add(namelbl);
   attnpnl1.add(nametxt);
   attnpnl1.add(atbtn);
   attnpnl1.add(Date);
   attnpnl1.add(attn);
   attnpnl1.add(deslbl);
   attnpnl1.add(cb);
   attnpnl1.add(status);
   attnpnl1.add(Status1);
   attnpnl1.add(Datelbl);
   attnpnl.add(sp);
   attnpnl.add(attlbl);
   attnpnl.add(back);
   attn.setBounds(210,15,100,25);
   namelbl.setBounds(20,40,100,20);nametxt.setBounds(125,40,100,20);
   deslbl.setBounds(20,70,100,20);cb.setBounds(125,70,100,20);
   Datelbl.setBounds(250,40,100,20);Date.setBounds(358,40,100,20);atbtn.setBounds(480,50,50,50);
   attlbl.setBounds(184,200,245,34);sp.setBounds(30,250,540,270);
   status.setBounds(358,70,100,20);Status1.setBounds(250,70,100,20);
   back.setBounds(520,25,50,50);
    try{
            
            String query="select* from attendance ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            atttbl.setModel(DbUtils.resultSetToTableModel(rs));
         pst.close();
         rs.close();
         
            }
            catch(Exception e){
            System.out.println(e);
            }
  


atbtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               String query ="Insert into attendance (EmployeeName,Designation,Date_Time,Status) values(?,?,?,?)";
                     try{
                     PreparedStatement pst = conn.prepareStatement(query);            
                      pst.setString(1, (String) nametxt.getItemAt(nametxt.getSelectedIndex()));
                     pst.setString(2,cb.getText());
                      LocalDateTime From =LocalDateTime.ofInstant(Date.getDate().toInstant(), ZoneId.systemDefault());
                      DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS");
                      
                      String date=dtf.format(From);
                      pst.setString(3,date);
                      pst.setString(4, (String) status.getItemAt(status.getSelectedIndex()));
                      pst.executeUpdate();
                      pst.close();
                      
                     
                     }catch(Exception ep){System.out.println(ep);}
                             
                             
                             try{
            
            String query1="select* from attendance ";
            PreparedStatement pst = conn.prepareStatement(query1);            
            ResultSet rs =pst.executeQuery();
            atttbl.setModel(DbUtils.resultSetToTableModel(rs));
         pst.close();
         rs.close();
         
            }
            catch(Exception ex){
            System.out.println(ex);
            }
           
           
           }
       });



back.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            background1.removeAll();
             background1.add(p);
             background1.validate();
            
             background1.repaint(); 
        } });

//*************************employee detils**************************************
   
      JPanel p1 = new JPanel();
   empnl.add(p1);
   back =new JButton(new ImageIcon("image\\back.png"));
   back.setBorder(null);
back.setContentAreaFilled(false);
   empnl.add(back);
   
  // p1.setBackground( Color.red);
   
   //p1.setOpaque();
   p1.setBounds(20, 100, 210, 300);
   p1.setLayout(null);
   JLabel newlbl  = new JLabel("<html><font size= 3>ADD EMPLOYEE</font></html>");
   JLabel empnamelbl  = new JLabel("Name");
   JTextField empnametxt = new JTextField();
   JLabel flbl  = new JLabel("Father Name");
   JTextField ftxt = new JTextField();
   JLabel adlbl  = new JLabel("Address");
   JTextField adtxt = new JTextField();
   JLabel deglbl  = new JLabel("Designation");
   JTextField degtxt = new JTextField();
   JLabel datelbl  = new JLabel("Joining date");
   JDateChooser datetxt = new JDateChooser();
   JLabel sslbl  = new JLabel("Salary");
   JTextField sstxt = new JTextField();
   JLabel Dellbl  = new JLabel("<html><font size= 7>RESIGN</font></html>");
   JLabel Namelbl  = new JLabel("Name");
   JTextField Nametxt = new JTextField();
   JButton add1btn = new JButton(new ImageIcon("image\\addemp.png"));
   
   p1.add(newlbl);
   p1.add(empnamelbl); p1.add(empnametxt);
   p1.add(flbl); p1.add(ftxt);
   p1.add(adlbl);p1.add(adtxt);
   p1.add(Dellbl);
   p1.add(Namelbl);p1.add(Nametxt);
   p1.add(add1btn);p1.add(sslbl);p1.add(sstxt);p1.add(datelbl);p1.add(datetxt);
   p1.add(adtxt);p1.add(adlbl); p1.add(deglbl);p1.add(degtxt);
   
   newlbl.setBounds(30, 5, 100, 30);empnamelbl.setBounds(30, 44, 80, 24);
   empnametxt.setBounds(100, 44, 100, 24);
   flbl.setBounds(30, 77, 80, 24);ftxt.setBounds(100, 77, 100, 24);
   adlbl.setBounds(30, 110, 80, 24);adtxt.setBounds(100, 110, 80, 24);
   deglbl.setBounds(30,143,80,24);degtxt.setBounds(100,143,100,24);
   datelbl.setBounds(30,176,80,24);datetxt.setBounds(100,176,100,24);
sslbl.setBounds(30, 209, 80, 24);sstxt.setBounds(100, 209, 100, 24);
back.setBounds(520,25,50,50);

   add1btn.setBounds(40, 240, 50, 50);
   
   
   
   
   
   

JPanel p2 = new JPanel();
   empnl.add(p2);
   
   //p2.setBackground( Color.red);
   
   //p1.setOpaque();
   p2.setBounds(20, 408, 210, 152);
   p2.setLayout(null);
   JLabel newp2lbl  = new JLabel("<html><font size= 3>RESIGN </font></html>");
   JLabel namep2lbl  = new JLabel("Name");
JTextField namep2txt = new JTextField();
JButton add1p2btn = new JButton(new ImageIcon("image\\delemp.png"));

p2.add(newp2lbl);
   p2.add(namep2lbl); p2.add(namep2txt);p2.add(add1p2btn);
   
   
   
   newp2lbl.setBounds(30, 10, 110, 30);namep2lbl.setBounds(30, 45, 80, 24);
   namep2txt.setBounds(85, 45, 80, 24);
   add1p2btn.setBounds(50, 80, 50, 50);
   
   
   
   JTable emptbl =new JTable();
   JLabel lbl  = new JLabel("<html><font size= 7>JOINING/LEAVING</font></html>");
   
   JScrollPane sp1=new JScrollPane(emptbl,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
   
   empnl.add(sp1);
   empnl.add(lbl);
   lbl.setBounds(140,50,450,35);
   sp1.setBounds(250,100,330,445);
   
   
        try{
            
            String query="select* from employee ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            emptbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
        
        
        
        
        
        
        
     add1btn.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
             
            
    DateTimeFormatter dtf =DateTimeFormatter.ofPattern("dd-MM-yyy");
 LocalDateTime   from =LocalDateTime.ofInstant(datetxt.getDate().toInstant(), ZoneId.systemDefault());
    String date=dtf.format(from);
            try{
            
            String query="insert into employee (Name, Father_name, Address,Designation,Date_join,Salary) values (? ,?,?,? ,? ,? )";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,empnametxt.getText()); 
            pst.setString(2,ftxt.getText()); 
            pst.setString(3,adtxt.getText()); 
            pst.setString(4,degtxt.getText()); 
            pst.setString(5,date); 
            pst.setString(6,sstxt.getText()); 
            pst.executeUpdate();
            
             
             
           pst.close();
         
            }
            catch(Exception e){    
            System.out.println(e);
            }
        try{
            
            String query="select* from employee ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            emptbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
        }});
        
             
             
             
             
             add1p2btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try{
             String query="DELETE FROM  employee where Name='"+namep2txt.getText()+"'";
            PreparedStatement pst = conn.prepareStatement(query); 

            pst.executeUpdate();
            //t.setModel(DbUtils.resultSetToTableModel(rs));
         
         
         pst.close();
      }
            catch(Exception e){System.out.println(e);} 
            
                try{
            
            String query="select* from employee ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            emptbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
                
            }});
 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  
  
  
  
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  attbtn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                background1.removeAll();
             background1.add(attnpnl);
             background1.validate();
            
             background1.repaint();    
            }
        });
  
  
  
  
  
//  JButton attbtn  = new JButton();
//  JButton attbtn  = new JButton();
   
   
   empdbtn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                background1.removeAll();
             background1.add(empnl);
             background1.validate();
            
             background1.repaint();    
            }
        }); 
    
    back.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            background1.removeAll();
             background1.add(p);
             background1.validate();
            
             background1.repaint(); 
        } });
    }
    
}
