package Practical.Assignment23;

import java.sql.*;

public class EmployeeResultSet {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Rishu@2610";

        try {

            Connection con = DriverManager.getConnection(
                    url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT id, name, department, salary FROM employee";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("===== EMPLOYEE DETAILS =====");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println("Employee ID : " + id);
                System.out.println("Name        : " + name);
                System.out.println("Department  : " + department);
                System.out.println("Salary      : " + salary);
                System.out.println("-----------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());

        }
    }
}