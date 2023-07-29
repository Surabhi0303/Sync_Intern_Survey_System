import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Login {


    public static void main(String[] args) throws SQLException {
        String username;
        String password;

        UserRegistration.JDBC_Connection();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter you username");

        username = scanner.next();


        System.out.println("Enter you password");

        password = scanner.next();


        password = UserRegistration.hashPassword(password);


        // Create a Statement to execute the SELECT query
        Statement statement = UserRegistration.con.createStatement();


        // Prepare the SQL query with placeholders for username and password
        String sqlQuery = "SELECT name,ID FROM users WHERE user_name = ? AND password = ?";

        // Create a PreparedStatement to execute the SELECT query
        PreparedStatement preparedStatement = UserRegistration.con.prepareStatement(sqlQuery);

        // Set the username and password as parameters
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        // Execute the SELECT query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the results
        if (resultSet.next()) {
            // Retrieve the 'name' value from the result set
            Integer ID = resultSet.getInt("ID");

            System.out.println("Name: " + ID);
        } else {
            System.out.println("User not found or incorrect credentials.");
        }


    }


    public static   int Login(String UserName, String Password) throws SQLException {
        UserRegistration.JDBC_Connection();

       Integer ID;


        // Prepare the SQL query with placeholders for username and password
        String sqlQuery = "SELECT name,ID FROM users WHERE user_name = ? AND password = ?";

        // Create a PreparedStatement to execute the SELECT query
        PreparedStatement preparedStatement = UserRegistration.con.prepareStatement(sqlQuery);

        // Set the username and password as parameters
        preparedStatement.setString(1, UserName);

        Password=UserRegistration.hashPassword(Password);
        preparedStatement.setString(2, Password);

        // Execute the SELECT query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the results
        if (resultSet.next()) {
            // Retrieve the 'name' value from the result set
            ID = resultSet.getInt("ID");

            return ID;


        } else {
            System.out.println("User not found or incorrect credentials.");
        }

        return 0;



    }

}
