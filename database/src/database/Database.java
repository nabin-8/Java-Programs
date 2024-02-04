
package database;
import java.sql.Connection;
import java.sql.*; //Step 1. Import required packages
import java.sql.DriverManager;



public class Database {

    public static void main(String[] args) {
         try {
            // Step 2. Load and Register MySQL Driver
            Class.forName("com.mysql.jdbc.Driver");
            // Step 3. Establish the connection
            String url = "jdbc:mysql://localhost:3306/triton_company";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);
            // Step 4. Create the statement
            Statement stmt = conn.createStatement();
            // Step 5. Create and Execute Query
            String insertQuery = "insert into tryemploy_tbl values(2,'nabina Acharya',45200,'HR')";
            int record = stmt.executeUpdate(insertQuery);

            // step6. process the result/ check wether record is inserted or not
            if (record > 0) {
                System.out.println("Record inserted successuflly");

            } else {
                System.out.println("Err while inserting record");
            }

            // step7/
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
  
    }
    
}
