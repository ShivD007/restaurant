package my_resort;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Recep extends JFrame {
    
    int amt;
    String room,room1,bed,check,check1,day,s;
    LocalDateTime from,to;
    DateTimeFormatter dtf =DateTimeFormatter.ofPattern("dd-MM-yyy");
    JPanel checkout_panel;
Connection conn = null; 
JLabel lbl2, background1;JTextField day_txt,user_txt;
        JPasswordField userpass_txt1;
JButton logout_btn;
JTabbedPane tab;
String Condtion= null;

    public  Recep() {
        conn=SqlDatabase.dbconnet();
         setVisible(true);
    setTitle("Receptionist || OM SAI VILLA RESORT ");
    setSize(600,600);
    setLocationRelativeTo(null);
    setResizable(false); 
     setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
    JPanel recep_panel = new JPanel();
    add(recep_panel);
    
    
    
    background1 = new JLabel(new ImageIcon("image\\bg1.png")); 

recep_panel.add(background1);
background1.setBounds(0, 0, 600, 600);
background1.setLayout(null);
    
    
    JLabel username_lbl = new JLabel("ID");
        JLabel password_lbl = new JLabel("Password");
     user_txt = new JTextField(50);
     userpass_txt1 = new JPasswordField(50);
     JButton login =new JButton("login");
     JButton back = new JButton(new ImageIcon("image\\back.png"));
      logout_btn = new JButton(new ImageIcon("image\\log.png"));
     
     back.setBorder(null);
back.setContentAreaFilled(false);
     
     background1.setLayout(null);
     background1.add(username_lbl);    
     background1.add(password_lbl);
     background1.add(user_txt);
     background1.add(userpass_txt1);
     background1.add(login);
     background1.add(back);
//     recep_panel.setBackground( new ImageIcon();
// //  new Color(255,255,255)
     
username_lbl.setBounds(155,180,20,10);
password_lbl.setBounds(155,230,60,10);
user_txt.setBounds(220,170,170,25);
userpass_txt1.setBounds(220,220,170,25);
login.setBounds(300,280,70,23);
back.setBounds(500,30,50,50);


    JPanel checkin_panel=new JPanel(); 
     checkin_panel.setLayout(null);
     checkin_panel.setBackground(Color.white);
    JLabel checkin_date_lbl = new JLabel("Check-in Date");
    JLabel checkout_date_lbl = new JLabel("Check Out Date");
     lbl2 = new JLabel("Days");
     day_txt = new JTextField();
     day_txt.setEditable(false);
    JTable t = new JTable();
    JScrollPane sp=new JScrollPane(t); 
    
    JButton available_btn = new JButton(new ImageIcon("image\\avail.png"));
    JLabel available_lbl = new JLabel("Room Available");
    JButton checkin_btn = new JButton(new ImageIcon("image\\checkin.png"));
    JLabel checkin_lbl = new JLabel("Checkin");
    checkin_btn.setBorder(null);
checkin_btn.setContentAreaFilled(false);
available_btn.setBorder(null);
available_btn.setContentAreaFilled(false);
    
    JDateChooser dp = new JDateChooser();
    JDateChooser dp1 = new JDateChooser();
    
    
    
    dp1.addPropertyChangeListener(new PropertyChangeListener(){
      
   @Override
        public void propertyChange(PropertyChangeEvent pce) {
                try{
    from =LocalDateTime.ofInstant(dp.getDate().toInstant(), ZoneId.systemDefault());
     to=LocalDateTime.ofInstant(dp1.getDate().toInstant(), ZoneId.systemDefault());
    
    Duration d =Duration.between(from, to);
    s = String.valueOf(d.toDays());
    day_txt.setText(s);
    }catch(Exception ex){} 
        }
    });
    
    
    dp.addPropertyChangeListener(new PropertyChangeListener(){
      
   @Override
        public void propertyChange(PropertyChangeEvent pce) {
                try{
    from =LocalDateTime.ofInstant(dp.getDate().toInstant(), ZoneId.systemDefault());
     to=LocalDateTime.ofInstant(dp1.getDate().toInstant(), ZoneId.systemDefault());
    
    Duration d =Duration.between(from, to);
    String s = String.valueOf(d.toDays());
    day_txt.setText(s); 
    }catch(Exception ex){} 
        }
    });
    
    
    
  try{
            
            String query="select* from Room ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
     checkin_panel.add(sp);
     checkin_panel.add(checkin_date_lbl);
     checkin_panel.add(checkout_date_lbl);
     checkin_panel.add(lbl2);
     checkin_panel.add(dp);
     checkin_panel.add(dp1);
     checkin_panel.add(day_txt);
     checkin_panel.add(available_btn);
     checkin_panel.add(checkin_btn);
     checkin_panel.add(checkin_lbl);
     checkin_panel.add(available_lbl);
   
     checkin_date_lbl.setBounds(18,40,100,20);
     checkout_date_lbl.setBounds(235,40,100,20);
     lbl2.setBounds(458,40,60,20);
     dp.setBounds(110,40,100,20);
     dp1.setBounds(340,40,100,20);
     sp.setBounds(20,100,350,400);
     day_txt.setBounds(500,40,30,20);
         available_btn.setBounds(450,280,45,45);
    available_lbl.setBounds(430,325,100,20);
    checkin_btn.setBounds(450,365,50,50);
checkin_lbl.setBounds(450,415,80,20);

     
      
    JPanel food_oder_panel=new JPanel();  
     checkout_panel=new JPanel();  
     tab=new JTabbedPane();  
    tab.setBounds(0,35,600,565);  
    logout_btn.setBounds(520,5,60,50);
    tab.add("Check-in",checkin_panel);  
    tab.add("Food Odered",food_oder_panel);  
    tab.add("Check-out",checkout_panel);
    logout_btn.setBorder(null);
logout_btn.setContentAreaFilled(false); 
    
 // ******************************************fo0d***********************  
    food_oder_panel.setLayout(null);food_oder_panel.setBackground(Color.WHITE);
    
   JComboBox foodcb = new JComboBox();
   String a[] = {"1","2","3","4","5","6","7","8","9","10"};
   JComboBox memcb = new JComboBox(a);
   JLabel rmlbl = new JLabel("Guest Id.");
   JTextField gid = new JTextField();
   JTextArea dettar = new JTextArea();
   JTextField foodamt = new JTextField();                                  
   JLabel foodtxt1 = new JLabel("Food Item");
   JLabel memtxt1 = new JLabel("Quantity");
   JLabel foodamt1 = new JLabel("Amount"); 
   JButton addbtn = new JButton(new ImageIcon("image\\food.png"));
   JLabel addbtn1 = new JLabel("Add Items");
   JButton getamtbtn = new JButton(new ImageIcon("image\\paid.png"));
   JLabel getamtbtn1 = new JLabel("Calculate Total");
    JButton foodpay = new JButton(new ImageIcon("image\\print.png"));
    JLabel foodpay1 = new JLabel("Print bill");
    JLabel note = new JLabel("<html><font color= red size= 2>*If you have room please enter the Guest id</font></html>");
    String Query1 ="Select * from Food";
    try{
    PreparedStatement pst = conn.prepareStatement(Query1);
                    
                    ResultSet rs = pst.executeQuery();
                    while(rs.next())
                    {
                    String foodstr= rs.getString("Food_Item");
                    foodcb.addItem(foodstr);
    }
                    pst.close();
                    rs.close();
    }
    catch(Exception et){}
    
    food_oder_panel.add(foodcb);
    food_oder_panel.add(memcb);food_oder_panel.add(foodtxt1);
    food_oder_panel.add(memtxt1);food_oder_panel.add(foodamt1);food_oder_panel.add(foodamt);
    food_oder_panel.add(dettar);food_oder_panel.add(rmlbl);food_oder_panel.add(gid);food_oder_panel.add(addbtn);food_oder_panel.add(getamtbtn);food_oder_panel.add(foodpay);
    food_oder_panel.add(foodpay1);food_oder_panel.add(getamtbtn);food_oder_panel.add(addbtn);food_oder_panel.add(getamtbtn1);food_oder_panel.add(addbtn1);
    food_oder_panel.add(note);
    rmlbl.setBounds(30,40,65,25);
    gid.setBounds(100,40,65,25);
    
    addbtn.setBounds(400,180,50,50);
    addbtn1.setBounds(397,230,100,20);
    getamtbtn.setBounds(400,280,45,45);
    getamtbtn1.setBounds(380,325,100,20);
    foodpay.setBounds(400,365,50,50);
    foodpay1.setBounds(400,415,80,20);
    dettar.setBounds(50,120,250,380);
    dettar.setBackground(new Color(204,204,204));
    foodtxt1.setBounds(177,40,70,25);
    foodcb.setBounds(245,40,100,25);
    note.setBounds(390,400,200,150);
    memtxt1.setBounds(368,40,80,25);
    memcb.setBounds(440,40,60,25);
    foodamt1.setBounds(320,100,100,25);foodamt.setBounds(413,100,100,25);
    foodamt.setEditable(false);
    
    
    dettar.append(" ------------------------------------------------------------ \n\n"
                + "               OM SAI VILLA RESORT               \n\n"+
                  " ------------------------------------------------------------ \n\n"
                + " ------------------------------------------------------------ \n"
    );
    
     
    addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 
               String cost=null;
                
              String queryss = "Select Price from Food where  Food_Item='"+foodcb.getItemAt(foodcb.getSelectedIndex())+"'"; 
              try {
                    PreparedStatement pst = conn.prepareStatement(queryss);
              ResultSet rs = pst.executeQuery();
                    if(rs.next())
                    {
                      cost= rs.getString("Price");
                       
                    }
                 pst.close();
                 rs.close();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Recep.class.getName()).log(Level.SEVERE, null, ex);
                }
              
               amt = amt  + (Integer.parseInt(cost))*(Integer.parseInt((String) memcb.getItemAt(memcb.getSelectedIndex()))); 
                
                
    dettar.append( " " +(String) foodcb.getItemAt(foodcb.getSelectedIndex())+"        "
            + "         "+(String) memcb.getItemAt(memcb.getSelectedIndex())+"  \n");
    
                
                  foodamt.setText(Integer.toString(amt));
                  
                  String rmnum =gid.getText();
            if(rmnum != "")
            {   String qry ="update customer set Food_price =? where GUEST_Id=?";
            
                   try {
                       PreparedStatement pst = conn.prepareStatement(qry);
                       pst.setString(1,(Integer.toString(amt) ));
                       pst.setString(2,gid.getText());
                       
                       pst.executeUpdate();
             pst.close();
                       
                       
                   } catch (SQLException ex) {
                       Logger.getLogger(Recep.class.getName()).log(Level.SEVERE, null, ex);
                   }
} 
                  
            } });
    
    getamtbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dettar.append( " ------------------------------------------------------------ \n\n"
            +     " "+foodamt1.getText()+"              "+foodamt.getText()+"  \n\n"
            +     " ************************************************ \n\n"
            +     "             THANKS TO VISIT OUR RESORT             \n\n"
            
            +     " ************************************************\n\n");
            }
        });
    
    
    foodpay.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent ae)
{
    
    
   
    
    
    try{
Boolean complete = dettar.print();
if(complete){
JOptionPane.showMessageDialog(null,"done");
}
else{
JOptionPane.showMessageDialog(null,"done");
}}
catch(Exception ev){}
    
    gid.setText("");
    foodamt.setText("");
    dettar.setText("");
    dettar.append(" ------------------------------------------------------------ \n\n"
                + "               OM SAI VILLA RESORT               \n\n"+
                  " ------------------------------------------------------------ \n\n"
                + " ------------------------------------------------------------ \n"
    );
    
}
});

    
    
    
    
    
   // *****************Checkout Tab*********************** 
    
    
    checkout_panel.setLayout(null);
    
    JLabel l = new JLabel("Guest Id");
    
    JTextField txtch = new JTextField();
    JButton getbtn = new JButton(new ImageIcon("image\\details.png"));
    JLabel getbtnlbl = new JLabel("Customer Details");
    JButton btnch = new JButton(new ImageIcon("image\\rsz_rooms.png"));
    JLabel btnchlbl = new JLabel("Checkout");
    JTextArea txtar = new JTextArea();
    JButton pay = new JButton(new ImageIcon("image\\print.png"));
    JLabel paylbl = new JLabel("Genrate Bill");
    JLabel cstmlbl = new JLabel("Costumer Name");
    JLabel cstmlbl1 = new JLabel();
    cstmlbl1.setForeground(Color.red);
    JLabel roomlbl = new JLabel("Room no.");
    JTextField roomtxt = new JTextField();
    JLabel roomtypelbl = new JLabel("Room Type");
    JLabel roomtypelbl1 = new JLabel();
    roomtypelbl1.setForeground(Color.red);
    JLabel bedlbl  = new JLabel("Bed Type");
    JLabel bedlbl1 = new JLabel();
    bedlbl1.setForeground(Color.red);
    JLabel memlbl = new JLabel("Member");
    JLabel memlbl1 = new JLabel();
    memlbl1.setForeground(Color.red);
    JLabel moblbl = new JLabel("Mobile no.");JLabel moblbl1 = new JLabel();
    moblbl1.setForeground(Color.red);
    JLabel amtlbl = new JLabel("Amount");
    JLabel amtlbl1 = new JLabel();
    amtlbl1.setForeground(Color.red);
    JLabel chklbl = new JLabel("Checkin date");JLabel chklbl1 = new JLabel();
    chklbl1.setForeground(Color.red);JLabel chkolbl = new JLabel("Checkout date");JLabel chkolbl1 = new JLabel();
    chkolbl1.setForeground(Color.red);
    
    txtar.setBackground(new Color(204,204,204));
    
    
    checkout_panel.setBackground(new Color(255,255,255));
    checkout_panel.add(l);
    checkout_panel.add(txtch);
    checkout_panel.add(getbtn);
    checkout_panel.add(getbtnlbl);
    checkout_panel.add(btnch);
    checkout_panel.add(btnchlbl);
    checkout_panel.add(txtar);
    checkout_panel.add(pay);
    checkout_panel.add(paylbl);
    checkout_panel.add(cstmlbl); checkout_panel.add(cstmlbl1); checkout_panel.add(roomlbl); checkout_panel.add(roomtxt); checkout_panel.add(roomtypelbl); 
    checkout_panel.add(roomtypelbl1); checkout_panel.add(bedlbl); checkout_panel.add(bedlbl1); checkout_panel.add(amtlbl); checkout_panel.add(amtlbl1); checkout_panel.add(memlbl); checkout_panel.add(memlbl1); checkout_panel.add(moblbl); checkout_panel.add(moblbl1);
    checkout_panel.add(chklbl);checkout_panel.add(chklbl1);checkout_panel.add(chkolbl);checkout_panel.add(chkolbl1);
    
    l.setBounds(25, 40, 55,20 );
    txtch.setBounds(90,40,45,20);
    getbtn.setBounds(400,180,50,50);
    getbtnlbl.setBounds(380,230,100,20);
   
    btnch.setBounds(400,280,45,45);
    btnchlbl.setBounds(400,325,100,20);
    txtar.setBounds(50,120,250,380);
