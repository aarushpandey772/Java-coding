package Practical.Assignment24;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LibraryManagement extends JFrame {

    JTextField idField, nameField, authorField, priceField;
    JTable table;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/library_db";
    String username = "root";
    String password = "Rishu@2610";

    public LibraryManagement() {

        setTitle("Library Management System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Book ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Book Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
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
                new String[]{"Book ID", "Book Name", "Author", "Price"}, 0);

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add button
        addButton.addActionListener(e -> addBook());

        // View button
        viewButton.addActionListener(e -> viewBooks());

        // Update button
        updateButton.addActionListener(e -> updateBook());

        // Delete button
        deleteButton.addActionListener(e -> deleteBook());

        setVisible(true);
    }

    void addBook() {

        String query =
                "INSERT INTO books VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, Integer.parseInt(idField.getText()));
            pstmt.setString(2, nameField.getText());
            pstmt.setString(3, authorField.getText());
            pstmt.setDouble(4, Double.parseDouble(priceField.getText()));

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Book added successfully!");

            pstmt.close();
            con.close();

            viewBooks();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    void viewBooks() {

        model.setRowCount(0);

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM books");

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getDouble("price")
                });
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    void updateBook() {

        String query =
                "UPDATE books SET book_name=?, author=?, price=? WHERE book_id=?";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, nameField.getText());
            pstmt.setString(2, authorField.getText());
            pstmt.setDouble(3, Double.parseDouble(priceField.getText()));
            pstmt.setInt(4, Integer.parseInt(idField.getText()));

            int result = pstmt.executeUpdate();

            if (result > 0)
                JOptionPane.showMessageDialog(this,
                        "Book updated successfully!");
            else
                JOptionPane.showMessageDialog(this,
                        "Book not found!");

            pstmt.close();
            con.close();

            viewBooks();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    void deleteBook() {

        String query =
                "DELETE FROM books WHERE book_id=?";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, Integer.parseInt(idField.getText()));

            int result = pstmt.executeUpdate();

            if (result > 0)
                JOptionPane.showMessageDialog(this,
                        "Book deleted successfully!");
            else
                JOptionPane.showMessageDialog(this,
                        "Book not found!");

            pstmt.close();
            con.close();

            viewBooks();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LibraryManagement();
    }
}
