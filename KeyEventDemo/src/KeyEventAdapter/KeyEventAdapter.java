
package KeyEventAdapter;

import javax.swing.*;
import java.awt.event.*;

public class KeyEventAdapter extends KeyAdapter {
    JLabel label;
    JFrame frame;
    public KeyEventAdapter() {
        frame = new JFrame("KeyAdapter Demo");
        frame.setTitle("Key Event Demo");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel("Press any key...");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);
        frame.addKeyListener(this);
        
        frame.setVisible(true);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        label.setText("Key Pressed: " + e.getKeyChar());
    }
    @Override
    public void keyReleased(KeyEvent e) {
        label.setText("Key Released: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        new KeyEventAdapter();
    }
}

