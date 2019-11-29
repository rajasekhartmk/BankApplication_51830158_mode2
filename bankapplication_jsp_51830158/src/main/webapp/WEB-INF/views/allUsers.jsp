<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
<center>
<h1>ALL USERS</h1>
	<table border="2" >
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th>
				<th>address</th>
				<th>status</th>
				<sec:authorize access="hasAnyRole('ADMIN')">
				<th>delete</th>
				<th>update</th>
				</sec:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
					<td>${user.address}</td>
					<td>${user.active }</td>
					<sec:authorize access="hasAnyRole('ADMIN')">
						<td><a href="delete?id=${user.id}">delete</a></td>
						<td><a href="updateUser?id=${user.id}">update</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<br/>
	<a href="addUser">Add New User</a><br/>
	<a href="/bankapp/home">HOME</a>
</center>
</body>
</html>