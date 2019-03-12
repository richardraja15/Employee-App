<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">

<style>
body {
	background-image: url('blue.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	margin-top: 5%;
	margin-left: 10%
}

.table {
	width: 90%;
}
</style>

</head>
<body>
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
				<th>Employee id</th>
				<th>name</th>
				<th>Department Name</th>
				<th>Position Name</th>
				<th>Salary</th>
				<th>joining Date</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${EMPLOYEE.id}</td>
				<td>${EMPLOYEE.empId}</td>
				<td>${EMPLOYEE.name}</td>
				<td>${EMPLOYEE.department.name}</td>
				<td>${EMPLOYEE.position.name}</td>
				<td>${EMPLOYEE.position.salary}</td>
				<td>${EMPLOYEE.joiningDate}</td>
			</tr>
		</tbody>

	</table>
	<h3 align="center">
		<a href="AdminHome.html" style="color: purple;"><button
				type="button" class="btn btn-success">Home</button></a>
	</h3>
	
</body>
</html>