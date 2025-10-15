import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/librarydb";
        String username = "root";
        String password = "";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new SQLException("Unable to connect to the database.", e);
        }
    }
}
