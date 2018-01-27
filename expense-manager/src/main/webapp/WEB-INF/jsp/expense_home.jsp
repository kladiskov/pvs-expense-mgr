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
		<div class="row">
			<h1>Welcome to Expense Manager!</h1>
			<h3>A personal finance tracker for all you expenses</h3>
			<p>Create, track, view, filter all you expenses and organize
				using the inventory management system.</p>
			<p>A single stop solution for all your expenses.</p>
		</div>
		<c:if test="${page != null}">
			<div align="center">
				<table class="table table-hover" border="5" align="left">
					<caption>
						<h2>Your records at a glance</h2>
					</caption>
					<tr>
						<th><a href="<spring:url value="/expense?page=${page.number}&sort=date"/>">Date</a></th>
						<th><a href="<spring:url value="/expense?page=${page.number}&sort=title"/>">Title</a></th>
						<th><a href="<spring:url value="/expense?page=${page.number}&sort=payee.payeeName"/>">Payment Type</a></th>
						<th><a href="<spring:url value="/expense?page=${page.number}&sort=type.typeName"/>">Category</a></th>
						<th><a href="<spring:url value="/expense?page=${page.number}&sort=subType"/>">Sub Category</a></th>
						<th><a href="<spring:url value="/expense?page=${page.number}&sort=amount"/>">Amount</a></th>
					</tr>
					<c:forEach items="${page.content}" var="record">
						<tr>
							<td><c:out value="${record.date}" /></td>
							<td><c:out value="${record.title}" /></td>
							<td><c:out value="${record.payee.payeeName}" /></td>
							<td><c:out value="${record.type.typeName}" /></td>
							<td><c:out value="${record.subType}" /></td>
							<td><c:out value="${record.amount}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<td><a href="<spring:url 
				value="/expense?page=${page.number - 1}&sort=${sort}"/>">[Previous]</a></td>
			<td><c:out value="[ ${page.number} ]" /></td>
			<td><a href="<spring:url 
				value="/expense?page=${page.number + 1}&sort=${sort}"/>">[Next]</a></td>
		</c:if>
	</div>

</body>
</html>