package mouseandkeyevents;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

class MouseEventDemo extends JFrame implements MouseListener
{
     JButton btn;
     JLabel lblResult;
    public MouseEventDemo()
    {
       btn = new JButton("Click Me");
       add(btn);
       lblResult = new JLabel("");
       add(lblResult);
       btn.addMouseListener(this);
       
       setTitle("Mouse Event Demo");
       setLayout(new FlowLayout());
       setSize(300,300);
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
       lblResult.setText("Mouse Clicked... -> Count: "+e.getClickCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {
       lblResult.setText("Mouse Pressed...");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        lblResult.setText("Mouse Released...");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        lblResult.setText("Mouse Entered...");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        lblResult.setText("Mouse Exited...");
    }
}

class KeyEventDemo extends JFrame implements KeyListener
{
    JTextArea jta;
    JLabel lbl;
    public KeyEventDemo()
    {
       jta = new JTextArea(20,30);
       add(jta);
       lbl = new JLabel("");
       add(lbl);
       
       jta.addKeyListener(this);
       
       setTitle("Key Event Demo");
       setLayout(new FlowLayout(FlowLayout.LEFT));
       setSize(500,300);
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    @Override
    public void keyTyped(KeyEvent e) {
        lbl.setText("Key Typed...");
    }

    @Override
    public void keyPressed(KeyEvent e) {
      lbl.setText("Key Pressed...");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        lbl.setText("Key Released...");
    }
}

public class MouseAndKeyEvents {
    public static void main(String[] args) {
        new MouseEventDemo();
        //new KeyEventDemo();
    }    
}
