<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All leads</title>
</head>
<body>
	<h2>Delete Leads</h2>
		<table>
			<tr>
				<th>firstName</th>
				<th>secondName</th>
				<th>course</th>
				<th>fee</th>
				<th>Action</th>
			</tr>
			<c:forEach var="leads" items="${leads}">
				<tr>
					<td>${leads.firstname}</td>
					<td>${leads.secondname}</td>
					<td>${leads.course}</td>
					<td>${leads.fee}</td>
					<td><a href="delete?id=${leads.id}">delete</a>
					<a href="update?id=${leads.id}">update</a>
					</td>
				</tr>

			</c:forEach>

	</table>

</body>
</html>