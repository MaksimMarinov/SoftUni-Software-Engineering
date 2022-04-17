package HomeWorkIntroductionToDBApps.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class IncreaseAgeStoredProcedure extends HomeWorkImpl {

    public IncreaseAgeStoredProcedure(Connection connection) {
        super(connection);
    }

    @Override
    public void solveTask() throws SQLException, IOException {
        statement = connection.prepareStatement("CALL usp_get_older (?)");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter id: ");
        int inputId = Integer.parseInt(bf.readLine());
        statement.setInt(1, inputId);
        rs = statement.executeQuery();
        query = String.format("SELECT name, age FROM minions WHERE id = %d", inputId);
        statement = connection.prepareStatement(query);
        rs = statement.executeQuery();
            System.out.printf("%s %s%n", rs.getString("name"), rs.getInt("age"));


    }
}
