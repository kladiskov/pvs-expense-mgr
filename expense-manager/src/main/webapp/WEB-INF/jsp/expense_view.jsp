<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../jsp/common/expense_header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 center" >
			<div class="flt-center">
				 ${expense.title} 
			</div>
		</div>
		</div>
		<div class="row">

			<div class="form-group">
				<label for="expense-date">Date</label> <span>${expense.date}</span>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="expense-amount">Amount</label> <span>${expense.amount}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<div class="row">
					<div class="col-lg-6">
						<label for="expense-type">Category</label> 
					</div>
					<div class="col-lg-6">
					<span>${expense.type.typeName}</span>
					</div>
				</div>
			</div>

			<div class="col-lg-6">
				<div class="form-group">
					<label for="expense-type">Sub Category</label> <span>${expense.subType}</span>
				</div>
			</div>
		</div>
		<div class="row">

			<div class="form-group">
				<label for="expense-payee">Payment Type</label> <span>${expense.payee.payeeName}</span>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="expense-dscr">Description</label> <span>${expense.description}</span>
			</div>
		</div>
	</div>

</body>
</html>