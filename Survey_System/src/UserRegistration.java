import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;



public class UserRegistration {





     public static Connection con;
    static int ID=100;
    static String username="";
    static String Name="";
    static String password="";


    public  static void Registration(String name,String email,String username,String password) throws SQLException {
        JDBC_Connection();



        String sql = "INSERT INTO users (name, user_name,password,email) VALUES (?,?,?,?)";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,name);
        st.setString(2,username);

        password=hashPassword(password);
        st.setString(3,password);
        st.setString(4,email);
        st.executeUpdate();



    }


    public  static void Survey(String name,int rating,String suggestions) throws SQLException {
        JDBC_Connection();



        String sql = "INSERT INTO survey (name, rating,feedback,UserID) VALUES (?,?,?,?)";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,name);
        st.setInt(2,rating);


        st.setString(3,suggestions);

        st.setInt(4,Dashboard.ID);

        st.executeUpdate();



    }
    public static void main(String[] args) throws SQLException {












        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter you Name");
        Name=scanner.next();

        System.out.println("Enter you username");

        username=scanner.next();


        System.out.println("Enter you password");

        password=scanner.next();

        password=hashPassword(password);




        String sql = "INSERT INTO users (name, user_name,password) VALUES (?,?,?)";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,Name);
        st.setString(2,username);
        st.setString(3,password);

        st.executeUpdate();

        System.out.println("record inserted successfully");



    }


    public static void JDBC_Connection()
    {
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
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



//Hashing Password
    public static String hashPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convert the password string to bytes
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);

            // Calculate the hash
            byte[] hashedBytes = md.digest(passwordBytes);

            // Convert the hashed bytes to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log or throw a custom exception)
            return null;
        }
    }


    }







