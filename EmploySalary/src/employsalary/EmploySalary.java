
package employsalary;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;


public final class EmploySalary extends JFrame implements ActionListener
{
    Connection conn;
    Statement stmt;
    JTextField txtId,txtName,txtDepart,txtSalary;
    JLabel lblId,lblName,lblDepart,lblSalary;
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
        txtDepart.setText("");
        txtSalary.setText("");
    }
    
    
    EmploySalary()
    {
        getConnection();
        
        lblId = new JLabel("Employe Id:");
        lblId.setBounds(20, 20, 100, 20);
        add(lblId);
        txtId=new JTextField();
        txtId.setBounds(120, 20, 150, 20);
        add(txtId);
        
        lblName=new JLabel("Employe Name:");
        lblName.setBounds(20, 50, 100, 20);
        add(lblName);
        txtName=new JTextField();
        txtName.setBounds(120, 50, 150, 20);
        add(txtName);
        
        lblDepart = new JLabel("Department: ");
        lblDepart.setBounds(20,80, 100,20);
        add(lblDepart);
        txtDepart= new JTextField();
        txtDepart.setBounds(120, 80, 150, 20);
        add(txtDepart);
        
        lblSalary = new JLabel("Salary: ");
        lblSalary.setBounds(20, 110, 100, 20);
        add(lblSalary);
        txtSalary = new JTextField();
        txtSalary.setBounds(120, 110, 150, 20);
        add(txtSalary);
        
        btnInsert = new JButton("Insert");
        btnInsert.setBounds(10, 140, 80, 20);
        add(btnInsert);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 140, 80, 20);
        add(btnUpdate);
        
        btnDelete=new JButton("Delete");
        btnDelete.setBounds(10, 170, 80, 20);
        add(btnDelete);
        
        btnSelect=new JButton("View");
        btnSelect.setBounds(100, 170, 80, 20);
        add(btnSelect);
        
        //Creating JTable
        String[] columns = { "Eid", "Name", "Department", "salary" };
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
        
        setTitle("Employe Information App");
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
                    String depart = txtDepart.getText();
                    String salary = txtSalary.getText();
         
                    try 
                    {
                        String sql="INSERT INTO employe_info VALUES('"+id+"','"+name+"','"+depart+"','"+salary+"')";
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
                    String depart = txtDepart.getText();
                    String salary = txtSalary.getText();
                  
                    try 
                    {
                        String sql="UPDATE employe_info SET name='"+name+"',department='"+depart+"',salary='"+salary+"' WHERE id='"+id+"'";
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
                            String sql="DELETE FROM employe_info WHERE id='"+id+"'";
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
                String sql="SELECT * FROM employe_info";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()) 
                {
                    String id=rs.getString(1);
                    String name=rs.getString(2);
                    String depart=rs.getString(3);
                    String salary=rs.getString(4);
                                
                    String[] result = {id,name,depart,salary};
                    model.addRow(result);
                    //model.addRow(new String[]{id,name,address});
                 }
            }
            catch(Exception e) 
            {
              JOptionPane.showMessageDialog(null, e);
            }
        }

    public static void main(String[] args) {
      new EmploySalary();
        
    }
    
}
