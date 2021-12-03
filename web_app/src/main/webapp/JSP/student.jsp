<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/JSP/JavaScript/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/JSP/JavaScript/main.js"></script>
<title>student</title>
</head>
<body>
	<div>
		<input type="hidden" name="id" value="${student.id }" id="id"/><br>
		<input type="text" name="name" value="${student.name }" id="name"><br>
		<input type="text" name="age" value="${student.age }" id="age"><br>
		<input type="text" name="major" value="${student.major }" id="major"><br>
		<input type="text" name="classRoom" value="${student.classRoom }" id="classRoom"><br>
		<button id="update">修改</button><br>
	</div>
</body>
</html>