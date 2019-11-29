<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEPOSIT</title>
</head>
<body>
<center>
<h1>DEPOSIT</h1><br/>
<form:form action="deposit" method="POST" modelAttribute="deposit">
		<%-- <form:hidden path="id"/> --%>
		Enter AccountNumber: <form:input path="accountNumber"/><br/><br/>
		Enter Amount: <form:input path="amount"/><br/><br/><br/>
		<center>
		<input type="submit"/>
		</center>
	</form:form>
	</center>
</body>
</html>