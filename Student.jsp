<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
<h1>Student page</h1>
Name      :<input type="text" name ="sname"><br><br>
Subject   :<input type="text" name="sub"><br><br>
Gender    :<input type="radio" name="gender" value="male"/>Male&nbsp;&nbsp;&nbsp;
           <input type="radio" name="gender" value="female"/>Female<br><br><br>
Email     :<input type="email" name ="semail"/><br><br>
Education :<input type="text" name="education"><br><br>
<input type="submit" value="Insert"/>
</form>
</body>
</html>