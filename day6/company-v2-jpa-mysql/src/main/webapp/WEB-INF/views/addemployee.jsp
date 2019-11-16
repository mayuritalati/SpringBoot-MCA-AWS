<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<h2>Add Employee Details</h2>
		<div class="jumbotron">
			<form:form  modelAttribute="employee" action="${pageContext.servletContext.contextPath}/spring/save"  method="POST">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>value</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><form:label path="empId"> EmpId</form:label>   </td>
						<td><form:input path="empId"/></td>
					</tr>
					<tr>
						<td><form:label path="name"> Name</form:label></td>
						<td><form:input path="name"/></td>
					</tr>
					<tr>
						<td><form:label path="salary"> Salary</form:label></td>
						<td><form:input path="salary"/></td>
					</tr>
					<tr>
						<td><form:label path="email"> Email</form:label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><form:label path="doj"> DOJ</form:label></td>
						<td><form:input path="doj"/></td>
					</tr>
					<tr>
						<td><form:label path="panCard"> panCard</form:label></td>
						<td><form:input path="panCard"/></td>
					</tr>
					<tr>
						<td><form:label path="moblie"> Mobile</form:label></td>
						<td><form:input path="moblie"/></td>
					</tr>
					<tr>
						<td>  <input  type="submit"  value="ADD Employee" class="btn btn-primary"></td>

					</tr>
					
				</tbody>
		</table>
		</form:form>
		</div>
		<table class="table table-hover table-striped table-bordered">
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
					<td><a href="${pageContext.servletContext.contextPath}/spring/delete?empId=${emp.empId}"> <input type="button" value="DELETE" class="btn btn-danger"  > </a>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>


