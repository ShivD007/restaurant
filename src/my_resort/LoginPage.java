package my_resort;

 
import javax.swing.*;
import java.awt.event.*;


public class LoginPage extends JFrame {
public LoginPage(){
    setVisible(true);
    setTitle("Login || OM SAI VILLA RESORT ");
    setSize(600,600);
    setLocationRelativeTo(null);
    setResizable(false);
    
   JPanel login_panel = new JPanel();
    
    JLabel background = new JLabel(new ImageIcon("image\\bg.png")); 

add(background);
background.setBounds(0, 0, 600, 600);

background.add(login_panel);

login_panel.setBounds(0,0,600,600);
background.setLayout(null);

login_panel.setLayout(null);

login_panel.setOpaque(false);

JLabel heading_lbl = new JLabel("<html><font color='red' size='10'><u>OM SAI</u></font><font size='10'> <u>VILLA RESORT</u></font>  </html>");
login_panel.add(heading_lbl);
heading_lbl.setBounds(90,30,400,100);


JLabel user_lbl = new JLabel("<html><font size='6'>USER</font> </html>");
login_panel.add(user_lbl);
user_lbl.setBounds(255,100,100,100);

JLabel admin_lbl = new JLabel("<html><font color='blue'>Admistration</font> </html>");
login_panel.add(admin_lbl);

admin_lbl.setBounds(140,280,80,20);

JLabel recep_lbl = new JLabel("<html><font color='blue'>Receptionist</font> </html>");
login_panel.add(recep_lbl);
recep_lbl.setBounds(390,280,80,20);

ImageIcon image = new ImageIcon("image\\rsz_1login-iconadmin.png");
ImageIcon image1 = new ImageIcon("image\\rsz_1check--user-icon-27676.png");

JButton admin_btn = new JButton(image);
admin_btn.setBorder(null);

admin_btn.setContentAreaFilled(false);
JButton recep_btn = new JButton(image1);
recep_btn.setBorder(null);
recep_btn.setContentAreaFilled(false);

login_panel.add(admin_btn);
admin_btn.setBounds(150,230,50,50);
login_panel.add(recep_btn);
recep_btn.setBounds(400,230,50,50);

JLabel msg_lbl = new JLabel("<html><font size='4' color='red'>TO LOGIN CLICK ON THE ICON</font> </html>");
login_panel.add(msg_lbl);
msg_lbl.setBounds(340,500,220,50);



addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
        dispose();}});

admin_btn.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            new Admin();
            dispose();
        }
 });

recep_btn.addActionListener(new ActionListener(){
                          @Override
        public void actionPerformed(ActionEvent ae) {
            new Recep();
            dispose();
        }
 });


}

public static void main (String[] args)
{
    new LoginPage();
    

    
}  

   
}

