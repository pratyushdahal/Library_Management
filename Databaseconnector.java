package librarymanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Databaseconnector {

    private Connection connection;

 public void connectToDb(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/library_management?user=root&password=";
        connection = DriverManager.getConnection(url);
         
 }catch(Exception e){
    System.out.println(e);

 }
    }

public Statement createStatement() {
    try 
    {
        return connection.createStatement();
    }
    catch(SQLException sqex)
    {
        sqex.printStackTrace();
        return null;
    }
}
   
   
    
    
}
