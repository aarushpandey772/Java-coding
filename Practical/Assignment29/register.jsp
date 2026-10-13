```jsp
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h1>Student Registration Form</h1>

    <form action="result.jsp" method="post">
        <label>Full Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>Email:</label>
        <input type="email" name="email" required>
        <br><br>

        <label>Phone Number:</label>
        <input type="tel" name="phone" required>
        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>
        <br><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>
```