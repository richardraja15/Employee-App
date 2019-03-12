<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<th>Department name</th>
				<th>Position name</th>
				<th>Salary</th>
				<th>joining Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${EMPLOYEE}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.empId}</td>
					<td>${employee.name}</td>
					<td>${employee.department.name}</td>
					<td>${employee.position.name}</td>
					<td>${employee.position.salary}</td>
					<td>${employee.joiningDate}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

	<label>${ERROR_MSG}</label>

	<h3 align="center">
		<a href="AdminHome.html" style="color: purple;"><button
				type="button" class="btn btn-success">Home</button></a>
	</h3>
</body>
</html>