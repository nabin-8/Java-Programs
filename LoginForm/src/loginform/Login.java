
package loginform;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//step 1. Import sql pacakge
import java.sql.*;

public class Login implements ActionListener{
    
     static JLabel usernameLabel, passwordLabel;
     static JTextField txtUsername, txtPassword;
     static JButton btnLogin, btnCancel;
     JFrame frame = null;
      
      

    
    public void Login()
    {
         frame = new JFrame("Login");
        JPanel panel = new JPanel();
        frame.setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(3, 2));
        frame.setSize(600, 400);

        // Declaring all the component line by line
        usernameLabel = new JLabel("Username: ");
        txtUsername = new JTextField();
        txtUsername.setSize(80, 40);
        passwordLabel = new JLabel("Password: ");
        txtPassword = new JTextField();
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        // Adding all the above element to panel
        panel.add(usernameLabel);
        panel.add(txtUsername);
        panel.add(passwordLabel);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);
        // Adding panel to frame
        frame.add(panel);

        // Adding event to login button
        btnLogin.addActionListener(this);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Step 2. Load and Register MySQL Driver
            Class.forName("com.mysql.jdbc.Driver");
            // Step 3. Establish the connection
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
            // Step 4. Create the statement
            stmt = conn.createStatement();
            // Step 5. Create and Execute Query
            String user = txtUsername.getText();
            String pass = txtPassword.getText();

            String selectQuery = "SELECT * FROM javalogin_tbl where username='" + user + "' && password='" + pass + "' ";
            ResultSet rs = stmt.executeQuery(selectQuery);
            if (rs.next()) {
                Dashboard dash =new Dashboard();
                dash.Dashboard();
                frame.setVisible(false); //you can't see me!
                frame.dispose(); //Destroy the JFrame object
                
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong username and password...");
            }
            // Step 7. Closing the Connection
            stmt.close();
            conn.close();
        } catch (Exception ae) {
            System.out.println(ae);
        }

    }
}