pay.setBounds(400,365,50,50);
paylbl.setBounds(392,415,80,20);
getbtn.setBorder(null);btnch.setBorder(null);
btnch.setContentAreaFilled(false);
getbtn.setContentAreaFilled(false);pay.setBorder(null);
pay.setContentAreaFilled(false);


roomlbl.setBounds(153, 40,55,20 );
roomtxt.setBounds(213, 40, 45,20 );
cstmlbl.setBounds(266, 40, 95,20 );
cstmlbl1.setBounds(365, 40, 70,20 );memlbl.setBounds(480, 40,65,20 );memlbl1.setBounds(552, 40,29,20 );bedlbl.setBounds(25, 80, 55,20 );
bedlbl1.setBounds(85, 80, 45,20 );roomtypelbl.setBounds(145, 80, 65,20 );roomtypelbl1.setBounds(219, 80, 50,20 );moblbl.setBounds(284, 80, 65,20 );moblbl1.setBounds(354, 80,70,20 );
chklbl.setBounds(441, 80, 79,20 );
chklbl1.setBounds(524, 80, 65,20 );chkolbl.setBounds(318,120,82,20);chkolbl1.setBounds(410,120,65,20);amtlbl.setBounds(483,120,65,20);amtlbl1.setBounds(540,120,65,20);








getbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 
              String Query = "SELECT  Status from Room Where Room_no='"+roomtxt.getText()+"'";
                 try {
                    PreparedStatement pst = conn.prepareStatement(Query);
              ResultSet rs = pst.executeQuery();
                    if(rs.next())
                    {
                   Condtion = rs.getString("Status");
                       pst.close();
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Recep.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                System.out.println(Condtion);
                
                
                
                               if(Condtion != null)
                               {
                                   
                                   
                
                String query = "select * from customer where GUEST_Id='"+txtch.getText()+"'";
                     
             
             try {
                    PreparedStatement pst = conn.prepareStatement(query);
                    
                    ResultSet rs = pst.executeQuery();
                    if(rs.next())
                    {
                    String add1= rs.getString("Name");
                    cstmlbl1.setText(add1);
                    String add2= rs.getString("Room_no");
                    roomtxt.setText(add2);
                    String add3= rs.getString("Room_Type");
                    roomtypelbl1.setText(add3);
                    String add4= rs.getString("Bed_Type");
                    bedlbl1.setText(add4);
                    String add5= rs.getString("Mobile_no");
                    moblbl1.setText(add5);
                    String add6= rs.getString("Members");
                    memlbl1.setText(add6);
                    String add7= rs.getString("Checkin");
                    chklbl1.setText(add7);
                    String add8= rs.getString("Checkout");
                    chkolbl1.setText(add8);
                     String add9= rs.getString("cost");
                     amtlbl1.setText(add9);
                     
                   
//                   
                    
                    pst.close();
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Recep.class.getName()).log(Level.SEVERE, null, ex);
                }
             }else JOptionPane.showMessageDialog(null,"No Bookina availabel in this Record");
            }
        });


