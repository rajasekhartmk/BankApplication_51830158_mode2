<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Account</title>
</head>
<style type="text/css">
	.errors{
		color:red;
		font-family: Calibri;
		font-style: italic;
	}
</style>
</head>
<body>
<center>
<h1>ADD ACCOUNT</h1>
	<form:form action="addAccount" method="POST" modelAttribute="acc">
		<%-- <form:hidden path="id"/> --%>
		Enter balance: <form:input path="balance"/><form:errors path="balance" class="errors"/><br/><br/>
		Enter status: <form:radiobuttons path="blocked" items="${blocked }"/><form:errors path="blocked" class="errors"/><br/><br/>
		Enter name: <form:input path="name"/><form:errors path="name" class="errors"/><br/><br/>
		Enter email: <form:input path="email"/><form:errors path="email" class="errors"/><br/><br/>
		Enter phone: <form:input path="phone"/><form:errors path="phone" class="errors"/><br/><br/>
		Enter address: <form:input path="address"/><form:errors path="address" class="errors"/><br/><br/>
		Enter city: <form:input path="city"/><form:errors path="city" class="errors"/><br/><br/>
		Enter country: <form:input path="country"/><form:errors path="country" class="errors"/><br/><br/>
		<center>
		<input type="submit"/>
		</center>
	</form:form>
</center>
</body>
</html>