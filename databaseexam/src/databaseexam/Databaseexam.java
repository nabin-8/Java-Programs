
package databaseexam;
import java.sql.*;
public class Databaseexam {
    void Databaseexam()
    {
         //create database code
      try{
          //Step 1 Load and Register Mysql Driver
          Class.forName("com.mysql.jdbc.Driver");
          
          //Step2 Create and Establish the Connection to mysql server
          String url="Jdbc:mysql://localhost";
          String UserName ="root";
          String Password="";
          Connection conn=DriverManager.getConnection(url,UserName,Password);
          
          //Step3 Create Statement
          Statement stm=conn.createStatement();
          
          //Step4 Create and Executesql Command
          String createdb="CREATE DATABASE testjavaa_db";
          int result =stm.executeUpdate(createdb);
          
          //Step5 process or check successfull execution
          if(result>0)
          {
              System.out.println("Database Created SuccessFully");
          }else{
              System.out.println("Faol to Create");
          }
          
          //Step6 Close Conection and other resources
          conn.close();
      }catch(Exception e)
      {
          System.out.println(e);
      }
    }
    public static void main(String[] args) {
     insert_db insert = new insert_db();
     
     insert.insert_db();
    }
    
}
