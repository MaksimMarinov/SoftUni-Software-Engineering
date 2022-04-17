package HomeWorkIntroductionToDBApps.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class GetMinionNames extends HomeWorkImpl {

    public GetMinionNames(Connection connection) {
        super(connection);
    }

    @Override
    public void solveTask() throws SQLException, IOException {
        System.out.print("Please insert villain_id: ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int villain_id =  Integer.parseInt(bf.readLine());
        Methods methods = new Methods(connection);
        String villainName = methods.getEntityNameById(villain_id, "villains");
        if(villainName == null){
            System.out.printf("No villain with ID %d exists in the database.%n", villain_id);
        }else{
            query = ("SELECT m.name, m.age FROM villains AS v JOIN minions_villains mv on v.id = mv.villain_id\n" +
                    "JOIN minions m on m.id = mv.minion_id\n" +
                    "WHERE v.name = ? ");
            statement= connection.prepareStatement(query);
            statement.setString(1,villainName);
            System.out.printf("Villain: %s%n", villainName);
            rs = statement.executeQuery();
            int counter = 1;
            while (rs.next()){
                System.out.printf("%d. %s %d%n", counter++, rs.getString(1), rs.getInt(2));
            }
        }
    }
}
