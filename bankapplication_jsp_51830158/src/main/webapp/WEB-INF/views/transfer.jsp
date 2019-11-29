<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>TRANSFER</h1><br/>
<form:form action="transfer" method="POST" modelAttribute="transfer">
		<%-- <form:hidden path="id"/> --%>
		Enter From AccountNumber: <form:input path="fromAcc"/><br/><br/>
		Enter To AccountNumber: <form:input path="toAcc"/><br/><br/>
		Enter Amount: <form:input path="amount"/><br/><br/>
		<center>
		<input type="submit"/>
		</center>
	</form:form>
	</center>
</body>
</html>