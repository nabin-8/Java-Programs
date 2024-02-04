
package databaseexam;
import java.sql.*;
public class insert_db {
    void insert_db()
    {
        //Start Database Code
        try{
            //Step1 Load and Register Mysql Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Step2 Create and Eastablish the connection to mysql server
            String url = "jdbc:mysql://localhost/testjavaa_db";
            String UserName="root";
            String Password="";
            Connection conn =DriverManager.getConnection(url,UserName,Password);
            
            //Step3 Create Statement
            Statement stm=conn.createStatement();
            String insertQuery = "insert into testjava_tbl values(2,'Acharya Nabin','acharya@gmail.com')";
            int result =stm.executeUpdate(insertQuery);
            
            //Check the Successfull query
            if(result>0)
            {
                System.out.println("Execute Successfully");
            }else{
                System.out.println("Error execution");
            }
            
            //Close the connection
            conn.close();
            stm.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
