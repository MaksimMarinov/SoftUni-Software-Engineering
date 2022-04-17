import HomeWorkIntroductionToDBApps.tasks.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class HomeWorkController {
    private static final String path = "jdbc:mysql://localhost:3306/";
    private static final String database = "minions_db";
    private static Connection connection;
    private static final BufferedReader bf =
           new BufferedReader(new InputStreamReader(System.in));
    private HomeWork homeWork;

    public void setConnection() throws IOException, SQLException {
        System.out.print("Enter username default(root): ");
        String user = bf.readLine();
        user = user.equals("") ? "root" : user;
        System.out.print("Enter password default(12345): ");
        String password = bf.readLine();
        password= password.equals("") ? "12345" : password;
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        connection = DriverManager.getConnection(path+database, properties);
    }

    public void executeTask() throws IOException, SQLException {

        while (true){
            System.out.print("Please, enter task number to solve: ");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String taskNumber = bf.readLine();
            switch (taskNumber){
                case "1":
                    System.out.println("First task is just to see diagram :)");
                    break;
                case "2":
                    homeWork = new GetVillainsNames(connection);
                    break;
                case "3":
                    homeWork= new GetMinionNames(connection);
                    break;
                case "4":
                    homeWork = new AddMinion(connection);
                    break;
                case "5":
                    homeWork = new ChangeTownNamesCasing(connection);
                        break;
                case "6":
                homeWork = new RemoveVillain(connection);
                    break;
                case "7":
                homeWork = new PrintAllMinionNames(connection);
                    break;
                case "8":
                    homeWork = new IncreaseMinionsAge(connection);
                    break;
                case "9":
                    homeWork = new IncreaseAgeStoredProcedure(connection);
                    break;
                default:
                    System.out.printf("Entered task number is not valid!%nPlease try again, you must enter single number from  2 to 9%n");
                    continue;

            }
            homeWork.solveTask();

            System.out.printf("Do you want to check another task?%n If yes, please press y%n" +
                    "If no, you can press any key %n");
            String decision = bf.readLine();
            if(!decision.equals("y")){
                System.out.println("Thank you for participation!");
                connection.close();
                bf.close();
                return;
            }


        }
    }
}