btnch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try{
             String query="update Room set Status =null, Checkin =null, Checkout=null where Room_no='"+roomtxt.getText()+"'";
            PreparedStatement pst = conn.prepareStatement(query); 

            pst.executeUpdate();
            //t.setModel(DbUtils.resultSetToTableModel(rs));
         System.out.println(room);
         System.out.println(check);
         System.out.println(check1);
         
         pst.close();
      }
            catch(Exception e){System.out.println(e);}
                
                
                txtar.setText(" ------------------------------------------------------------ \n\n"
                + "               OM SAI VILLA RESORT               \n\n"+
                  " ------------------------------------------------------------ \n\n"
            +     " ------------------------------------------------------------ \n"
            +     " "+cstmlbl.getText()+"       "+cstmlbl1.getText()+"  \n"
            +     " "+roomlbl.getText()+"           "+roomtxt.getText()+"  \n"
            +     " "+roomtypelbl.getText()+"         "+roomtypelbl1.getText()+" \n"
            +     " "+memlbl.getText()+"           "+memlbl1.getText()+"  \n"
            +     " "+bedlbl.getText()+"           "+bedlbl1.getText()+"  \n"
            +     " "+moblbl.getText()+"          "+moblbl1.getText()+"  \n"
            +     " "+chklbl.getText()+"          "+chklbl1.getText()+"  \n"
            +     " "+chkolbl.getText()+"          "+chkolbl1.getText()+"  \n"
                            
            +     " ------------------------------------------------------------ \n\n"
            +     " "+amtlbl.getText()+"       "+amtlbl1.getText()+"  \n\n"
            +     " ************************************************ \n\n"
            +     "           THANKS TO VISIT OUR RESORT             \n\n"
            
            +     " ************************************************\n\n"
);
                
             
                
                try{
            
            String query="select* from Room ";
            PreparedStatement pst = conn.prepareStatement(query);            
            ResultSet rs =pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
            rs.close();
            }
            catch(Exception e){}
                
    }
          });









