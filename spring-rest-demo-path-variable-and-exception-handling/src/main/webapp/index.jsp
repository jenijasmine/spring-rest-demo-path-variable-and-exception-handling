<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome</h1>
	<p></p>

	<a href="${pageContext.request.contextPath}/api/students">Get All
		Students</a>
	<p></p>
	<form action="${pageContext.request.contextPath}/api/students"
		method="POST">
		<P>
			First Name: <input type="text" name="firstName" />
		</P>
		<p>
			Last Name: <input type="text" name="lastName" />
		</p>
		<button type="submit">Create Student</button>
	</form>
</body>
</html>