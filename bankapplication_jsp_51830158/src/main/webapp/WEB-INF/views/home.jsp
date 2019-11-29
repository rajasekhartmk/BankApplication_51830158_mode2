<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
<center>
	<header role="banner">
	<h1>RAJ banking application</h1>
	</header>

	<nav>
	<ul>

		<sec:authorize access="hasAnyRole('ADMIN')">
			<h2><a href="usermgt/">user mgt</a><br/></h2>
		</sec:authorize>

		<sec:authorize access="hasAnyRole('ADMIN')">
			<h2><a href="customermgt/">customer mgt</a><br/></h2>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ADMIN','MGR')">
			<h2><a href="accountmgt/"> account mgt</a><br/></h2>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ADMIN','MGR','CLERK')">
			<h2><a href="transactionmgt/"> transaction mgt</a><br/></h2>
		</sec:authorize>
		<h2><a href="logout">logout</a></h2>
	</ul>
	</nav>

	<article> <section>
	<p>RAJ bank gives power to your dream</p>
	</section> </article>
	
	<footer>
	<p>
		Created by <a href="https://scholar.google.co.in/citations?user=-cuGrOMAAAAJ&hl=en">RAJ</a>
	</p>
	</footer>
</center>
</body>
</html>