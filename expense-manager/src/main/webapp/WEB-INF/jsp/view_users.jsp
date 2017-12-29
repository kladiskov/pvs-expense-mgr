<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../jsp/common/header.jsp"></jsp:include>

	<div class="container">

		<h2>List of available Users</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Name</th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><a
							href="<spring:url 
							value="/admin/user/${user.userId}"/>">${user.userName}</a></td>
						<td><a
							href="<spring:url 
							value="/admin/user/edit=${user.userId}"/>">update</a></td>
						<td><a
							href="<spring:url 
							value="/admin/user/delete=${user.userId}"/>">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>