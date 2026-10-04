package Practical.Assignment24;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {

    JTextField bookIdField;
    JTextField studentField;
    JTextField issueDateField;
    JTextField returnDateField;

    JTable table;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/book_issue_db";
    String username = "root";
    String password = "Rishu@2610";

    public BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        inputPanel.add(bookIdField);

        inputPanel.add(new JLabel("Student Name:"));
        studentField = new JTextField();
        inputPanel.add(studentField);

        inputPanel.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueDateField = new JTextField();
        inputPanel.add(issueDateField);

        inputPanel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnDateField = new JTextField();
        inputPanel.add(returnDateField);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Issue Book");
        JButton viewButton = new JButton("View");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Table
        model = new DefaultTableModel(
                new String[]{
                        "Book ID",
                        "Student Name",
                        "Issue Date",
                        "Return Date"
                }, 0);

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(e -> issueBook());

        viewButton.addActionListener(e -> viewRecords());

        updateButton.addActionListener(e -> updateRecord());

        deleteButton.addActionListener(e -> deleteRecord());

        setVisible(true);
    }

    // CREATE
    void issueBook() {

        String query =
                "INSERT INTO book_issue VALUES (?, ?, ?, ?)";

        try {

            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(
                    1,
                    Integer.parseInt(bookIdField.getText()));

            pstmt.setString(
                    2,
                    studentField.getText());

            pstmt.setDate(
                    3,
                    Date.valueOf(issueDateField.getText()));

            pstmt.setDate(
                    4,
                    Date.valueOf(returnDateField.getText()));

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book issued successfully!");

            pstmt.close();
            con.close();

            viewRecords();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage());
        }
    }

    // READ
    void viewRecords() {

        model.setRowCount(0);

        try {

            Connection con = DriverManager.getConnection(
                    url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs =
                    stmt.executeQuery(
                            "SELECT * FROM book_issue");

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("student_name"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date")
                });
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage());
        }
    }

    // UPDATE
    void updateRecord() {

        String query =
                "UPDATE book_issue SET student_name=?, " +
                "issue_date=?, return_date=? WHERE book_id=?";

        try {

            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setString(
                    1,
                    studentField.getText());

            pstmt.setDate(
                    2,
                    Date.valueOf(issueDateField.getText()));

            pstmt.setDate(
                    3,
                    Date.valueOf(returnDateField.getText()));

            pstmt.setInt(
                    4,
                    Integer.parseInt(bookIdField.getText()));

            int result = pstmt.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Record updated successfully!");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record not found!");
            }

            pstmt.close();
            con.close();

            viewRecords();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage());
        }
    }

    // DELETE
    void deleteRecord() {

        String query =
                "DELETE FROM book_issue WHERE book_id=?";

        try {

            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            pstmt.setInt(
                    1,
                    Integer.parseInt(bookIdField.getText()));

            int result =
                    pstmt.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Record deleted successfully!");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record not found!");
            }

            pstmt.close();
            con.close();

            viewRecords();

        }catch (Exception ex) {

    ex.printStackTrace();

    JOptionPane.showMessageDialog(
            this,
            "Error Type: " + ex.getClass().getName()
            + "\nError: " + ex.getMessage());
}
    }

    public static void main(String[] args) {

        new BookIssueTracking();
    }
}