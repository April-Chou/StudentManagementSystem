<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<h2 align="center">Welcome to the Index Page :)</h2>
	<h3 align="center">
		<a href="StudentListServlet">Check the Student</a>
	</h3>

	<h3 align="center">
		<!-- 带参数过来默认设置currentPage为1 -->
		<a href="StudentListPageServlet?currentPage=1">Check the Student by Page</a>
	</h3>

</body>
</html>