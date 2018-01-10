<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<h1>Create a new Account</h1>
		</div>
		<spring:url value="/login/newuser" var="signupUrl" />
		<form id="signup-form" modelAttribute="user" action="${signupUrl}" method="POST">
			<div class="form-group">
				<label for="username">Username</label>
				<form:input name="userName" class="form-control"
					path="user.credential.userName" />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<form:input type="password" name="password"
					path="user.credential.password" class="form-control" />
			</div>
			<div class="form-group">
				<label for="firstName">First Name</label>
				<form:input name="firstName" path="user.firstName"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="lastName">Last Name</label>
				<form:input name="lastName" path="user.lastName"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input name="email" path="user.emailId" class="form-control" />
			</div>
			<div class="form-group">
				<label for="phoneNumber">Phone Number</label>
				<form:input name="phoneNumber" path="user.phoneNumber" class="form-control" />
			</div>
			<sec:csrfInput />

			<button type="submit" id="btn-save" class="btn btn-primary">Signup</button>
		</form>
	</div>
</body>
</html>