package mouseadapterexample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseAdapterExample extends MouseAdapter
{
    JFrame f;
    MouseAdapterExample(){
        f=new JFrame("Mouse Adapter");
        f.addMouseListener(this);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g=f.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(e.getX(),e.getY(),30,30);
    }
    public static void main(String[] args) {
        new MouseAdapterExample();
    }
}