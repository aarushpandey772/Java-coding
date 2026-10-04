package Practical.Assignment19;

import java.sql.*;

public class StudentRecords {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Rishu@2610";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM student";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records:");
            System.out.println("-----------------------------------------");

            while (rs.next()) {
                System.out.println("ID     : " + rs.getInt("id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Age    : " + rs.getInt("age"));
                System.out.println("Course : " + rs.getString("course"));
                System.out.println("-----------------------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}