'<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">e x p e n s e m a n a g e r</a>
			
			<ul class="nav navbar-nav">
				<li><a href="/admin/">Home</a></li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button"
						aria-expanded="false">Categories<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<spring:url value="/admin/addType"/>">Add</a></li>
            			<li><a href="<spring:url value="/admin/viewTypes"/>">Find</a></li>
					</ul>	
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
          				data-toggle="dropdown" role="button" 
          				aria-expanded="false">Users <span class="caret"></span></a>
          		
          			<ul class="dropdown-menu" role="menu">
            			<li><a href="<spring:url value="/admin/addUser"/>">Add</a></li>
            			<li><a href='<spring:url value="/admin/viewUsers"></spring:url>'>Find</a></li>
          			</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button"
						aria-expanded="false">Payees<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<spring:url value="/admin/addPayee"/>">Add</a></li>
            			<li><a href="<spring:url value="/admin/viewPayees"/>">Find</a></li>
					</ul>	
				</li>
				<li>${currentDate}</li> 
			
			</ul>
		</div>
	</div>
</nav>	