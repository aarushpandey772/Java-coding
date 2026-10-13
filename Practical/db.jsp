
<%@ page import="java.sql.*" %>
<%!
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/employee_db",
            "root",
            "Rishu@2610"
        );
    }
%>
