package Practical.Assignment21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Rishu@2610";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            if (con != null) {
                System.out.println("Database Connection Successful!");
                System.out.println("Connection Status: CONNECTED");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            System.out.println("Connection Status: NOT CONNECTED");
            System.out.println("Error: " + e.getMessage());
        }
    }
}