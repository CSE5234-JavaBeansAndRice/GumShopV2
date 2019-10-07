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
	<div class="about-title">Our Team Members</div>
	<div class="member-wrapper">
		<div class="member-name">Fan Lyu</div>
		<img src="https://avatars3.githubusercontent.com/u/46477481?s=400&v=4" width="100" height="100" alt="Image of Fan Lyu"/>
		<div class="member-title">Title: Web Developer</div>
		<div class="member-edu">Education: The Ohio State University</div>
		<div class="member-exp">Experience: Come! Let me talk to you</div>
	</div>
	<div class="member-wrapper">
		<div class="member-name">Guoyao Cheng</div>
		<img src="https://avatars2.githubusercontent.com/u/37690820?s=400&v=4" width="100" height="100" alt="Image of Guoyao Cheng"/>
		<div class="member-title">Title: Web Developer</div>
		<div class="member-edu">Education: The Ohio State University</div>
		<div class="member-exp">Experience: Too much to show</div>
	</div>
	<div class="member-wrapper">
		<div class="member-name">Charlie Yu</div>
		<img src="https://avatars0.githubusercontent.com/u/25891327?s=460&v=4" width="100" height="100" alt="Image of Charlie Yu"/>
		<div class="member-title">Title: Web Developer</div>
		<div class="member-edu">Education: The Ohio State University</div>
		<div class="member-exp">Experience: :)</div>
	</div>
	<div class="member-wrapper">
		<div class="member-name">Simon Turner</div>
		<img src="https://avatars0.githubusercontent.com/u/22628418?s=460&v=4" width="100" height="100" alt="Image of Charlie Yu"/>
		<div class="member-title">Title: Software Engineer</div>
		<div class="member-edu">Education: The Ohio State University</div>
		<div class="member-exp">Experience: So much. Like Way toooo much</div>
	</div>
</div>

<jsp:include page="Footer.jsp"/>
</body>
</html>