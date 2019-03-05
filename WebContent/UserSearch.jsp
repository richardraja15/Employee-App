<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<th>name</th>
				<th>Email Id</th>
				<th>Phone Number</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${USER.employee.id}</td>
				<td>${USER.employee.name}</td>
				<td>${USER.emailId}</td>
				<td>${USER.phoneNumber}</td>
				<td>${USER.address}</td>
			</tr>
		</tbody>

	</table>
	<h3 align="center">
		<a href="UserHome.jsp" style="color: purple;"><button
				type="button" class="btn btn-success">Home</button></a>
	</h3>
</body>
</body>
</html>