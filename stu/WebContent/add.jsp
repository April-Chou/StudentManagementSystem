<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student Page</title>
</head>
<body>

	<h3 align="center">This Page is for adding student in MySQL
		Database</h3>

	<form action="AddServlet" method="post">
		<table border="1" width="600" align="center">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="Female">Female</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="birth"></td>
			</tr>
			<tr>
				<td>Hobby</td>
				<td><input type="checkbox" name="hobby" value="Basketball">Basketball
					<input type="checkbox" name="hobby" value="BodyBuilding">BodyBuilding
					<input type="checkbox" name="hobby" value="Dota">Dota <input
					type="checkbox" name="hobby" value="NBA">NBA</td>
			</tr>
			<tr>
				<td>Information</td>
				<td><textarea name="info" cols="20" rows="3"></textarea>></td>
			</tr>
			<tr>

				<td colspan="2" align="right"><input type="submit"
					value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>