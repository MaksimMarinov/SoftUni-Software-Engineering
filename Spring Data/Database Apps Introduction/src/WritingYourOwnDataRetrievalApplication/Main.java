package WritingYourOwnDataRetrievalApplication;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = scanner.nextLine();

        user = user.equals("") ? "root" : user;
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        password = password.equals("") ? "12345" : password;

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT u.user_name, u.first_name, u.last_name, COUNT(g.game_id) AS 'count' FROM users AS u JOIN users_games AS g ON g.user_id = u.id WHERE u.user_name = ?");
            String username = scanner.nextLine();
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                if(rs.getString("user_name") != null)
                {
                    System.out.printf("User: %s%n%s %s has played %d games",rs.getString("user_name")
                            ,rs.getString("first_name"), rs.getString("last_name")
                            ,rs.getInt("count"));
                }else{
                    System.out.println("No such user exists");
                }
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
