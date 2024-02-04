
package dbatabase;
import java.sql.Connection;
import java.sql.*; //Step 1. Import required packages
import java.sql.DriverManager;

public class DeleteDatabase {
    public void DeleteDatabase()
    {
    
        try {
        //Step 2. Load and Register MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        //Step 3. Create and Establish the Connection to MySQL Server
        String url = "jdbc:mysql://localhost/javatest_db";
        String username="root";
        String password="";
        Connection conn = DriverManager.getConnection(url, username, password);
        //Step 4. Create the statement
        Statement stmt = conn.createStatement();
        //Step 5. Create and Execute SQL Command
        String deleteQuery = "delete from testjava_tbl where testjava_tbl=1";
        int result = stmt.executeUpdate(deleteQuery);
        //Step 6. Process or Check the Successfull execution
        if(result>0)
        {
            System.out.println("Record deleted successfully...");
        }
        else
        {
            System.out.println("Error while deleting record...");
        }
        //Step 7. Closing connection and other resources
        conn.close();
        } catch (Exception e) {
        System.out.println(e);
        }
    }
    
    
}
