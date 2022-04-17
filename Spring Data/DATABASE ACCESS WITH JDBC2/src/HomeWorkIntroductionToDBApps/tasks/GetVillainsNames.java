package HomeWorkIntroductionToDBApps.tasks;

import java.sql.Connection;
import java.sql.SQLException;

public class GetVillainsNames extends HomeWorkImpl {


    public GetVillainsNames(Connection connection) {
        super(connection);
    }

    @Override
    public void solveTask() throws SQLException {
        super.query = "SELECT v.`name`, COUNT(DISTINCT m.minion_id) AS count_minions FROM villains AS v\n" +
                "JOIN minions_villains as m ON m.villain_id = v.id GROUP BY v.id\n" +
                "HAVING count_minions >15\n" +
                "ORDER BY count_minions DESC;";
        super.statement =
                super.connection.prepareStatement(query);
        super.rs = super.statement.executeQuery();
        while (rs.next()){
            System.out.printf("%s %s%n", rs.getString("v.name"), rs.getInt("count_minions"));
        }
    }
}
