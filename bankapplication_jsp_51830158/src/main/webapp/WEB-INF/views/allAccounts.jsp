<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
</head>
<body>
<center>
<h1>ALL ACCOUNTS</h1>
	<table border="2" >
		<thead>
			<tr>
				<th>accountNumber</th>
				<th>balance</th>
				<th>customer</th>
				<th>blocked</th>
				<sec:authorize access="hasAnyRole('ADMIN','MGR')">
				<th>delete</th>
				<th>update</th>
				</sec:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.accountNumber}</td>
					<td>${account.balance}</td>
					<td>${account.customer}</td>
					<td>${account.blocked}</td>
					<sec:authorize access="hasAnyRole('ADMIN','MGR')">
						<td><a href="delete?id=${account.accountNumber}">delete</a></td>
						<td><a href="updateAccount?id=${account.accountNumber}">update</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<br/>
	<a href="addAccount">ADD NEW ACCOUNT</a><br/><br/>
	<a href="deposit">DEPOSIT</a><br/><br/>
	<a href="withdrawl">WITHDRAWL</a><br/><br/>
	<a href="transfer">TRANSFER</a><br/><br/>
	<a href="/bankapp/home">HOME</a>
</center>
</body>
</html>