<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Order Summary</title>
</head>
<body>
<form:form modelAttribute="order" method="post" action="confirmOrder">
 <h2>Here is your order: </h2>
    <table style="border= 2px solid black">
 	<tr>
 		<th>Name</th>
 		<th>Price</th>
 		<th>Quantity</th>
 	</tr>
	<c:forEach items="${order.lineItems}" var="item" varStatus="loop">
		<tr>
			<td><c:out value="${item.itemName}"></c:out></td>
			<td><c:out value="$ ${item.price}"></c:out></td>
			<td><c:out value="${item.quantity}" /></td>
		</tr>
	</c:forEach>
	  <tr>
		<td colspan="2"><input type="submit" value="Confirm order"></td>
	  </tr>
	  
	<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>

    </table>
</form:form>

</body>
</html>