package Practical.Assignment22;

import java.sql.*;
import java.util.Scanner;

public class LoginApplication {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/login_db";
        String username = "root";
        String password = "Rishu@2610";

        Scanner sc = new Scanner(System.in);

        System.out.println("===== LOGIN APPLICATION =====");

        System.out.print("Enter Username: ");
        String inputUsername = sc.nextLine();

        System.out.print("Enter Password: ");
        String inputPassword = sc.nextLine();

        String query =
                "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, inputUsername);
            pstmt.setString(2, inputPassword);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("\nLogin Successful!");
                System.out.println("Welcome, " + inputUsername + "!");
            } else {
                System.out.println("\nInvalid Username or Password!");
                System.out.println("Access Denied.");
            }

            rs.close();
            pstmt.close();
            con.close();
            sc.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}