<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: url('blue.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}

div {
	margin-left: 40%;
	margin-top: 10%;
}
</style>

<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">



</head>
<body>
	<form action="EmployeeUpdateController" method="post">
		<div>
			<table>
				<tr>
					<td colspan="3" align="center"><h3>UPDATE EMPLOYEE</h3></td>
				</tr>
				<tr>
					<td align="center"><label class="col-form-label-lg">Employee ID</label></td>
					<td align="center">:</td>
					<td align="center"><input type="number" name="id"
						required="required" min="0" class="form-control"></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><label style="color: red">${ERROR_MSG}</label></td>
				</tr>

				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="SUBMIT" class="btn btn-success"></td>
				<tr>
					<td colspan="3" align="center"><br>
					<a href="AdminHome.html" style="color: purple;"><button
								type="button" class="btn btn-success">HOME</button></a></td>
				</tr>

			</table>

		</div>
	</form>
</body>
</html>

