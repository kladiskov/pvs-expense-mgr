<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="../../resources/css/sidebar.css">
<link rel="stylesheet" href="../../resources/css/home.css">
<div id="mySidenav" class="sidenav">
	<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	<div class="row" id="firstdiv">
		<spring:url value="/expense/view/filterByDate" var="formUrl" />
		<form:form modelAttribute="expense" action="${formUrl}" method="post"
			cssClass="col-md-8 col-md-offset-2">
			<div class="form-group">
				<label for="filter-by-date">Filter by Date</label> <label
					for="startDate">Start Date:</label> <input type="text"
					name="startDate" id="start-date" class="date-picker"> <label
					for="endDate">End Date:</label> <input type="text" name="endDate"
					id="end-date" class="date-picker" />
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
	<div class="row">
		<spring:url value="/expense/view/filterByType" var="formUrl" />
		<form:form modelAttribute="type" action="${formUrl}" method="post"
			cssClass="col-md-8 col-md-offset-2">
			<div class="form-group">
				<label for="filter-type">Filter by Category</label> <select
					name="type">
					<c:forEach var="type" items="${types}">
						<option value="${type.typeId}" label="${type.typeName}" />
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
	<div class="row">
		<spring:url value="/expense/view/filterByPayee" var="formUrl" />
		<form:form modelAttribute="payee" action="${formUrl}" method="post"
			cssClass="col-md-8 col-md-offset-2">
			<div class="form-group">
				<label for="filter-payee">Filter by Payment Type</label> <select
					name="payee">
					<c:forEach var="payee" items="${payees}">
						<option value="${payee.payeeId}" label="${payee.payeeName}" />
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
	<div class="row">
		<spring:url value="/expense/view/keyWordSearch" var="formUrl" />
		<form:form modelAttribute="expense" action="${formUrl}" method="post"
			cssClass="col-md-8 col-md-offset-2">
			<div class="form-group">
				<label for="filter-by-keyword">Search for expenses</label> <input
					type="text" name="title" id="expense-title">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
</div>
<span style="font-size: 22px; cursor: pointer" onclick="openNav()">&#9776;
	Filter</span>

<script>
	function openNav() {
		document.getElementById("mySidenav").style.width = "250px";
	}

	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
	}
</script>