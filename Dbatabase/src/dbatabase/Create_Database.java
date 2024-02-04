
package dbatabase;
import java.sql.Connection;
import java.sql.*; //Step 1. Import required packages
import java.sql.DriverManager;


public class Create_Database {
    public void Create_Database()
    {
           //this is create database code
    
         try {
        //Step 2. Load and Register MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        //Step 3. Create and Establish the Connection to MySQL Server
        String url = "jdbc:mysql://localhost";
        String username="root";
        String password="";
        
        Connection conn = DriverManager.getConnection(url, username, password);
        //Step 4. Create the statement
        Statement stmt = conn.createStatement();
        //Step 5. Create and Execute SQL Command
        String createDB = "CREATE DATABASE javaTest_db";
        int result = stmt.executeUpdate(createDB);
        //Step 6. Process or Check the Successfull execution
        if(result>0)
        {
            System.out.println("Database created successfully...");
        }
        else
        {
            System.out.println("Error while creating database...");
        }
        //Step 7. Closing connection and other resources
        conn.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    }
    
    }

