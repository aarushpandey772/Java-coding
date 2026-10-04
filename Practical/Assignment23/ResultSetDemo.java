package Practical.Assignment23;

import java.sql.*;

public class ResultSetDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Rishu@2610";

        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(
                    url, username, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Execute SELECT query
            String query = "SELECT * FROM employee";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("===== EMPLOYEE RECORDS =====");

            // Display records one by one
            while (rs.next()) {

                System.out.println("\nEmployee ID : " + rs.getInt("id"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Department  : " + rs.getString("department"));
                System.out.println("Salary      : " + rs.getDouble("salary"));

                System.out.println("-----------------------------");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}