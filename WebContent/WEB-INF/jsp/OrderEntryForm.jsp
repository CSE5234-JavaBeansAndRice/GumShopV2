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
<form:form modelAttribute="inventory" method="post" action="/GumShopV2/purchase/submitItems">

    <table class="orderEntryForm">
 	<tr>
 		<th class="formItem">Name</th>
 		<th class="formItem">Price</th>
 		<th class="formItem">Quantity</th>
 	</tr>
	<c:forEach items="${inventory.itemList}" var="item" varStatus="loop">
		<tr>
			<td class="formItem"><form:hidden path="itemList[${loop.index}].name" value="${item.name}"/><c:out value="${item.name}"/></td>
			<td class="formItem">$<form:hidden path="itemList[${loop.index}].unitPrice" value="${item.unitPrice}"/><c:out value ="${item.unitPrice}"/></td>
			<td class="formItem"><form:input path="itemList[${loop.index}].quantity"/></td>
			<form:hidden path="itemList[${loop.index}].id" value="${item.id}"/>
			<form:hidden path="itemList[${loop.index}].itemNumber" value="${item.itemNumber}"/>
			<form:hidden path="itemList[${loop.index}].description" value="${item.description}"/>
			<form:hidden path="itemList[${loop.index}].availableQuantity" value="${item.availableQuantity}"/>
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