
package leapyearapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LeapYear extends JFrame implements ActionListener
{
    JLabel l1 = new JLabel("Enter any year : ");
    JTextField t1 = new JTextField(15);
    JButton b1 = new JButton("Check");
    JButton b2 = new JButton("Clear");
    JLabel l2 = new JLabel(" ");
    
    LeapYear(String title, int length, int width)
    {
        super(title);
        setSize(length, width);
        add(l1);
        add(t1);
        add(b1);
        add(b2);
        add(l2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(new FlowLayout());
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
               int y = Integer.parseInt(t1.getText());
               if(y%4==0&&y%100!=0||y%400==0)
               {
                   l2.setText("It is leap year");
               }
               else{
                   l2.setText("It is not leap year");
               }
            }
            else if(e.getSource()==b2)
            {
                t1.setText(" ");
            }
        }
    }
    
public class LeapYearApp {

    public static void main(String[] args) {
     
        LeapYear lp = new LeapYear("Leap Year",850,100);
    }
    
}
