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
	margin-left: 40%
}
</style>
</head>
<body>
	<form action="EmployeeUpdateServlet" method="post">

		<table>
			<tr>
				<td colspan="3" align="center"><h3>EMPLOYEE UPDATE</h3></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg"> ID</label></td>
				<td align="center">:</td>
				<td align="center"><input type="number" name="id"
					value="${EMPLOYEE.id}" readonly="readonly" class="form-control"></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">NAME</label></td>
				<td align="center">:</td>
				<td align="center"><input type="text" name="name"
					value="${EMPLOYEE.name}" class="form-control"
					pattern="[A-Za-z].{1,20}"></td>
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
					value="${EMPLOYEE.joiningDate}" class="form-control"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><label style="color: red">${ERROR_MSG}</label></td>
			</tr>

			<tr>
			<tr>
				<td colspan="3" align="center"><br><input type="submit"
					value="Submit" class="btn btn-success"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><br><a href="AdminHome.html"><button
							type="button" class="btn btn-success">HOME</button></a></td>
			</tr>
		</table>
	</form>
</body>

</html>
