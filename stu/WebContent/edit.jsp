<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student Page</title>
</head>
<body>

	<h3 align="center">This Page is for editing student in MySQL
		Database</h3>

	<form action="UpdateServlet" method="post">
		<table border="1" width="600" align="center">
			<tr>
				<td>ID</td>
				<td><input type="hidden" name="sid" value="${student.sid }"></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${student.name }"></td>
			</tr>
			<tr>

				<td>Gender</td>
				<td><input type="radio" name="gender" value="Male"
					<c:if test="${student.gender == 'Male' }">checked</c:if>>Male
					<input type="radio" name="gender" value="Female"
					<c:if test="${student.gender == 'Female' }">checked</c:if>>Female
				</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" value="${student.phone }"></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="birth" value="${student.birth }"></td>
			</tr>
			<tr>
				<td>Hobby</td>
				<td><input type="checkbox" name="hobby" value="Basketball"
					<c:if test="${fn:contains(student.hobby, 'Basketball') }">checked</c:if>>Basketball
					<input type="checkbox" name="hobby" value="BodyBuilding"
					<c:if test="${fn:contains(student.hobby, 'BodyBuilding') }">checked</c:if>>BodyBuilding
					<input type="checkbox" name="hobby" value="Dota"
					<c:if test="${fn:contains(student.hobby, 'Dota') }">checked</c:if>>Dota
					<input type="checkbox" name="hobby" value="NBA"
					<c:if test="${fn:contains(student.hobby, 'NBA') }">checked</c:if>>NBA
				</td>
			</tr>
			<tr>
				<td>Information</td>
				<td><textarea name="info" cols="20" rows="3">${student.info }</textarea>></td>
			</tr>
			<tr>

				<td colspan="2" align="right"><input type="submit"
					value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>