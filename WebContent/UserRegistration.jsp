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
	<form method="post" action="UserRegistrationController">



		<table>
			<tr>
				<td colspan="3" align="center"><h3>REGISTRATION</h3></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">EMPLOYEE
						ID</label></td>
				<td align="center">:</td>
				<td align="right"><input type="number" name="id"
					required="required" min="0" max="10" class="form-control"></td>
			</tr>

			<tr>
				<td align="left"><label class="col-form-label-lg">GENDER</label></td>
				<td align="center">:</td>
				<td align="left"><input type="radio" name="gender" value="male" required="required">
					Male<br> <input type="radio" name="gender" value="female">
					Female<br></td>
			</tr>
			
			
			
			<tr>
				<td align="left"><label class="col-form-label-lg">EMAIL
						ID</label></td>
				<td align="center">:</td>
				<td align="right"><input type="email" name="emailId"
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
					class="form-control" required="required"></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">PHONE
						NUMBER</label></td>
				<td align="center">:</td>
				<td align="right"><input type="tel" name="phoneNumber"
					maxlength="10" pattern="[6-9]{1}[0-9]{9}" required="required" class="form-control"></td>
			</tr>

			<tr>
				<td align="left"><label class="col-form-label-lg">ADDRESS</label></td>
				<td align="center">:</td>
				<td align="right"><textarea name="address" rows="3" cols="22"
						class="form-control" required="required"></textarea></td>
			</tr>

			<tr>
				<td align="left"><label class="col-form-label-lg">USERNAME</label></td>
				<td align="center">:</td>
				<td align="right"><input type="text" name="userName"
					required="required" class="form-control"></td>
			</tr>
			<tr>
				<td align="left"><label class="col-form-label-lg">PASSWORD</label></td>
				<td align="center">:</td>
				<td align="right"><input type="password" name="password"
					required="required" pattern="(?=.*\d)(?=.*[a-z]).{8,}"
					class="form-control"></td>
			</tr>

			<tr>
				<td align="left"><label class="col-form-label-lg">CONFIRM
						PASSWORD</label></td>
				<td align="center">:</td>
				<td align="right"><input type="password" name="confirmPassword"
					required="required" pattern="(?=.*\d)(?=.*[a-z]).{8,}"
					class="form-control"></td>
			</tr>


			<tr>
				<td colspan="3" align="center"><label style="color: red">${MESSAGE}</label></td>
			</tr>

			<tr>
				<td align="center"><input type="submit" name="but"
					value="SUBMIT" class="btn btn-success"></td>
				<td colspan="3"><a href="UserLogin.jsp" style="color: purple;"><button
							type="button" class="btn btn-success">USER LOGIN</button> </a></td>
			</tr>
		</table>
	</form>

</body>
</html>