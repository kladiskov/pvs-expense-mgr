'<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">e x p e n s e m a n a g e r</a>

			<ul class="nav navbar-nav">
				<li><a href="/expense/">Home</a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Expense<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<spring:url value="/expense/create"/>">Create</a></li>
						<li><a href="<spring:url value="/expense/view"/>">View</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
