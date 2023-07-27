import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
This Class is only responsible for establishing connection for other class
The methods (operations) are separately  defined int there classes
using the instances of connection of this class : )
* */
public class JDBC_Connection {
    static final String url = "jdbc:mysql://localhost:3306/";
    static final String username = "root";
    static final String password = "Ashlok@2003";
    static Connection connect;

    public static Connection connect() throws SQLException {
        String db = "Employee";
        connect = DriverManager.getConnection(url + db, username, password);
        return connect;
    }

}
