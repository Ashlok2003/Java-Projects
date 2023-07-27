

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Student {
    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "Ashlok@2003";
    Connection connect;

    public void create_database() throws SQLException {

        connect = DriverManager.getConnection(url, username, password);
        Statement stm = connect.createStatement();

        System.out.println("Connection Successfully");

        String query = "create database Student";
        stm.execute(query);
        System.out.println("Student Database Created Successfully");
        connect.close();
    }

    public void createTable() throws SQLException {
        connect = DriverManager.getConnection(this.url + "Student", this.username, this.password);
        Statement stm = connect.createStatement();
        String Query = "create table Student(" +
                "id int(2), name varchar(100), email varchar(20))";
        stm.execute(Query);
        System.out.println("Table Created Successfully");
        connect.close();
    }

    public void createData() throws SQLException {
        String db = "Student";
        connect = DriverManager.getConnection(this.url + db, this.username, this.password);
        /*Statement stm = connect.createStatement();
        ArrayList<String> query = new ArrayList<>(
                List.of("INSERT INTO Student (id, name, email) VALUES (1, 'Ashlok','ashlok@gmail.com')",
                        "INSERT INTO Student (id, name, email) VALUES (2, 'Avinash','avinash@gmail.com')",
                        "INSERT INTO Student (id, name, email) VALUES (3, 'Deepak','deepak@gmail.com')",
                        "INSERT INTO Student (id, name, email) VALUES (4, 'Saurabh','saurabh@gmail.com')"));

        IntStream.range(0, query.size()).forEach(i -> {
            try {
                stm.execute(query.get(i));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });*/

        // Using PreparedStatement at the place of Statement to execute query

        String Query = "INSERT INTO Student (id, name, email) VALUES (?, ?, ?)";
        PreparedStatement pstm = connect.prepareStatement(Query);
        pstm.setInt(1, 5);
        pstm.setString(2, "Pranav");
        pstm.setString(3,"pranav@gmail.com");
        pstm.execute();

        System.out.println("Data entered successfully");
        connect.close();
    }

    public void readData() throws SQLException{
        String db = "Student";
        connect = DriverManager.getConnection(this.url + db,this.username,this.password);

        String query = "Select * from " + db;

        Statement stm = connect.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
            System.out.print(" id = " + rs.getInt(1));
            System.out.print(" name = " + rs.getString(2));
            System.out.print(" email = " + rs.getString(3));
            System.out.println();
        }
        System.out.println("Data Read Successfully");
        connect.close();

    }

    public void update() throws SQLException{
        String db = "Student";
        connect = DriverManager.getConnection(this.url + db,this.username,this.password);

        String query = "UPDATE Student set id = ? where name = ?";
        PreparedStatement pstm = connect.prepareStatement(query);
        pstm.setInt(1,50);
        pstm.setString(2,"Ashlok");
        pstm.execute();
        System.out.println("Data Updated Successfully");
        connect.close();
    }

    public void deleteData() throws SQLException{
        String db = "Student";
        connect = DriverManager.getConnection(this.url + db,this.username,this.password);

        String query = "DELETE FROM Student where name = ?";
        PreparedStatement pstm = connect.prepareStatement(query);
        pstm.setString(1,"Ashlok");
        pstm.execute();

        System.out.println("Data Deleted Successfully");
        connect.close();
    }
}
