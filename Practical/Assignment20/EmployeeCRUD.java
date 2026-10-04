package Practical.Assignment20;

import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USERNAME = "root";
    static final String PASSWORD = "Rishu@2610";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            while (true) {

                System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
                System.out.println("1. Create Employee");
                System.out.println("2. Read Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // CREATE
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO employee VALUES (?, ?, ?, ?)";

                        PreparedStatement insertStmt =
                                con.prepareStatement(insertQuery);

                        insertStmt.setInt(1, id);
                        insertStmt.setString(2, name);
                        insertStmt.setString(3, department);
                        insertStmt.setDouble(4, salary);

                        insertStmt.executeUpdate();

                        System.out.println("Employee added successfully!");

                        insertStmt.close();
                        break;

                    case 2:
                        // READ
                        Statement stmt = con.createStatement();

                        ResultSet rs =
                                stmt.executeQuery("SELECT * FROM employee");

                        System.out.println("\nEmployee Records");
                        System.out.println("-----------------------------------------");

                        while (rs.next()) {
                            System.out.println("ID         : " + rs.getInt("id"));
                            System.out.println("Name       : " + rs.getString("name"));
                            System.out.println("Department : " + rs.getString("department"));
                            System.out.println("Salary     : " + rs.getDouble("salary"));
                            System.out.println("-----------------------------------------");
                        }

                        rs.close();
                        stmt.close();
                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter Employee ID to update: ");
                        int updateId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Department: ");
                        String newDepartment = sc.nextLine();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        String updateQuery =
                                "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";

                        PreparedStatement updateStmt =
                                con.prepareStatement(updateQuery);

                        updateStmt.setString(1, newName);
                        updateStmt.setString(2, newDepartment);
                        updateStmt.setDouble(3, newSalary);
                        updateStmt.setInt(4, updateId);

                        int updated = updateStmt.executeUpdate();

                        if (updated > 0)
                            System.out.println("Employee updated successfully!");
                        else
                            System.out.println("Employee not found.");

                        updateStmt.close();
                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter Employee ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM employee WHERE id=?";

                        PreparedStatement deleteStmt =
                                con.prepareStatement(deleteQuery);

                        deleteStmt.setInt(1, deleteId);

                        int deleted = deleteStmt.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Employee deleted successfully!");
                        else
                            System.out.println("Employee not found.");

                        deleteStmt.close();
                        break;

                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Program exited.");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}