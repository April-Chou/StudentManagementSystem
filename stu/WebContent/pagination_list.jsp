<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination Display</title>

<script type="text/javascript">
	function doDelete(sid) {
		var flag = confirm("Do you want to delete the selected row?");
		if(flag){
			/* 在当前标签页上打开超链接 */
			window.location.href="DeleteServlet?sid=" + sid;
		}
	}

</script>
</head>
<body>
	<a href="index.jsp"><h3 align="center">Welcome to the Student Pagination Display</h3></a>

	<table align="center" border="1" width="400" height="200">
		<!-- 建表，展示数据 -->
		<!-- 下面行为添加数据行 -->


		<tr>
			<td colspan="8">
			<!-- 注意表单提交的起始和结束位置，如果不在同一个td或者tr范围内会报错 -->
				<form action="SearchStudentServlet" method="post">
					Search by Name: <input type="text" name="sname">

					<!-- 选项之间添加空格 -->
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp;
					<!-- 按性别查询的下拉框 -->
					Search by Gender: <select name="sgender">
						<!-- 这个select the gender的value不能写东西 -->
						<option value="">Select the gender</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>

					<!-- 添加空格调整表间距 -->
					&nbsp;
					<!-- 查询按钮 -->
					<input type="submit" value="search">
					
				</form> 
				
				<!-- 选项之间添加空格 --> 
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				 <!-- 添加学生按钮，跳转至add.jsp -->
				<a href="add.jsp">Add Student</a>
			</td>

		</tr>


		<tr>

			<td>ID</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Telephone</td>
			<td>Date of Birth</td>
			<td>Hobby</td>
			<td>Information</td>
			<td>Action</td>

		</tr>

		<!-- 循环每行，用jstl和EL表达式拿到存储在session中的值，展示在表中 -->
		<!-- 这行外面套c：each，因为循环这个行么。确实是这个理儿 -->
		<c:forEach items="${sessionScope.pageBean.list }" var="stu">
			<tr>

				<td>${stu.sid }</td>
				<td>${stu.name }</td>
				<td>${stu.gender }</td>
				<td>${stu.phone }</td>
				<td>${stu.birth }</td>
				<td>${stu.hobby }</td>
				<td>${stu.info }</td>
				<td><a href="EditServlet?sid=${stu.sid }">Update</a> <a href=""
					onclick="doDelete(${stu.sid})">Delete</a></td>

			</tr>


		</c:forEach>
		
		<tr>
			<td colspan="8">
				Current: ${sessionScope.pageBean.currentPage } /
				${sessionScope.pageBean.totalPage } &nbsp; &nbsp;
				${sessionScope.pageBean.pageLimit } items/Per Page &nbsp; 
				total records: ${sessionScope.pageBean.totalNumber }</td>
		</tr>
		<tr>
			<td colspan="8"><a href="StudentListPageServlet?currentPage=1">First</a> &nbsp;&nbsp;
			<a href="StudentListPageServlet?currentPage=${sessionScope.pageBean.currentPage-1 }">Back</a>&nbsp;&nbsp;
			
			<!-- for循环遍历页数 -->
			<c:forEach begin="1" end="${sessionScope.pageBean.totalPage }" var="i">
			<!-- 判定哪一页 -->
			<c:if test="${sessionScope.pageBean.currentPage == i}">${i }</c:if>
			<c:if test="${sessionScope.pageBean.currentPage != i }"><a href="StudentListPageServlet?currentPage=${i }">${i }</a></c:if>
			
			</c:forEach>
			
			&nbsp; &nbsp; <a href="StudentListPageServlet?currentPage=${sessionScope.pageBean.currentPage+1 }">Next</a>&nbsp;&nbsp;
			&nbsp; &nbsp;<a href="StudentListPageServlet?currentPage=${sessionScope.pageBean.totalPage }">Last</a>
			</td>
		</tr>

	</table>

</body>
</html>