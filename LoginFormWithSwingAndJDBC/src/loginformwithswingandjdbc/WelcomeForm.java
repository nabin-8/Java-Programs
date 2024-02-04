
package loginformwithswingandjdbc;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class WelcomeForm {
    JFrame frame;
    public WelcomeForm()
    {
        JOptionPane.showMessageDialog(frame, "Login Successful! Welcome!");

        // Code to open a new Welcome form
        JFrame welcomeFrame = new JFrame("Welcome Form");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(300, 100);
        welcomeFrame.setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome to the application!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeFrame.add(welcomeLabel);

        welcomeFrame.setVisible(true);
    }
 }
    
