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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
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

<script>
	$(function() {
		$('.date-picker')
				.datepicker(
						{
							changeMonth : true,
							changeYear : true,
							showButtonPanel : true,
							dateFormat : 'MM yy',
							onClose : function(dateText, inst) {
								var month = $(
										"#ui-datepicker-div .ui-datepicker-month :selected")
										.val();
								var year = $(
										"#ui-datepicker-div .ui-datepicker-year :selected")
										.val();
								$(this).datepicker('setDate',
										new Date(year, month, 1));
							}
						});
	});
</script>

</head>
<body>

	<jsp:include page="../jsp/common/expense_header.jsp"></jsp:include>

	<div class="container">
		<div class="row">

			<spring:url value="/expense/create" var="formUrl" />
			<form:form modelAttribute="expense" action="${formUrl}" method="post"
				cssClass="col-md-8 col-md-offset-2">

				<div class="form-group">
					<label for="expense-amount">Date</label>
					<form:input id="expense-date" type="text" path="date"
						cssClass="date-picker" />
				</div>

				<div class="form-group">
					<label for="expense-amount">Amount</label>
					<form:input id="expense-amount" cssClass="form-control"
						path="amount" />
					<form:errors path="amount" />
				</div>
				<div class="form-group">
					<label for="user">Title</label>
					<form:input id="title" cssClass="form-control" path="title" />
					<form:errors path="title" />
				</div>

				<div class="form-group">
					<label for="expense-type">Category</label> <select name="type">
						<c:forEach var="type" items="${types}">
							<option value="${type.typeId}" label="${type.typeName}" />
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="expense-subtype">Sub Category</label> <select
						name="subtype">
						<c:forEach var="subtype" items="${expense.type.subTypes}">
							<option value="${expense.type.subtype.subtypeName}"
								label="${expense.type.subtype.subtypeName}" />
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="expense-payee">Payment Type</label> <select
						name="payee">
						<c:forEach var="payee" items="${payees}">
							<option value="${payee.payeeId}" label="${payee.payeeName}" />
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="expense-description">Description</label>
					<form:textarea path="description" cssClass="form-control" rows="3" />
					<form:errors path="description" />
				</div>

				<button type="submit" class="btn btn-default">Submit</button>

			</form:form>

		</div>
	</div>
</body>
</html>