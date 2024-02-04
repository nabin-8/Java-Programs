
package loginform;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;


public class Dashboard {
    
      static JLabel dashoard,info,lblUsername,lblPassword;
      static JTextField txtUsername, txtPassword;
      static JButton btnLogin, btnCancel;

    public void Dashboard()
    {
        JFrame frame = new JFrame("Dashboard");
        frame.setLayout(null);
        frame.setSize(900,700);
      
        
  
        dashoard =new JLabel("Welcome to Dashboard");
        dashoard.setBounds(280, 20, 500, 25);
        dashoard.setFont(new Font("Verdana", Font.PLAIN, 25));
        dashoard.setForeground(Color.RED);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 60, 900, 680);
        panel.setBackground(Color.BLACK);
        
        //For username
        info=new JLabel("Name: Sairaj Timilsina");
        info.setBounds(80, 80, 40, 50);
        info.setForeground(Color.white);
        
         //login form
//        
//        lblUsername=new JLabel("Name:");
////        lblUsername.setBounds(20, 110, 40, 50);
//        lblUsername.setForeground(Color.white);
       
        
        //Adding all the above element to panel
        frame.add(dashoard);
        frame.add(panel);
        panel.add(info);
//        panel.add(lblUsername);
        
     
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
