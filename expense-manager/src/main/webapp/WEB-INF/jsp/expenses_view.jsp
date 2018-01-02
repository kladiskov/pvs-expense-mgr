<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/home.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script>
	$(function() {
		$("#start-date").datepicker();
		$("#start-date").datepicker("option", "dateFormat", 'yy/mm/dd');
	});
	$(function() {
		$("#end-date").datepicker();
		$("#end-date").datepicker("option", "dateFormat", 'yy/mm/dd');
	});
	$(document).ready(function() {
		$('#expense_view').DataTable({
			"order" : [ [ 1, "desc" ] ],
			 "pageLength": [5],
			 "lengthMenu": [5, 10, 25, 50]
		}

		);
	});
</script>
</head>
<body>
	<jsp:include page="../jsp/common/expense_header.jsp"></jsp:include>
	<div class="container">
		<div class="sidebar">
			<jsp:include page="../jsp/common/sidebar.jsp"></jsp:include>
		</div>
		<div class="main">
			<h3>Expenses at a glance</h3>
			<table class="table table-striped table-bordered" id="expense_view">
				<thead>
					<tr>
						<th>Title</th>
						<th>Date</th>
						<th>Amount</th>
						<th>Category</th>
						<th>Payment Type</th>
						<th>Operations</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${expenses}" var="expense">
						<tr>
							<td><a
								href="<spring:url 
							value="/expense/${expense.expenseId}"/>">${expense.title}</a></td>
							<td>${expense.date}</td>
							<td>${expense.amount}</td>
							<td>${expense.type.typeName}</td>
							<td>${expense.payee.payeeName}</td>
							<td><a
								href="<spring:url 
							value="/expense/edit=${expense.expenseId}"/>">update</a>
								<a
								href="<spring:url 
							value="/expense/delete=${expense.expenseId}"/>">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>