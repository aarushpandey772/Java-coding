```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h1>Student Information</h1>

    <p>
        <strong>Name:</strong>
        <%= request.getParameter("name") %>
    </p>

    <p>
        <strong>Roll Number:</strong>
        <%= request.getParameter("roll") %>
    </p>

    <p>
        <strong>Course:</strong>
        <%= request.getParameter("course") %>
    </p>

    <p>
        <strong>Semester:</strong>
        <%= request.getParameter("semester") %>
    </p>

    <p>
        <strong>Email:</strong>
        <%= request.getParameter("email") %>
    </p>

    <br>
    <a href="student.jsp">Back to Student Form</a>
</body>
</html>
```