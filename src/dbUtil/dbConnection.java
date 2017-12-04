package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by biropo on 02.12.17.
 */
public class dbConnection {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN = "jdbc:mysql://localhost/login";
    private static final String SQCONN = "jdbc:sqlite:tournament.sqlite";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
