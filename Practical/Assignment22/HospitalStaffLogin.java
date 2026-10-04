package Practical.Assignment22;

import java.sql.*;
import java.util.Scanner;

public class HospitalStaffLogin {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String username = "root";
        String password = "Rishu@2610";

        Scanner sc = new Scanner(System.in);

        System.out.println("===== HOSPITAL STAFF LOGIN =====");

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String inputPassword = sc.nextLine();

        String query =
                "SELECT role FROM staff WHERE login_id = ? AND password = ?";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, loginId);
            pstmt.setString(2, inputPassword);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String role = rs.getString("role");

                System.out.println("\nAuthentication Successful!");
                System.out.println("Login ID: " + loginId);
                System.out.println("Role: " + role);

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Access Granted: Doctor Dashboard");
                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Access Granted: Nurse Dashboard");
                }

            } else {

                System.out.println("\nAuthentication Failed!");
                System.out.println("Invalid Login ID or Password.");
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