pay.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent ae)
{
    
    
   
    
    
    try{
Boolean complete = txtar.print();
if(complete){
JOptionPane.showMessageDialog(null,"done");
}
else{
JOptionPane.showMessageDialog(null,"done");
}}
catch(Exception ev){}
    
   txtar.setText(""); 
   txtch.setText("");roomtxt.setText("");
   
    
}
});


    
     
    
    
   
    
    
  login.addActionListener(new ActionListener()
  {
      @Override
    public void actionPerformed(ActionEvent ae) {
    
          try{
            
            String query="select* from Login where Admin_Id=? or ID=? and Password=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,user_txt.getText());
            pst.setString(2,user_txt.getText());
            pst.setString(3,userpass_txt1.getText());
            ResultSet rs =pst.executeQuery();
            if(rs.next()) {           
              background1.removeAll();
             background1.add(tab);
              background1.add(logout_btn);
             background1.validate();
             background1.repaint(); }   
       else
           JOptionPane.showMessageDialog( null,"incorrect");
                     pst.close();
            rs.close();
                 }
            catch(Exception e){
            System.out.println(e);
            }
    }
    });  
   back.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            new LoginPage();
            dispose();
        } });
available_btn.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {

            try{
      
           String date=dtf.format(from);
            String query="select* from Room where Checkout < ? or Checkout IS NULL";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,date);
                       
            ResultSet rs = pst.executeQuery();
            
             t.setModel(DbUtils.resultSetToTableModel(rs));
             
              pst.close();
              rs.close();
              
              System.out.println(date);
         
            }
            catch(Exception e){}
             
            
        }
 });




 t.addMouseListener(new MouseAdapter(){
     
     public void mouseClicked(MouseEvent me){
        try{
         int row = t.getSelectedRow();
         room = t.getModel().getValueAt(row, 0).toString();
         room1 = t.getModel().getValueAt(row, 1).toString();
         bed = t.getModel().getValueAt(row, 2).toString();
       }
        
        catch(Exception e){System.out.print(e);}
     }

     });


