<!-- user.jsp -->
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Page</title>
    <script>
        function showNoPermission() {
            alert("You do not have permission to add information.");
        }
    </script>
</head>
<body>
<h2>User Page</h2>
<button onclick="showNoPermission()">Add Information</button>
</body>
</html>

