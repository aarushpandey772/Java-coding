package Practical.Assignment19;

import java.sql.*;

public class ProductDetails {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Rishu@2610";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Execute SELECT query
            String query = "SELECT product_id, product_name, quantity, price FROM product";
            ResultSet rs = stmt.executeQuery(query);

            // Display product details
            System.out.println("Product Details:");
            System.out.println("------------------------------------------------");

            while (rs.next()) {
                System.out.println("Product ID   : " + rs.getInt("product_id"));
                System.out.println("Product Name : " + rs.getString("product_name"));
                System.out.println("Quantity     : " + rs.getInt("quantity"));
                System.out.println("Price        : " + rs.getDouble("price"));
                System.out.println("------------------------------------------------");
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
