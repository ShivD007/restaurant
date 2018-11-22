
package my_resort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Admin extends JFrame{
Connection conn = null;
    public Admin() {
        conn=SqlDatabase.dbconnet();
        setVisible(true);
    setTitle("Administration || OM SAI VILLA RESORT ");
    setSize(600,600);
    setLocationRelativeTo(null);
    setResizable(false);  
    
    
   JLabel background1 = new JLabel(new ImageIcon("image\\bg1.png")); 

add(background1);
background1.setBounds(0, 0, 600, 600);
background1.setLayout(null);
    
    
     setDefaultCloseOperation(EXIT_ON_CLOSE);   
        
       JPanel p = new JPanel();
   background1.add(p);
   
   p.setOpaque(false);
   p.setBounds(0, 0, 600, 600);
//    JButton back = new JButton("clear");
//     p.add(back);
    JLabel username = new JLabel("ID");
        JLabel password = new JLabel("Password");
     JTextField txt = new JTextField(50);
     JPasswordField txt1 = new JPasswordField(50);
     JButton login =new JButton("login");
     JButton back = new JButton(new ImageIcon("image\\back.png"));
      back.setBorder(null);
back.setContentAreaFilled(false);
     
     JPanel p1 = new JPanel();
   JButton emplbl = new JButton(new ImageIcon("image\\empdel.png"));
   JLabel emplbl1 = new JLabel("Employee Details");
   JButton Cstmelbl = new JButton(new ImageIcon("image\\cstdel.png"));
   JLabel Cstmelbl1 = new JLabel("Customer Details");
   JButton replbl = new JButton(new ImageIcon("image\\report.png"));
   JLabel replbl1 = new JLabel("Report");
   JButton userlbl = new JButton(new ImageIcon("image\\users.png"));
   JLabel userlbl1 = new JLabel("Apllication User");
   JButton logout = new JButton(new ImageIcon("image\\log.png"));
     
     p1.setBounds(0, 0, 600, 600);
     p1.setOpaque(false);
     
     p.setLayout(null);
     p.add(username);
     p.add(password);
     p.add(txt);
     p.add(txt1);
     p.add(login);
     p.add(back);
     
     
    p1.setLayout(null);
    p1.add(logout);
    p1.add(emplbl);
    p1.add(Cstmelbl);
    p1.add(replbl);
    p1.add(userlbl);
    p1.add(emplbl1);
    p1.add(Cstmelbl1);
    p1.add(replbl1);
    p1.add(userlbl1);
    
    
    
    
  
     
username.setBounds(155,180,20,10);
password.setBounds(155,230,60,10);
txt.setBounds(220,170,170,25);
txt1.setBounds(220,220,170,25);
login.setBounds(300,280,70,23);
back.setBounds(500,30,50,50);
logout.setBounds(520,30,60,50); 
 logout.setBorder(null);
logout.setContentAreaFilled(false);   
    
emplbl.setBounds(50,240,100,100);emplbl1.setBounds(50,300,100,100);   
Cstmelbl.setBounds(170,240,100,100);Cstmelbl1.setBounds(170,300,100,100);
replbl.setBounds(290,240,100,100);   replbl1.setBounds(324,300,100,100);  
userlbl.setBounds(410,240,100,100);  userlbl1.setBounds(410,300,100,100); 

    
    
    
emplbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            new Employee();     
            }
        });

Cstmelbl.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            new Costumer_Det();
            
            }
        });
        
 userlbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            new User();     
            }
        });    
        
 
 replbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            new Report();     
            }
        }); 
        
        
        
       
    
    
    
    
    
    
    
    
    
  login.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            try{
            
            String query="select* from Login where Admin_Id=? and Password=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,txt.getText());
            pst.setString(2,txt1.getText());
            ResultSet rs =pst.executeQuery();
            if(rs.next()) {           
              background1.removeAll();
             background1.add(p1);
             background1.validate();
            
             background1.repaint(); }   
       else
           JOptionPane.showMessageDialog( null,"incorrect");
            
            pst.close();
            rs.close();
            }
            
            
            catch(Exception e){}
        
 }});  
   
    back.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            new LoginPage();
             
            dispose();
        }
 });
              logout.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            new LoginPage();
             
            dispose();
        }
 });   
   
       
    }
    
}
