<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Car!</title>
</head>
<body>
<form action = "AddItemServlet" method="post">
ID: <input type ="text" name = "id">
Make: <input type = "text" name = "make">
Model: <input type = "text" name = "model">
Year: <input type = "text" name = "year">
<input type = "submit" value="Add Car">
</form> <br />
</body>
</html>