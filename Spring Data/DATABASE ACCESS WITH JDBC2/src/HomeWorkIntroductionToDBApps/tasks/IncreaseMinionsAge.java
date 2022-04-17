package HomeWorkIntroductionToDBApps.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class IncreaseMinionsAge extends HomeWorkImpl{
    public IncreaseMinionsAge(Connection connection) {
        super(connection);
    }

    @Override
    public void solveTask() throws SQLException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the minion ids with space between them: ");
        int[] ids = getIntInfoTokens( bf);
        query =("UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id = ?;");
        statement = connection.prepareStatement(query);
        for (int i = 0; i < ids.length; i++) {
            statement.setInt(1, ids[i]);
            statement.executeUpdate();
        }
        query = "SELECT name, age FROM minions";
        statement = connection.prepareStatement(query);
        super.rs = statement.executeQuery();
        while (rs.next()){
            System.out.printf("%s %d%n", rs.getString("name"), rs.getInt("age"));
        }


    }
    public int[] getIntInfoTokens(BufferedReader bf) throws IOException {
        return Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
