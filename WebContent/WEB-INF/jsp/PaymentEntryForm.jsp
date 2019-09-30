<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Entry Form</title>
</head>
<body>
<form:form modelAttribute="payment" method="post" action="submitPayment">
 <p>
  Enter your credit card #:
  <input type="text" name="ccNum" id = "ccNum" />
  <br />
  </p>
  
   <p>
  Enter its expiration date:
  <input type="text" name="expiration" id = "expiration" />
  <br />
  </p>
  
     <p>
  Enter its CVV:
  <input type="text" name="cvv" id="cvv"/>
  <br />
  </p>
  
  <p>
  Enter cardholder's name:
  <input type="text" name="cardHolder" id="cardHolder" />
  <br />
  </p>
    
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    
   <input type="submit" value="Continue to shipping information">
</form:form>

</body>
</html>