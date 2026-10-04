package Practical.Assignment21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "Rishu@2610";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("Student Database Connected Successfully!");
            System.out.println("Connection Status: CONNECTED");

            con.close();

        } catch (SQLException e) {
            System.out.println("Student Database Connection Failed!");
            System.out.println("Connection Status: NOT CONNECTED");
            System.out.println("Error: " + e.getMessage());
        }
    }
}