
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String url = "jdbc:mysql://localhost:3306/employee_db";
String dbUser = "root";
String dbPassword = "Rishu@2610";

String action = request.getParameter("action");
String message = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword)) {

        if ("add".equals(action)) {
            String sql = "INSERT INTO employees(name, department, salary, email) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("department"));
                ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                ps.setString(4, request.getParameter("email"));
                ps.executeUpdate();
            }
            message = "Employee added successfully!";
        }

        if ("update".equals(action)) {
            String sql = "UPDATE employees SET name=?, department=?, salary=?, email=? WHERE emp_id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("department"));
                ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                ps.setString(4, request.getParameter("email"));
                ps.setInt(5, Integer.parseInt(request.getParameter("emp_id")));
                int count = ps.executeUpdate();
                message = count > 0 ? "Employee updated successfully!" : "Employee ID not found.";
            }
        }

        if ("delete".equals(action)) {
            try (PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM employees WHERE emp_id=?")) {
                ps.setInt(1, Integer.parseInt(request.getParameter("emp_id")));
                int count = ps.executeUpdate();
                message = count > 0 ? "Employee deleted successfully!" : "Employee ID not found.";
            }
        }
    }
} catch (Exception e) {
    message = "Error: " + e.getMessage();
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
</head>
<body>
    <h1>Employee Management System</h1>

    <p><strong><%= message %></strong></p>

    <h2>Add Employee</h2>
    <form method="post" action="employees.jsp">
        <input type="hidden" name="action" value="add">

        Name: <input type="text" name="name" required><br><br>
        Department: <input type="text" name="department" required><br><br>
        Salary: <input type="number" name="salary" step="0.01" min="0" required><br><br>
        Email: <input type="email" name="email" required><br><br>

        <button type="submit">Add Employee</button>
    </form>

    <hr>

    <h2>Update Employee</h2>
    <form method="post" action="employees.jsp">
        <input type="hidden" name="action" value="update">

        Employee ID: <input type="number" name="emp_id" min="1" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Department: <input type="text" name="department" required><br><br>
        Salary: <input type="number" name="salary" step="0.01" min="0" required><br><br>
        Email: <input type="email" name="email" required><br><br>

        <button type="submit">Update Employee</button>
    </form>

    <hr>

    <h2>Delete Employee</h2>
    <form method="post" action="employees.jsp"
          onsubmit="return confirm('Are you sure you want to delete this employee?');">
        <input type="hidden" name="action" value="delete">

        Employee ID: <input type="number" name="emp_id" min="1" required><br><br>
        <button type="submit">Delete Employee</button>
    </form>

    <hr>

    <h2>View All Employees</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Email</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "SELECT emp_id, name, department, salary, email FROM employees ORDER BY emp_id");
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("emp_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getBigDecimal("salary") %></td>
            <td><%= rs.getString("email") %></td>
        </tr>
        <%
                }
            }
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="5">Unable to retrieve employees: <%= e.getMessage() %></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
