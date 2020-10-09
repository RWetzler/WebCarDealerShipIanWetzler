<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy A Car!</title>
</head>
<body>
<form action = "addCustomer" method="post">
<c:forEach items="${requestScope.allCars}" var="currentCar">
<tr>
 <td><input type="radio" name="id" value="${currentCar.id}"></td>
 <td>${currentCar.make}</td>
 <td>${currentCar.model}</td>
  </tr>
</c:forEach>
Name: <input type ="text" name = "name">
Phone Number: <input type = "text" name = "cellNumber">
<input type = "submit" value="Buy">
</form>
</body>
</html>