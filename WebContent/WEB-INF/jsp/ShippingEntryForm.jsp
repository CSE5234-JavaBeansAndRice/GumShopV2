<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Shipment Entry Form</title>
</head>
<body>
<form:form modelAttribute="shipping" method="post" action="submitShipping">
 <p>
  Enter your name:
  <input type="text" name="name" id = "name" />
  <br />
  </p>
  
   <p>
  Enter address line 1 :
  <input type="text" name="addressLine1" id = "addressLine1" />
  <br />
  </p>
  
     <p>
  Enter address line 2:
  <input type="text" name="addressLine2" id="addressLine2"/>
  <br />
  </p>
  
  <p>
  Enter city:
  <input type="text" name="city" id="city" />
  <br />
  </p>
  
  <p>
  Enter state:
  <input type="text" name="state" id="state" />
  <br />
  </p>
  
  <p>
  Enter zip:
  <input type="text" name="zip" id="zip" />
  <br />
  </p>
  
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  
    
   <input style = "width: 300px" class = "submitButton" type="submit" value="Continue to view and confirm order">
</form:form>

</body>
</html>