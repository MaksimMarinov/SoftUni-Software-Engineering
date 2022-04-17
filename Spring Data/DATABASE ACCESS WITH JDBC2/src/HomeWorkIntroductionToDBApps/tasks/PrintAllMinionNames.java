package HomeWorkIntroductionToDBApps.tasks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;

public class PrintAllMinionNames extends HomeWorkImpl {

    public PrintAllMinionNames(Connection connection) {
        super(connection);
    }

    @Override
    public void solveTask() throws SQLException {
        super.query = "SELECT name FROM minions";
        super.statement = super.connection.prepareStatement(query);
        super.rs = statement.executeQuery();
        ArrayDeque<String> minions = new ArrayDeque<>();
        while (rs.next()){
            String minion = rs.getString("name");
            minions.offer(minion);
        }
        while (!minions.isEmpty()){
            System.out.println(minions.pollFirst());
            System.out.println(minions.pollLast());
        }

    }
}
