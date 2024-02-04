
package dbatabase;
import java.sql.Connection;
import java.sql.*; //Step 1. Import required packages
import java.sql.DriverManager;



public class UpdateDatabase {
    public void UpdateDatabase()
    {
        try {
        //Step 2. Load and Register MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        //Step 3. Create and Establish the Connection to MySQL Server
        String url = "jdbc:mysql://localhost:3306/javatest_db";
        String username="root";
        String password="";
        Connection conn = DriverManager.getConnection(url, username, password);
        //Step 4. Create the statement
        Statement stmt = conn.createStatement();
        //Step 5. Create and Execute SQL Command
        String updateQuery = "update testjava_tbl set name='Dart', email='dart@gmail.com' where testjava_tbl=1";
        int result = stmt.executeUpdate(updateQuery);
        //Step 6. Process or Check the Successfull execution
        if(result>0)
        {
            System.out.println("Record updated successfully...");
        }
        else
        {
            System.out.println("Error while updating records...");
        }
        //Step 7. Closing connection and other resources
        conn.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    
    }
    
}
