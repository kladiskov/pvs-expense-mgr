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
	<jsp:include page="../jsp/common/expense_header.jsp"></jsp:include>

	<div class="container">
		<h2>Expenses at a glance</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Title</th>
					<th>Date</th>
					<th>Amount</th>
					<th>Category</th>
					<th>Payment Type</th>
				</tr>
				<c:forEach items="${expenses}" var="expense">
					<tr>
						<td><a
							href="<spring:url 
							value="/expense/${expense.expenseId}"/>">${expense.title}</a></td>
						<td>${expense.date}</td>
						<td>${expense.amount}</td>
						<td>${expense.type.typeName}</td>
						<td>${expense.payee.payeeName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>