
package my_resort;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import net.proteanit.sql.DbUtils;



public class Report extends JFrame  {
 Connection  conn;
 String date,date1; 
 
 
    public Report() {
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
JTable  t=new JTable();

JPanel p = new JPanel();
background1.add(p);
p.setLayout(null);
p.setBounds(0, 0, 600, 600);p.setOpaque(false);
JButton btn = new JButton(new ImageIcon("image\\rep.png"));

JDateChooser dp = new JDateChooser();
    JDateChooser dp1 = new JDateChooser();
    JLabel frm = new JLabel("From");
    JLabel too = new JLabel("To");
    JLabel replbl = new JLabel("<html><font color= red  size= 7><u>REPORT</u></font></html>");
    JScrollPane sp=new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    JLabel btnlbl = new JLabel("Get Details");
     
     p.add(btn);
     p.add(dp);
     p.add(dp1);
     p.add(sp);
     p.add(replbl);
     p.add(frm);
     p.add(too);
     p.add(btnlbl);
     
     replbl.setBounds(250,50,200,50);
     dp.setBounds(180,120,100,25);
     dp1.setBounds(410,120,100,25);
     sp.setBounds(50,250,500,280);
     btn.setBounds(310,170,50,50);
     btnlbl.setBounds(300,220,90,25);
             frm.setBounds(120,130,50,25);
     too.setBounds(350,130,50,25);
     
     
     
     
     
     
     
     
     
     System.out.println(date);
     
     
     try{
                    
            
            String query="select* from customer where Checkin >='"+date+"' and Checkin <= '"+date1+"'";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
            
     
     
     
   btn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    LocalDateTime from =LocalDateTime.ofInstant(dp.getDate().toInstant(), ZoneId.systemDefault());
    LocalDateTime to=LocalDateTime.ofInstant(dp1.getDate().toInstant(), ZoneId.systemDefault());
    DateTimeFormatter dtf =DateTimeFormatter.ofPattern("dd-MM-yyy");
    
      date=dtf.format(from);   
      date1=dtf.format(to); 
            
            String query="select* from customer where Checkin >='"+date+"' and Checkin <= '"+date1+"'";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
            }
        });
     
     
     
     
     
     
     
        
    }
    
}
