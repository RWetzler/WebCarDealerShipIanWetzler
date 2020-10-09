<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>
<body>
<form action = "editItemServlet" method="post">
ID of Car you Wish to change: <input type ="text" name = "id">
Column of Car you Wish to change: <input type = "text" name = "entry">
Edit: <input type = "text" name = "change">
<input type = "submit" value="Edit Car">
</form>
</body>
</html>