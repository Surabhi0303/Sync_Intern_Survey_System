import java.sql.*;
import java.util.*;


public class JDBC_Connection {



     public static Connection con;




    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/survey_system";
        String user = "root";
        String pwd = "sheru123#";



        try{

            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, user, pwd);


            System.out.println("Database Connection Successful");









        }




        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
