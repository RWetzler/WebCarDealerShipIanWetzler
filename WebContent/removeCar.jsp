<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove a car</title>
</head>
<body>
<form action = "deleteAnCustomerServlet" method="post">
<c:forEach items="${requestScope.allCustomers}" var="currentCustomer">
<tr>
 <td><input type="radio" name="id" value="${currentCustomer.id}"></td>
 
 <td>Name: ${currentCustomer.name}</td>
	<td>Car ID:${currentCustomer.car}</td>
<td>Purchased Date: ${currentCustomer.purchaseDate}</td>
<td>Phone Number: ${currentCustomer.cellNumber}</td>
 </tr>
</c:forEach>

<input type = "submit" value="remove">
</form>
</body>
</html>