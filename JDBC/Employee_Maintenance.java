import java.sql.*;

public class Employee_Maintenance {
    static final String url = "jdbc:mysql://localhost:3306/";
    static final String username = "root";
    static final String password = "Ashlok@2003";
    static final String db = "Employee";
    Connection connect;

    Employee_Maintenance() throws SQLException {
        connect = DriverManager.getConnection(url + db, username, password);
    }

    public void createEmployee(Employee ex) throws SQLException {
        if (connect != null) {
            String Query = "INSERT INTO Employee (id, name, email, address) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = connect.prepareStatement(Query);
            pstm.setInt(1, ex.getId());
            pstm.setString(2, ex.getName());
            pstm.setString(3, ex.getEmail());
            pstm.setString(4, ex.getAddress());

            pstm.execute();
            // Do not close the connection here; you might want to reuse it later.
        }
    }

    public void showAllEmployee() {
        try {
            if (connect != null) {
                String Query = "SELECT * FROM Employee";
                PreparedStatement pstm = connect.prepareStatement(Query);
                ResultSet result = pstm.executeQuery();
                System.out.println("ID\tName\tEmail\t\t\tAddress");
                while (result.next()) {
                    System.out.format("%d\t%s\t%s\t\t%s\n",
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4));
                }
            }
        } catch (SQLException ex) {
            System.out.println("There is some error while accessing the database");
            ex.printStackTrace();
        }
    }

    public void search(int id) {
        try {
            if (connect != null) {
                String Query = "SELECT * FROM Employee WHERE id = ?";
                PreparedStatement pstm = connect.prepareStatement(Query);
                pstm.setInt(1, id);
                ResultSet result = pstm.executeQuery();
                System.out.println("ID\tName\tEmail\t\t\tAddress");
                while (result.next()) {
                    System.out.format("%d\t%s\t%s\t\t%s\n",
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Sorry, there is no Employee with ID = " + id);
            ex.printStackTrace();
        }
    }

    public void update(int id, String name) {
        try {
            if (connect != null) {
                String Query = "UPDATE Employee SET name = ? WHERE id = ?";
                PreparedStatement pstm = connect.prepareStatement(Query);
                pstm.setString(1, name);
                pstm.setInt(2, id);
                pstm.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Sorry, there is no Employee with ID = " + id);
            ex.printStackTrace();
        }
    }

    public void remove(int id) {
        try {
            if (connect != null) {
                String Query = "DELETE FROM Employee WHERE id = ?";
                PreparedStatement pstm = connect.prepareStatement(Query);
                pstm.setInt(1, id);
                pstm.execute();
                System.out.println("Employee Deleted Successfully");
            }
        } catch (SQLException ex) {
            System.out.println("Sorry, there is no Employee with ID = " + id);
            ex.printStackTrace();
        }
    }
}
