```jsp
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h1>Enter Student Information</h1>

    <form action="displayStudent.jsp" method="post">
        <label>Student Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>Roll Number:</label>
        <input type="text" name="roll" required>
        <br><br>

        <label>Course:</label>
        <input type="text" name="course" required>
        <br><br>

        <label>Semester:</label>
        <input type="number" name="semester" min="1" required>
        <br><br>

        <label>Email:</label>
        <input type="email" name="email" required>
        <br><br>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
```