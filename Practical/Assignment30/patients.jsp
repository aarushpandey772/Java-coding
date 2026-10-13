
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String url = "jdbc:mysql://localhost:3306/patient_db";
String dbUser = "root";
String dbPassword = "Rishu@2610";

String action = request.getParameter("action");
String message = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    if ("add".equals(action)) {
        String sql = "INSERT INTO patients VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
            ps.setString(2, request.getParameter("name"));
            ps.setInt(3, Integer.parseInt(request.getParameter("age")));
            ps.setString(4, request.getParameter("disease"));
            ps.setString(5, request.getParameter("treatment_status"));
            ps.executeUpdate();
        }

        message = "Patient added successfully!";
    }

    if ("update".equals(action)) {
        String sql = "UPDATE patients SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, request.getParameter("name"));
            ps.setInt(2, Integer.parseInt(request.getParameter("age")));
            ps.setString(3, request.getParameter("disease"));
            ps.setString(4, request.getParameter("treatment_status"));
            ps.setInt(5, Integer.parseInt(request.getParameter("patient_id")));

            int count = ps.executeUpdate();
            message = count > 0 ? "Patient updated successfully!" : "Patient ID not found.";
        }
    }

    if ("delete".equals(action)) {
        String sql = "DELETE FROM patients WHERE patient_id=?";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
            int count = ps.executeUpdate();
            message = count > 0 ? "Patient deleted successfully!" : "Patient ID not found.";
        }
    }

} catch (Exception e) {
    message = "Error: " + e.getMessage();
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Patient Record Management</title>
</head>
<body>
    <h1>Patient Record Management System</h1>
    <p><strong><%= message %></strong></p>

    <h2>Add Patient</h2>
    <form action="patients.jsp" method="post">
        <input type="hidden" name="action" value="add">

        Patient ID: <input type="number" name="patient_id" min="1" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" min="0" max="150" required><br><br>
        Disease: <input type="text" name="disease" required><br><br>

        Treatment Status:
        <select name="treatment_status" required>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>

        <button type="submit">Add Patient</button>
    </form>

    <hr>

    <h2>Update Patient</h2>
    <form action="patients.jsp" method="post">
        <input type="hidden" name="action" value="update">

        Patient ID: <input type="number" name="patient_id" min="1" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" min="0" max="150" required><br><br>
        Disease: <input type="text" name="disease" required><br><br>

        Treatment Status:
        <select name="treatment_status" required>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>

        <button type="submit">Update Patient</button>
    </form>

    <hr>

    <h2>Delete Patient</h2>
    <form action="patients.jsp" method="post">
        <input type="hidden" name="action" value="delete">
        Patient ID: <input type="number" name="patient_id" min="1" required><br><br>
        <button type="submit"
                onclick="return confirm('Delete this patient record?');">
            Delete Patient
        </button>
    </form>

    <hr>

    <h2>View All Patients</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM patients ORDER BY patient_id");
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
        </tr>
        <%
                }
            }
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="5">Unable to retrieve patients: <%= e.getMessage() %></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
