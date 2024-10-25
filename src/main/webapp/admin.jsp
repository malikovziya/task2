<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 19.10.2024
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Page</title>
</head>
<body>
<h2>Admin Page - Add Information</h2>
<form action="AddInfoServlet" method="POST">
  <label for="info">Information:</label>
  <input type="text" id="info" name="info" required><br><br>
  <input type="submit" value="Add Info">
</form>
</body>
</html>
