<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../jsp/common/header.jsp"></jsp:include>

	<div class="container">
		<h2>Expense Manager Admin Dashboard</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Item</th>
				</tr>
				<c:forEach items="${types}" var="type">
					<tr>
						<td><a
							href="<spring:url 
							value="/admin/${type.typeId}"/>">${type.name}</a></td>
						<c:forEach items="${type.subtypes}" var="subtype">
							<tr>
								<td>${subtype.subTypeName}</td>
							</tr>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>