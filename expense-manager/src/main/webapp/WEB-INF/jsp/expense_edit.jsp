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

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#expense-date").datepicker();
		$("#expense-date").datepicker("option", "dateFormat", 'yy/mm/dd');
	});

	function onChangeTypeId(id) {
		$.get("create/" + id.value, function(data) {
			// Assumed subcategory is id of another select
			//  var subcat = $('#subtypeid').html('');
			// alert(data);
			$('#subtypeid').empty();
			if (data.trim() == "") {
				$('#subtypeid').html("<option> Not Available </Option>");
			} else
				$('#subtypeid').html(data);
		});
	};
</script>

</head>
<body>

	<jsp:include page="../jsp/common/expense_header.jsp"></jsp:include>

	<div class="container">
		<div class="row">

			<spring:url value="/expense/update=${expenseId}" var="formUrl" />
			<form:form modelAttribute="expense" action="${formUrl}" method="post"
				cssClass="col-md-8 col-md-offset-2">

				<div class="form-group">
					<label for="expense-date">Date</label>
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
					<label for="expense-type">Category</label> <select name="type"
						id="typeid" onChange="onChangeTypeId(this)">
						<c:forEach var="type" items="${types}">
							<option value="${type.typeId}" label="${type.typeName}" />
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="expense-subtype">Sub Category</label> <select
						name="subType" id="subtypeid">
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