<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<title>About Us</title>
</head>
<body>
<jsp:include page="Header.jsp"/>

<div class="about-wrapper">
	<div class="about-title">Team Members</div>
	<div class="member-wrapper">
		<div class="member-name">Name1</div>
		<img src="" width="100" height="100" alt="Image of Name1"/>
		<div class="member-title">Title: XXX</div>
		<div class="member-edu">Education: XXX</div>
		<div class="member-exp">Experience: XXX</div>
	</div>
	<div class="member-wrapper">
		<div class="member-name">Name2</div>
		<img src="" width="100" height="100" alt="Image of Name2"/>
		<div class="member-title">Title: XXX</div>
		<div class="member-edu">Education: XXX</div>
		<div class="member-exp">Experience: XXX</div>
	</div>
	<div class="member-wrapper">
		<div class="member-name">Guoyao Cheng</div>
		<img src="https://avatars2.githubusercontent.com/u/37690820?s=400&v=4" width="100" height="100" alt="Image of Guoyao Cheng"/>
		<div class="member-title">Title: Web Developer</div>
		<div class="member-edu">Education: The Ohio State University</div>
		<div class="member-exp">Experience: Too much to show</div>
	</div>
	<div class="member-wrapper">
		<div class="member-name">Name4</div>
		<img src="" width="100" height="100" alt="Image of Name4"/>
		<div class="member-title">Title: XXX</div>
		<div class="member-edu">Education: XXX</div>
		<div class="member-exp">Experience: XXX</div>
	</div>
</div>

<jsp:include page="Footer.jsp"/>
</body>
</html>