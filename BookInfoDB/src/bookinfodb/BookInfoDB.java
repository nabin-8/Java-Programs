package bookinfodb;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;

public final class BookInfoDB extends JFrame implements ActionListener
{
    Connection conn;
    Statement stmt;
    JTextField txtId,txtName,txtAuthor,txtPub,txtPrice;
    JLabel lblId,lblName,lblAuthor,lblPub,lblPrice;
    JButton btnInsert, btnUpdate, btnDelete, btnSelect;
    JTable jt;
    
    //creating connection
    void getConnection() 
    {
     try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","");
            stmt = conn.createStatement();
      } 
      catch (Exception e) 
      {
            JOptionPane.showMessageDialog(null, e);
      }
    }
    
    public void clearContent()
    {
        txtId.setText("");
        txtName.setText("");
        txtAuthor.setText("");
        txtPub.setText("");
        txtPrice.setText("");
    }
    
    
    BookInfoDB()
    {
        getConnection();
        
        lblId = new JLabel("Book Id:");
        lblId.setBounds(20, 20, 100, 20);
        add(lblId);
        txtId=new JTextField();
        txtId.setBounds(120, 20, 150, 20);
        add(txtId);
        
        lblName=new JLabel("Book Name:");
        lblName.setBounds(20, 50, 100, 20);
        add(lblName);
        txtName=new JTextField();
        txtName.setBounds(120, 50, 150, 20);
        add(txtName);
        
        lblAuthor = new JLabel("Book Author: ");
        lblAuthor.setBounds(20,80,100,20);
        add(lblAuthor);
        txtAuthor=new JTextField();
        txtAuthor.setBounds(120,80, 150, 20);
        add(txtAuthor);
        
        lblPub = new JLabel("Publication: ");
        lblPub.setBounds(20,110, 100,20);
        add(lblPub);
        txtPub = new JTextField();
        txtPub.setBounds(120, 110, 150, 20);
        add(txtPub);
        
        lblPrice = new JLabel("Book Price: ");
        lblPrice.setBounds(20, 140, 100, 20);
        add(lblPrice);
        txtPrice = new JTextField();
        txtPrice.setBounds(120, 140, 150, 20);
        add(txtPrice);
        
        btnInsert = new JButton("Insert");
        btnInsert.setBounds(10, 170, 80, 20);
        add(btnInsert);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 170, 80, 20);
        add(btnUpdate);
        
        btnDelete=new JButton("Delete");
        btnDelete.setBounds(200, 170, 80, 20);
        add(btnDelete);
        
        btnSelect=new JButton("View");
        btnSelect.setBounds(300, 170, 80, 20);
        add(btnSelect);
        
        //Creating JTable
        String[] columns = { "Sid", "Name", "Author", "Publication", "Price" };
        jt = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        jt.setModel(model);
        model.setColumnIdentifiers(columns);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(300, 10, 370, 100);
        add(sp);

        
        
        /* Add ActionListener for Insert, Update, Delete and Select */
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSelect.addActionListener(this);
        
        setTitle("Book Information App");
        setSize(700, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
            //insert
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if(evt.getSource()==btnInsert)
                {    
                    String id = txtId.getText();
                    String name = txtName.getText();
                    String author = txtAuthor.getText();
                    String pub = txtPub.getText();
                    String price = txtPrice.getText();
         
                    try 
                    {
                        String sql="INSERT INTO book_info VALUES('"+id+"','"+name+"','"+author+"','"+pub+"','"+price+"')";
                        stmt.execute(sql);
                        JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
                    }
                    catch(Exception e) 
                    {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    
                    clearContent();
                    displayAndReloadRecords();

                }
                else if(evt.getSource()==btnUpdate)
                {
                    String id = txtId.getText();
                    String name = txtName.getText();
                    String author = txtAuthor.getText();
                    String pub = txtPub.getText();
                    String price = txtPrice.getText();
                  
                    try 
                    {
                        String sql="UPDATE book_info SET name='"+name+"', author='"+author+"',publication='"+pub+"',price='"+price+"' WHERE id='"+id+"'";
                        stmt.execute(sql);
                        JOptionPane.showMessageDialog(null, "Record Updated Successfully");
                    }
                    catch(Exception e) 
                    {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    clearContent();
                    displayAndReloadRecords();
                }
                else if(evt.getSource()==btnDelete)
                {
                    String id = txtId.getText();
                        try 
                        {
                            String sql="DELETE FROM book_info WHERE id='"+id+"'";
                            stmt.execute(sql);
                            JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
                        }
                        catch(Exception e) 
                        {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    displayAndReloadRecords();

                }
                else if(evt.getSource()==btnSelect)
                {
                   displayAndReloadRecords();
                }
            }
       void displayAndReloadRecords()
       {
           //Clear the existing data from the tabe
            DefaultTableModel model = (DefaultTableModel)jt.getModel();
            model.setRowCount(0); //This removes all rows from the model
            try 
            {
                String sql="SELECT * FROM book_info";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()) 
                {
                    String id=rs.getString(1);
                    String name=rs.getString(2);
                    String author=rs.getString(3);
                    String pub=rs.getString(4);
                    String price=rs.getString(5);
                                
                    String[] result = {id,name,author,pub,price};
                    model.addRow(result);
                    //model.addRow(new String[]{id,name,address});
                 }
            }
            catch(Exception e) 
            {
              JOptionPane.showMessageDialog(null, e);
            }
        }
    public static void main(String[] args) 
    {
        new BookInfoDB();
    }
}