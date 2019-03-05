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

	<%
		Integer id = (Integer) session.getAttribute("ID");
	%>


	<form action="UserSelectServlet" method="post">
		<div>
		<table>
			<tr>
				<td colspan="3" align="center"><h3>VIEW EMPLOYEE</h3></td>
			</tr>
			<tr>
				<td align="center"><label class="col-form-label-lg">ID</label></td>
				<td align="center">:</td>
				<td align="center"><input type="number" name="id"
					value="<%=id%>" readonly="readonly" class="form-control"></td>
			</tr>
			<tr>
					<td colspan="3" align="center"><label style="color: red">${ERROR_MSG}</label></td>
				</tr>
			<tr>
				<td colspan="3" align="center"><br><input type="submit"
					value="SUBMIT" class="btn btn-success"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><br><a href="UserHome.jsp"><button
							type="button" class="btn btn-success">HOME</button></a></td>
			</tr>

		</table>
</div>

	</form>
</body>

</html>


