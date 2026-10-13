```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
    <h1>Registration Successful!</h1>

    <h2>Student Details</h2>

    <p><strong>Name:</strong> <%= request.getParameter("name") %></p>
    <p><strong>Email:</strong> <%= request.getParameter("email") %></p>
    <p><strong>Phone Number:</strong> <%= request.getParameter("phone") %></p>
    <p><strong>Password:</strong> [Hidden for security]</p>

    <br>
    <a href="register.jsp">Register Another Student</a>
</body>
</html>
```