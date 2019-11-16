<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring Web MVC Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<h2>
Spring Web MVC CRUD App
</h2>

<div>
<a href="${pageContext.servletContext.contextPath}/spring/add"> <input type="button" value="ADD" class="btn btn-info"  > </a>
</div>

<table class="table table-hover table-striped table-bordered">
<thead>
<tr>
<th>Accno</th>
<th>Name</th>
<th>Balance</th>
<th>DOC</th>
<th>PAN</th>
<th>EMAIL</th>
<th>MOBILE</th>
<th>EDIT</th>
<th>DELETE</th>
</tr>


</thead>

<tbody>
<c:forEach items="${accounts}"  var="a">
<tr>
<td>${a.accno}</td>
<td>${a.name}</td>
<td>${a.balance}</td>
<td>${a.doc}</td>
<td>${a.pan}</td>
<td>${a.email}</td>
<td>${a.mobile}</td>
<td><a href="${pageContext.servletContext.contextPath}/spring/edit/${a.accno}"> <input type="button" value="EDIT" class="btn btn-primary"  > </a>  </td>
<td><a href="${pageContext.servletContext.contextPath}/spring/delete?accno=${a.accno}"> <input type="button" value="DELETE" class="btn btn-danger"  > </a>  </td>




</tr>
</c:forEach>



</tbody>

</table>





</div>
















</body>
</html>