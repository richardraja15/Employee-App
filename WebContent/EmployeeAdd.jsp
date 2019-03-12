<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
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
	margin-left: 40%
}
</style>

</head>

<body>
	<form action="EmployeeAddServlet" method="post">
		<table>
			<tr>
				<td colspan="3" align="center"><h3>EMPLOYEE ENROLL</h3>
					<br>
				<br></td>
			</tr>
			
			<tr>
				<td align="left"><label class="col-form-label-lg">NAME</label></td>
				<td align="center">:</td>
				<td align="right"><input type="text" name="name" required
					pattern="[A-Za-z]{1,32}" class="form-control" size="30" maxlength="30" autocomplete="off"></td>
			</tr>


			<tr>

				<td align="left"><label class="col-form-label-lg">DEPARTMENT</label></td>
				<td align="center">:</td>
				<td align="center"><select name="departmentId"
					class="browser-default custom-select">
						<c:forEach var="department" items="${DEPARTMENT}">
							<option value="${department.id}">${department.name}</option>
						</c:forEach>
				</select></td>

			</tr>

			<tr>
				<td align="left"><label class="col-form-label-lg">POSITION</label></td>
				<td align="center">:</td>
				<td align="center"><select name="positionId"
					class="browser-default custom-select">
						<c:forEach var="position" items="${POSITION}">
							<option value="${position.id}">${position.name}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td align="left"><label class="col-form-label-lg">JOINING
						DATE</label></td>
				<td align="center">:</td>
				<td align="center"><input type="date" name="joiningDate"
					class="form-control"></td>
			</tr>

			<tr>
				<td colspan="3" align="center" style="color: red;">${ERROR_MSG}</td>
			</tr>

			<tr>
				<td colspan="3" align="center"><br>
				<input type="submit" value="INSERT" class="btn btn-success"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><br>
				<a href="AdminHome.html" style="color: purple;"><button
							type="button" class="btn btn-success">HOME</button></a></td>
			</tr>

		</table>
	</form>
</body>
</html>