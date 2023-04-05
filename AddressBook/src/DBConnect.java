import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection conn;
    
    public static Connection getConnection() {
        // if a connection has already been established, return it
        if (conn != null) {
            return conn;
        }
        
        // if a connection hasn't been established, create one
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Error connecting to database: " + ex.getMessage());
        }
        
        return conn;
    }
}
