package swingdatabase;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
public class SwingDatabase
{
    static Connection conn;
    static Statement st;
    //creating connection
    static void getConnection() 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/danfe","root","");
            st=conn.createStatement();
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        SwingDatabase()
        {
            getConnection();
            JFrame jframe=new JFrame("This is a simple JFrame App");
            
            JLabel lbl1=new JLabel("Student Id:");
            lbl1.setBounds(20, 12, 100, 10);
            jframe.add(lbl1);
            JTextField txt1=new JTextField();
            txt1.setBounds(120, 10, 150, 20);
            jframe.add(txt1);
            JLabel lbl2=new JLabel("Student Name:");
            lbl2.setBounds(20, 55, 100, 10);
            jframe.add(lbl2);
            JTextField txt2=new JTextField();
            txt2.setBounds(120, 50, 150, 20);
            jframe.add(txt2);
            JLabel lbl3=new JLabel("Student Address: ");
            lbl3.setBounds(20,85,120,30);
            jframe.add(lbl3);
            JTextField txt3=new JTextField();
            txt3.setBounds(120, 90, 150, 20);
            jframe.add(txt3);
            JButton insert=new JButton("Insert");
            insert.setBounds(10, 140, 80, 20);
            jframe.add(insert);
            JButton update=new JButton("Update");
            update.setBounds(100, 140, 80, 20);
            jframe.add(update);
            JButton delete=new JButton("Delete");
            delete.setBounds(200, 140, 80, 20);
            jframe.add(delete);
            JButton view=new JButton("View");
            view.setBounds(300, 140, 80, 20);
            jframe.add(view);
            
            jframe.setLayout(null);
            jframe.setSize(600, 200);
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //insert
            insert.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent ae)
                {
                    String id=txt1.getText();
                    String name=txt2.getText();
                    String address=txt3.getText();
                    try 
                    {
                        String sql="INSERT INTO student(sid,name,age) VALUES('"+id+"','"+name+"','"+address+"')";
                        st.execute(sql);
                        JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    }
                    catch(Exception e) 
                    {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            });
            //update
                update.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae)
                {
                        String id=txt1.getText();
                        String name=txt2.getText();
                        String address=txt3.getText();
                        try {
                            String sql="UPDATE student SET name='"+name+"',address='"+address+"' WHERE sid='"+id+"'";
                            st.execute(sql);
                            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                        }
                        catch(Exception e) 
                        {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                });
                //delete
                delete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) 
                    {
                        String id=txt1.getText();
                        try {
                            String sql="DELETE FROM student WHERE sid='"+id+"'";
                            st.execute(sql);
                            JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                });
            //view
               view.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) 
                {
                    //plotting in JTable
                    String[] columns= {"ID","Name","Address"};
                    JTable jt=new JTable();
                    DefaultTableModel model = new DefaultTableModel();
                    jt.setModel(model);
                    model.setColumnIdentifiers(columns);
                    try
                    {
                        String sql="SELECT * FROM student";
                        ResultSet rs=st.executeQuery(sql);
                        while(rs.next()) 
                        {
                            String id=rs.getString(1);
                            String name=rs.getString(2);
                            String address=rs.getString(3);
                            model.addRow(new String[]{id,name,address});
                        }
                            JScrollPane sp=new JScrollPane(jt);
                            sp.setBounds(300, 10, 250, 100);
                            jframe.add(sp);
                    }
                    catch(Exception e) 
                    {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            });
        }
    
        public static void main(String[] args) 
        {
            new SwingDatabase();
        }
}


