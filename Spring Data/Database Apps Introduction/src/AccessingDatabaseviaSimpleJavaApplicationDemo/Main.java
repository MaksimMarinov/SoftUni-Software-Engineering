package AccessingDatabaseviaSimpleJavaApplicationDemo;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");

        String user = scanner.nextLine().trim();
         user = user.equals("") ? "root" : user;

        System.out.print("Enter password: ");
         String password = scanner.nextLine().trim();
         password = password.equals("") ? "12345" : password;

         Properties props = new Properties();
         props.setProperty("user", user);
         props.setProperty("password", password);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT first_name, last_name FROM employees WHERE salary > ? ORDER BY salary");
            double salary = Double.parseDouble(scanner.nextLine());
            stmt.setDouble(1, salary);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.printf("%s %s%n", rs.getString("first_name"), rs.getString("last_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
