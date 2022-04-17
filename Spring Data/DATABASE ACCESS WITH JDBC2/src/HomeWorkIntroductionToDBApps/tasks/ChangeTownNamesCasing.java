package HomeWorkIntroductionToDBApps.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class ChangeTownNamesCasing extends HomeWorkImpl {

    public ChangeTownNamesCasing(Connection connection) {
        super(connection);
    }



    @Override
    public void solveTask() throws SQLException, IOException {
        System.out.print("Please enter country name: ");
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        String countryName = bf.readLine();
        Methods methods = new Methods(super.connection);
        query = ("UPDATE towns SET name = UPPER(name) WHERE country = ? AND name NOT LIKE BINARY UPPER(name);");
        statement = connection.prepareStatement(query);
        statement.setString(1, countryName);
        int affectedRows = statement.executeUpdate();
        if(affectedRows>0){
            System.out.printf("%d town names were affected.%n", affectedRows);
            super.query = ("SELECT name FROM towns WHERE country = ?");
            super.statement = connection.prepareStatement(query);
            super.statement.setString(1, countryName);
            super.rs = statement.executeQuery();
            StringBuilder output = new StringBuilder().append("[");
            while (rs.next()){
                output.append(rs.getString("name")).append(", ");
            }
            output.delete(output.length()-2, output.length());
            output.append("]");
            System.out.println(output);
    }else{
            System.out.println("No town names were affected.");
        }
        System.out.println("Before task 7 you have to reboot your database or results for task 7 will be incorrect.");
    }
}
