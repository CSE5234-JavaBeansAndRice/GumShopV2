<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Order Entry Form</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="orderFormTitle">New Order</div>
<div class="message">
	<% if (request.getAttribute("message") != null) { %>
		<%= request.getAttribute("message") %>
	<% } %>
</div>
<form:form modelAttribute="order" method="post" action="purchase/submitItems">

    <table class="orderEntryForm">
 	<tr>
 		<th class="formItem">Name</th>
 		<th class="formItem">Price</th>
 		<th class="formItem">Quantity</th>
 	</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td class="formItem"><form:hidden path="items[${loop.index}].name" value="${item.name}"/><c:out value="${item.name }"/></td>
			<td class="formItem">$<form:hidden path="items[${loop.index}].price" value="${item.price}"/><c:out value ="${item.price}"/></td>
			<td class="formItem"><form:input path="items[${loop.index}].quantity" /></td>
		</tr>
	</c:forEach>
	<tr>
		<td class="submitOrder" colspan="2"><input class="submitButton" type="submit" value="Purchase"></td>
	</tr>
    </table>

</form:form>
<jsp:include page="Footer.jsp"/>

</body>
</html>