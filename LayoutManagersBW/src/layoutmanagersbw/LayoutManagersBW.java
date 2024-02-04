package layoutmanagersbw;

import java.awt.*;
import javax.swing.*;

class BorderLayoutDemo
{
    public BorderLayoutDemo()
    {
        JFrame frame = new JFrame("Demo of BorderLayout");
        //BorderLayout layout = new BorderLayout(10,20);
        frame.setLayout(new BorderLayout(10,10)); //Layout managers
        //Adding controls to JFrame or container
        
        JButton btn1 = new JButton("North");
        btn1.setPreferredSize(new Dimension(btn1.getPreferredSize().height,75));
        frame.add(btn1, BorderLayout.NORTH);
        JButton btn2 = new JButton("South");
        frame.add(btn2, BorderLayout.SOUTH);
        JButton btn3 = new JButton("West");
        frame.add(btn3, BorderLayout.WEST);
        JButton btn4 = new JButton("East");
        frame.add(btn4, BorderLayout.EAST);
        JButton btn5 = new JButton("Center");
        frame.add(btn5, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(500, 500);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

public class LayoutManagersBW {
    public static void main(String[] args) {
     
       new BorderLayoutDemo();
    }
}
