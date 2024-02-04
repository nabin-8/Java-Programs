package layoutmanagers;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

class BorderLayoutDemo extends JFrame
{
    JButton b1,b2,b3,b4,b5;
    public BorderLayoutDemo()
    {
        b1 = new JButton("NORTH");
        b2 = new JButton("SOUTH");
        b3 = new JButton("WEST");
        b4 = new JButton("EAST");
        b5 = new JButton("CENTER");
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(b1, BorderLayout.NORTH); 
        panel.add(b2, BorderLayout.SOUTH); 
        panel.add(b3, BorderLayout.WEST); 
        panel.add(b4, BorderLayout.EAST); 
        panel.add(b5, BorderLayout.CENTER);
        add(panel);
        
        setTitle("BorderLayout Manager");
        setSize(500,500);
        //setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class FlowLayoutDemo extends JFrame
{
    JButton b1,b2,b3,b4,b5;
    public FlowLayoutDemo()
    {
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");
        add(b1); add(b2); add(b3); add(b4); add(b5);
        
        setTitle("FlowLayout Manager");
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class GridLayoutDemo extends JFrame
{
    JButton b1,b2,b3,b4,b5;
    public GridLayoutDemo()
    {
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");
        add(b1); add(b2); add(b3); add(b4); add(b5);
        
        setTitle("GridLayout Manager");
        setSize(500,500);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(5,1,20,20));
        setLayout(new GridLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


public class LayoutManagers {
    public static void main(String[] args) {
       new FlowLayoutDemo();
       new BorderLayoutDemo();
       new GridLayoutDemo();
    } 
}
