<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Spring Company MVC</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Employee Details</h2>
		<div>
<a href="${pageContext.servletContext.contextPath}/spring/add"> <input type="button" value="ADD" class="btn btn-info"  > </a>
</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>EmpId</th>
					<th>Name</th>
					<th>Salary</th>
					<th>Email</th>
					<th>doj</th>
					<th>pan</th>
					<th>Mobile</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${employees}" var="emp">
				<tr>
					<td>${emp.empId}</td>
					<td>${emp.name}</td>
					<td>${emp.salary}</td>
					<td>${emp.email}</td>
					<td>${emp.doj}</td>
					<td>${emp.panCard}</td>
					<td>${emp.moblie}</td>
					<td><a href="${pageContext.servletContext.contextPath}/spring/edit/${emp.empId}"> <input type="button" value="EDIT" class="btn btn-primary"  > </a>  </td>
					<td><a href="${pageContext.servletContext.contextPath}/spring/delete?empId=${emp.empId}"> <input type="button" value="DELETE" class="btn btn-danger"  > </a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>


