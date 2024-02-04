package consolecrud_bw;
/* Step 1. Import the package */
import java.sql.*;
import java.util.Scanner;

public class ConsoleCRUD_BW {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            /* Step 2. Load and Register the database driver */
            Class.forName("com.mysql.jdbc.Driver");
            /* Step 3. Establish the connection with MySQL Database */
            String url = "jdbc:mysql://localhost:3306/danfe";
            String user ="root";
            String password = ""; 
            Connection conn = DriverManager.getConnection(url, user, password);
            //Step 4. Create a statement Object
            Statement stmt = conn.createStatement();
           
            /* Step 5. Create and execute SQL Query to insert records */
            String insertQuery = "insert into student values"
                    + "                 (1,'Ram',25),"
                    + "                 (2,'Sita',35),"
                    + "                 (3,'Gita',15)";
            stmt.execute(insertQuery);
            System.out.println("Record inserted succesfully...");

       /* Step 5. Create and execute SQL Query to delete record */
            System.out.println("Enter the id for deletion: ");
            int i = Integer.parseInt(input.nextLine());
            String deleteQuery = "delete from student where sid='"+i+"'";
            stmt.execute(deleteQuery); 
            System.out.println("Record deleted succesfully...");

              /* Step 5. Create and execute SQL Query to update record */
              System.out.println("Enter the id for updation: ");
              int uid = Integer.parseInt(input.nextLine());
              String updateQuery = "update student set name='Hari', age=45 where sid="+uid;
              stmt.executeUpdate(updateQuery);     
              System.out.println("Record updated succesfully...");
           
               /* Step 5. Execute a Query to Select*/
               String selectQuery = "select * from student";
               ResultSet rs = stmt.executeQuery(selectQuery);
               System.out.println("ID\tName\tAge");
               while(rs.next())
               {
                   int idd = rs.getInt(1);
                   String nm = rs.getString(2);
                   int ag = rs.getInt(3);
                   System.out.println(idd+"\t"+nm+"\t"+ag);
               }
            conn.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
