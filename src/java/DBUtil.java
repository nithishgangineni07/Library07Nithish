
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
      public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "7350");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}
