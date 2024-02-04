package simpleinterestusingswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SimpleInterest extends JFrame implements ActionListener
{
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
    JTextField txt1, txt2, txt3;
    JButton btn;
    
    public SimpleInterest()
    {
        lbl1 = new JLabel("No. of Years: ");
        add(lbl1);
        txt1 = new JTextField(10);
        add(txt1);
        lbl2 = new JLabel("Rate of Interest: ");
        add(lbl2);
        txt2 = new JTextField(10);
        add(txt2);
        lbl3 = new JLabel("Principal Amount: ");
        add(lbl3);
        txt3 = new JTextField(10);
        add(txt3);
        lbl4 = new JLabel("Your Payable Amount Is: ");
        add(lbl4);
        lbl5 = new JLabel("");
        add(lbl5);
        btn = new JButton("Calculate Simple Interest");
        add(btn);
        btn.addActionListener(this);
        
        setTitle("Simple Interest Calculator");
        setLayout(new GridLayout(5,2,5,10));
        //setSize(250,190);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==btn)
       {
           int time = Integer.parseInt(txt1.getText());
           float rate = Float.parseFloat(txt2.getText());
           int principal = Integer.parseInt(txt3.getText());
           
           float si = (principal * time * rate)/100;
           
           lbl5.setText(String.valueOf(si));
       }
    }
}

public class SimpleInterestUsingSwing {
    public static void main(String[] args) {
        new SimpleInterest();
    }   
}
