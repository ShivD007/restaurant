 


package my_resort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class BookPage {

    Connection conn = null; 
     JLabel Room ;
    JLabel Room1 ;
    JLabel Bed ;
    JLabel Check ;
    JLabel Check1;
    JLabel Days ;
    JTextField txt4, txt11,txt;
    
    String id ="GID";
      int idnum ; 
    public void BookPage1()   {
        
         conn=SqlDatabase.dbconnet();
        
        JFrame t = new JFrame();
         t.setVisible(true);
    t.setTitle("Booking page || OM SAI VILLA RESORT ");
    t.setSize(600,600);
    t.setLocationRelativeTo(null);
    t.setResizable(false);
    
     
    JPanel p = new JPanel();
    t.add(p);
    
    
    JLabel lbl = new JLabel("Guest Id");
    JLabel lbl1 = new JLabel("Name");
    JLabel lbl2 = new JLabel("Adress");
    JLabel lbl3 = new JLabel("City");
    JLabel lbl4 = new JLabel("State");
    JLabel lbl5 = new JLabel("Country");
    JLabel lbl6 = new JLabel("Mobile no.");
    
    JLabel lbl7 = new JLabel("ID Proof");
    JLabel lbl8 = new JLabel("ID Number");
    JLabel lbl9 = new JLabel("Members");
    
    JLabel lbl10 = new JLabel("Purpose");
    JLabel lbl11 = new JLabel("Cost(+GST)");
    JLabel lbl12 = new JLabel("Room no.");
    JLabel lbl13 = new JLabel("Room Type");
    JLabel lbl14 = new JLabel("Bed Type");
    JLabel lbl15 = new JLabel("Check in");
    JLabel lbl16 = new JLabel("Check out");
    JLabel lbl17 = new JLabel("Days");
   Room = new JLabel();
    Room1 = new JLabel();
    Bed = new JLabel();
    Check = new JLabel();
    Check1 = new JLabel();
    Days = new JLabel();
    
   
    
    JButton btn = new JButton("Save");
            

     txt = new JTextField();
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JTextField txt3 = new JTextField();
   txt4 = new JTextField();
    JTextField txt5 = new JTextField();
    JTextField txt6 = new JTextField();
    JTextField txt7 = new JTextField();
    JTextField txt8 = new JTextField();
    JTextField txt9 = new JTextField();
    JTextField txt10 = new JTextField();
    txt11 = new JTextField();
    JTextField txt12 = new JTextField();
    
    
        
    p.add(lbl);
    p.add(lbl1);
    p.add(lbl2);
    p.add(lbl3);
    p.add(lbl4);
    p.add(lbl5);
    p.add(lbl6);
    p.add(lbl7);
    p.add(lbl8);
   p.add(lbl9);
    p.add(lbl10);
    p.add(lbl11);
    p.add(lbl12);
    p.add(lbl13);p.add(lbl14);p.add(lbl15);p.add(lbl16);p.add(lbl17);p.add(Room);p.add(Room1);p.add(Bed);
    p.add(Check);p.add(Check1);
    p.add(Days);
   
    
    
    
    p.add(txt);
    p.add(txt1);
    p.add(txt2);
    p.add(txt3);
    p.add(txt4);
    p.add(txt5);
    p.add(txt6);
    p.add(txt7);
    p.add(txt8);
    p.add(txt9);
    p.add(txt10);
    p.add(txt11);
    p.add(btn);
    
    p.setLayout(null);
    
    lbl.setBounds(30,20,100,20);
    lbl1.setBounds(30,60,100,20);
    lbl2.setBounds(30,100,100,20);
    lbl3.setBounds(30,140,100,20);
    lbl4.setBounds(30,180,100,20);
    lbl5.setBounds(30,220,100,20);
    lbl6.setBounds(30,260,100,20);lbl7.setBounds(30,300,100,20);
    lbl8.setBounds(30,340,100,20);
    lbl9.setBounds(30,380,100,20);lbl10.setBounds(30,420,100,20);
    lbl11.setBounds(30,460,100,20);lbl12.setBounds(400,20,100,20);
    lbl13.setBounds(400,60,100,20);
    lbl14.setBounds(400,100,100,20);
    lbl15.setBounds(400,140,100,20);
    lbl16.setBounds(400,180,100,20);lbl17.setBounds(400,220,80,20);
    Room.setBounds(500,20,50,20);
    Room1.setBounds(500,60,50,20);
    Bed.setBounds(500,100,50,20);
    Check.setBounds(500,140,100,20);
    Check1.setBounds(500,180,100,20);Days.setBounds(500,220,50,20);
    
    
    
    
    
    txt.setBounds(150, 20, 200, 20);
    txt1.setBounds(150, 60, 200, 20);
    txt2.setBounds(150, 100, 200, 20);
    txt3.setBounds(150, 140, 200, 20);
    txt4.setBounds(150, 180, 200, 20);
    txt5.setBounds(150, 220, 200, 20);
    txt6.setBounds(150, 260, 200, 20);
    txt7.setBounds(150, 300, 200, 20);
    txt8.setBounds(150, 340, 200, 20);
    txt9.setBounds(150, 380, 200, 20);
    
      txt10.setBounds(150, 420, 200, 20);txt11.setBounds(150, 460, 200, 20);btn.setBounds(150, 500, 200, 20);
      txt11.setEditable(false);
      txt.setEditable(false);
           
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   
    btn.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            
            
            
            
            
            
            
            
            
            
             String Query = "Select Price from Room Where Room_no = ? ";
                              try {
                                  PreparedStatement pst = conn.prepareStatement(Query);
                                  pst.setString(1,Room.getText() );
                                  ResultSet rs = pst.executeQuery();
                                  if(rs.next())
                                  {
                                      String add = rs.getString("Price");
                                      txt11.setText(add);
                                      
                                      
                                  }
                                  pst.close();
                                  
                              } catch (Exception ex) {
                                  System.out.println(ex);
                              }
            
            
            
            
            
             try{
            
            String query ="insert into customer (GUEST_Id, Name, Adress, City, State, Country, Mobile_no,  ID_Proof, ID_Number, Members ,Purpose, Days, Room_no,Room_Type, Bed_Type, Checkin, Checkout,Cost) values(?,?,?, ?, ? ,?  , ?,  ?,  ?, ?, ? , ?, ? , ? ,? ,? ,? ,? )";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,txt.getText());
            pst.setString(2,txt1.getText()); 
            pst.setString(3,txt2.getText()); 
            pst.setString(4,txt3.getText()); 
            pst.setString(5,txt4.getText()); 
            pst.setString(6,txt5.getText()); 
            pst.setString(7,txt6.getText()); 
            pst.setString(8,txt7.getText()); 
            pst.setString(9,txt8.getText()); 
            pst.setString(10,txt9.getText()); 
            pst.setString(11,txt10.getText()); 
            pst.setString(12,Days.getText());   
            pst.setString(13,Room.getText()); 
            pst.setString(14,Room1.getText()); 
            pst.setString(15,Bed.getText()); 
            pst.setString(16,Check.getText()); 
            pst.setString(17,Check1.getText()); 
            pst.setString(18,txt11.getText());
            
                      
            pst.executeUpdate();
            
             
             
           pst.close();
         
            }
            catch(Exception e){    
            System.out.println(e);
            }
          JOptionPane.showMessageDialog(null,"Booked");
          t.dispose();
             
             
            
        }
 });
    

    
    t.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
        t.dispose();}});
    
   
    
    }
    
}
