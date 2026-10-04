package Practical.Assignment20;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USERNAME = "root";
    static final String PASSWORD = "Rishu@2610";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            while (true) {

                System.out.println("\n===== STUDENT MANAGEMENT =====");
                System.out.println("1. Create Student");
                System.out.println("2. Read Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // CREATE
                        System.out.print("Enter Roll Number: ");
                        int rollNo = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO student VALUES (?, ?, ?, ?)";

                        PreparedStatement insertStmt =
                                con.prepareStatement(insertQuery);

                        insertStmt.setInt(1, rollNo);
                        insertStmt.setString(2, name);
                        insertStmt.setString(3, course);
                        insertStmt.setDouble(4, marks);

                        insertStmt.executeUpdate();

                        System.out.println("Student added successfully!");

                        insertStmt.close();
                        break;

                    case 2:
                        // READ
                        Statement stmt = con.createStatement();

                        ResultSet rs =
                                stmt.executeQuery("SELECT * FROM student");

                        System.out.println("\nStudent Records");
                        System.out.println("-----------------------------------------");

                        while (rs.next()) {

                            System.out.println(
                                    "Roll No : " + rs.getInt("roll_no"));

                            System.out.println(
                                    "Name    : " + rs.getString("name"));

                            System.out.println(
                                    "Course  : " + rs.getString("course"));

                            System.out.println(
                                    "Marks   : " + rs.getDouble("marks"));

                            System.out.println("-----------------------------------------");
                        }

                        rs.close();
                        stmt.close();
                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter Roll Number to update: ");
                        int updateRollNo = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        String updateQuery =
                                "UPDATE student SET name=?, course=?, marks=? WHERE roll_no=?";

                        PreparedStatement updateStmt =
                                con.prepareStatement(updateQuery);

                        updateStmt.setString(1, newName);
                        updateStmt.setString(2, newCourse);
                        updateStmt.setDouble(3, newMarks);
                        updateStmt.setInt(4, updateRollNo);

                        int updated = updateStmt.executeUpdate();

                        if (updated > 0)
                            System.out.println("Student updated successfully!");
                        else
                            System.out.println("Student not found.");

                        updateStmt.close();
                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter Roll Number to delete: ");
                        int deleteRollNo = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM student WHERE roll_no=?";

                        PreparedStatement deleteStmt =
                                con.prepareStatement(deleteQuery);

                        deleteStmt.setInt(1, deleteRollNo);

                        int deleted = deleteStmt.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Student deleted successfully!");
                        else
                            System.out.println("Student not found.");

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