checkin_btn.addActionListener(new ActionListener(){

  @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
        String Query = "SELECT  Status from Room Where Room_no='"+room+"'";
                 try {
                    PreparedStatement pst = conn.prepareStatement(Query);
              ResultSet rs = pst.executeQuery();
                    if(rs.next())
                    {
                   Condtion = rs.getString("Status");
                       pst.close();
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Recep.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
       if(s !=null && room !=null && Condtion == null){ 
       BookPage b=new BookPage();   
            b.BookPage1();
            b.Days.setText(day_txt.getText());
            b.Room.setText(room);
            b.Room1.setText(room1);
            b.Bed.setText(bed);
            check = dtf.format(from);
            check1=dtf.format(to);
            b.Check.setText(check);
            b.Check1.setText(check1);
            
            System.out.println(Condtion);
            
            String qry ="SELECT GUEST_Id FROM customer where rowid= (select max(rowid) from customer)";
            try {
                                  PreparedStatement pst = conn.prepareStatement(qry);
                                  ResultSet rs = pst.executeQuery();
                                  if(rs.next())
                                  {
                                      String add = rs.getString("GUEST_Id");
                                      String [] a= add.split("D");
                                      b.idnum =Integer.parseInt(a[1]);
                                   
                                 }
                                  pst.close();
                                  
                              } catch (Exception ex) {
                                  System.out.println(ex);
                              }
                             b.idnum++;
                             
                             String  num= String.format("%04d",b.idnum );
                             b.txt.setText("GID"+num);
                             
            
            
            
            
            
            
            
            try{
            
            String query="Select Price from Room  where Room_no ='"+room+"'";
            PreparedStatement pst = conn.prepareStatement(query); 
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
            String add = rs.getString("Price");
            b.txt11.setText(add);
            }
rs.close();
            
            
         
         pst.close();
         
         
            }
            catch(Exception e){System.out.println(e);}
            
            
            
            
            
            try{
            
            String query="update Room set Status ='"+"Booked"+"', Checkin='"+check+"',Checkout='"+check1+"' where Room_no ='"+room+"'";
            PreparedStatement pst = conn.prepareStatement(query); 

            pst.executeUpdate();
            
         
         pst.close();
         
         
            }
            catch(Exception e){System.out.println(e);}
    }
       else{JOptionPane.showMessageDialog(null,"Please provide Room no. and Date");}
    }
} );



              logout_btn.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            new LoginPage();
             
            dispose();
        }
 }); 
              
       
    }   
    
}
