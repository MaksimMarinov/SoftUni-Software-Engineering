package HomeWorkIntroductionToDBApps.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class AddMinion extends HomeWorkImpl {
    public AddMinion(Connection connection) {
        super(connection);

    }

    @Override
    public void solveTask() throws SQLException, IOException {
        Methods methods = new Methods(super.connection);
        System.out.println("Please enter the input: ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] minionInfo = methods.getInfoTokens(bf);
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];
        String[] villainInfo = methods.getInfoTokens(bf);
        String villainName = villainInfo[1];
        boolean checkIsTheTownInTheDatabase = methods.checkIfTheNameIsInTheTable(minionTown, "towns");

        if(!checkIsTheTownInTheDatabase){
            methods.addTown(minionTown);
            System.out.printf("Town %s was added to the database.%n", minionTown);
        }
        boolean checkIsTheNameInTheDatabase = methods.checkIfTheNameIsInTheTable(villainName, "villains");
        if(!checkIsTheNameInTheDatabase){
            methods.addVillain(villainName, "villains");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
        int townId = methods.getEntityIdByName(minionTown, "towns");
        methods.addMinionToDatabase(minionAge, minionName, townId);
        int minionId = methods.getEntityIdByName(minionName, "minions");
        int villainId = methods.getEntityIdByName(villainName, "villains");
        methods.addMinionToVillain(minionId, villainId);
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }
}
