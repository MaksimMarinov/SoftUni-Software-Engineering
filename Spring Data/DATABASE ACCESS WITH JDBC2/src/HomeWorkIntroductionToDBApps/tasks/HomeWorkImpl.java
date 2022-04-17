package HomeWorkIntroductionToDBApps.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class HomeWorkImpl  implements HomeWork {
    protected Connection connection;
    protected String query;
    protected PreparedStatement statement;
    protected ResultSet rs;

    protected HomeWorkImpl(Connection connection) {
        this.connection = connection;
    }
}
