<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>

	<h3>Your order has been submitted and will be shipped shortly!</h3>
	<p>Here is your confirmation code: <c:out value="${code}"></c:out></p>
	<a href="/GumShopV2" class="nav-item">Back to Home</a>
</body>
</html>