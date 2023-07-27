import java.sql.*;
import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Employee_Maintenance parent = new Employee_Maintenance();
        System.out.println("Employee Management System using JDBC");
        while (true) {
            System.out.println("""
                    1. Add Employee\s
                    2. Show All Employee Details\s
                    3. Search Employee\s
                    4. Update Employee Details\s
                    5. Remove Employee From Database\s
                    6. Exit \s
                    """);
            int opt = sc.nextInt();
            switch(opt){
                case 1 -> {
                    System.out.println("Enter Employee [ID, Name, Email, Address]");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    String email = sc.nextLine();
                    String address = sc.nextLine();
                    Employee ex = new Employee(id, name, email, address);
                    parent.createEmployee(ex);
                }
                case 2 -> {
                    parent.showAllEmployee();
                }
                case 3 ->{
                    System.out.println("Enter The id of Employee: ");
                    int id = sc.nextInt();
                    parent.search(id);
                }
                case 4 -> {
                    System.out.println("Enter The id & New Name of Employee: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    parent.update(id,name);
                }
                case 5 -> {
                    System.out.println("Enter The id of Employee to remove: ");
                    int id = sc.nextInt();
                    parent.remove(id);
                }
                case 6 -> {
                    System.out.println("Thank You For Using The Module");
                    return;
                }
                default -> {
                    System.out.println("Please Choose Appropriate Option :/");
                }
            }

        }

    }
}