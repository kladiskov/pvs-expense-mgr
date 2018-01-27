<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script src="<spring:url value="/resources/js/global-logout.js"/>"></script>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<a class="navbar-brand">EXPENSE MANAGER</a>

		<ul class="nav navbar-nav">
			<li><a href="/home/">Home</a></li>

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false">Expense<span
					class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="<spring:url value="/expense/create"/>">Create</a></li>
					<li><a href="<spring:url value="/expense/view"/>">Manage</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav  navbar-right">
			<sec:authorize access="authenticated" var="authenticated" />
			<c:choose>
				<c:when test="${authenticated}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><sec:authentication
								property="name" /><span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<spring:url value="/expense/view"/>">Profile</a></li>
							<li><a id="logout" href="#">Logout</a>
								<form id="logout-form" action="<c:url value="/logout"/>"
									method="post">
									<sec:csrfInput />
								</form></li>
						</ul></li>
				</c:when>
				<c:otherwise>
					<li><a href="<spring:url value="/login"/>">Sign In</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>
