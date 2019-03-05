<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	margin-top: 1%;
	margin-left: 40%
}
</style>


</head>
<body>
	<form action="UserUpdateServlet" method="post">

		<table>
			<tr>
				<td colspan="3" align="center"><h3>USER UPDATE</h3></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">EMPLOYEE
						ID</label></td>
				<td align="center">:</td>
				<td align="center"><input type="number" name="id"
					value="${USER.employee.id}" readonly="readonly"
					class="form-control"></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">NAME</label></td>
				<td align="center">:</td>
				<td align="center"><input type="text" name="name"
					value="${USER.employee.name}" readonly="readonly"
					class="form-control"></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">EMAIL
						ID</label></td>
				<td align="center">:</td>
				<td align="center"><input type="email" name="emailId"
					value="${USER.emailId}"
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
					class="form-control"></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">PHONE
						NUMBER</label></td>
				<td align="center">:</td>
				<td align="center"><input type="number" name="phoneNumber"
					value="${USER.phoneNumber}" maxlength="10"
					pattern="[6-9]{1}[0-9]{9}" class="form-control"></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">ADDRESS</label></td>
				<td align="center">:</td>
				<td align="center"><input type="text" name="address"
					value="${USER.address}" class="form-control"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><label style="color: red">${ERROR_MSG}</label></td>
			</tr>

			<tr>
				<td colspan="3" align="center"><br>
				<input type="submit" value="Submit" class="btn btn-success"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><br>
				<a href="UserHome.jsp"><button type="button"
							class="btn btn-success">HOME</button></a></td>
			</tr>
		</table>
	</form>
</body>
</html>

