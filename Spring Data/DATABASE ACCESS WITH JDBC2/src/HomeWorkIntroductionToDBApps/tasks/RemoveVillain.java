package HomeWorkIntroductionToDBApps.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoveVillain extends HomeWorkImpl{
    public RemoveVillain(Connection connection) {
        super(connection);
    }

    @Override
    public void solveTask() throws SQLException, IOException {
        Methods methods =  new Methods(connection);
        System.out.print("Please enter villain id: ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.parseInt(bf.readLine());
        String  villainName  = methods. getEntityNameById(villainId, "villains");
        if(villainName == null){
            System.out.println("No such villain was found");

        }else{
            query = "DELETE FROM minions_villains WHERE villain_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, villainId);
            int affectedEntities = statement.executeUpdate();
            query ="DELETE FROM villains where id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, villainId);
            statement.executeUpdate();


            System.out.printf("%s was deleted%n%d minions released%n", villainName, affectedEntities);
        }



    }




}
