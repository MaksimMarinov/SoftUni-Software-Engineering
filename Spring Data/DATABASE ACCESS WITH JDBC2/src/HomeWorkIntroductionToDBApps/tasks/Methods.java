package HomeWorkIntroductionToDBApps.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Methods {
    private String query;
    private PreparedStatement statement;
   private ResultSet rs;
   private Connection connection;

    public Methods(Connection connection) {
        this.connection = connection;
    }

    public String getEntityNameById(int entityId, String tableName) throws SQLException {
       query = String.format("SELECT name FROM %s WHERE id = ?", tableName);
        statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);
        rs = statement.executeQuery();
        return rs.next() ? rs.getString("name") : null;
    }
    public void addMinionToVillain(int minionId, int villainId ) throws SQLException {
        query = ("INSERT INTO minions_villains (minion_id, villain_id) VALUE (?,?);");
        statement = connection.prepareStatement(query);
        statement.setInt(1, minionId);
        statement.setInt(2, villainId);
        statement.executeUpdate();
    }


    public void addMinionToDatabase(int minionAge, String minionName, int townId) throws SQLException {
        query = ("INSERT INTO minions (name, age, town_id ) VALUE (?,?,?);");
        statement = connection.prepareStatement(query);
        statement.setString(1, minionName);
        statement.setInt(2, minionAge);
        statement.setInt(3, townId);
        statement.executeUpdate();
    }

    public void addTown(String entity) throws SQLException {
        query = ("INSERT INTO towns (name) VALUE (?);");
        statement = connection.prepareStatement(query);
        statement.setString(1, entity);
        statement.executeUpdate();
    }

    public void addVillain(String entity, String tableName) throws SQLException {
        query = String.format("INSERT INTO %s(name, evilness_factor) VALUES (?, ?);", tableName);
        //query = ("INSERT INTO villains(name, evilness_factor) VALUES (?, ?);");

        statement = connection.prepareStatement(query);
        statement.setString(1, entity);
        statement.setString(2, "evil");
        statement.executeUpdate();
    }

    public boolean checkIfTheNameIsInTheTable(String name, String tableName) throws SQLException {
        query = String.format("SELECT name FROM %s WHERE name = ?", tableName);
        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        rs = statement.executeQuery();
        return rs.next();
    }


    int getEntityIdByName(String name, String tableName) throws SQLException {
        query = String.format("SELECT id FROM %s WHERE name = ?", tableName);
        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        rs = statement.executeQuery();
        return rs.next() ? rs.getInt("id") : null;
    }

    public String[] getInfoTokens(BufferedReader bf) throws IOException {
        return bf.readLine().split("\\s+");
    }


}
