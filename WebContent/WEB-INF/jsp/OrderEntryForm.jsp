<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Entry Form</title>
</head>
<body>
<form:form modelAttribute="order" method="post" action="purchase/submitItems">

    <table style="border= 2px solid black">
 	<tr>
 		<th>Name</th>
 		<th>Price</th>
 		<th>Quantity</th>
 	</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><c:out value="${item.name}"></c:out></td>
			<td><c:out value="$ ${item.price}"></c:out></td>
			<td><form:input path="items[${loop.index}].quantity" /></td>
		</tr>
	</c:forEach>

	  <tr>
		<td colspan="2"><input type="submit" value="Purchase"></td>
	  </tr>
	

    </table>
</form:form>

</body>
</html>