<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="hello.do">Hello world</a>
	<br><br>
	
	<a href="springmvc/testRest/1">test Rest Get</a>
	<br><br>
	
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="submit post">
	</form>
	
	<br><br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="delete">
	</form>
	
	<br><br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="PUT">
	</form>
	
	<br><br>
	<a href="springmvc/testRequestParam?username=123">test RequestParam</a>
	
	<br><br>
	<form action="springmvc/testPojo" method="post">
		<input type="text" name="username" >
		<input type="text" name="password" >
		<input type="text" name="email" >
		<input type="text" name="adders.city" >
		<input type="submit" value="PUT">
	</form>
	
	<br><br>
	<a href="springmvc/testModelAndView">test modelAndVIew</a>
	<br><br>
	<a href="springmvc/testMap">test map</a>
	
	<br><br>
	<a href="springmvc/testSessionAttributes">test SessionAttributes</a>
	
	<br><br>
	<form action="springmvc/testModelAttribute" method="post">
		<input type="text" name="username"  >
		<input type="text" name="id" value="1"  >
		<input type="text" name="email" >
		<input type="submit" value="Test Submit">
	</form>
	<br>
	 <form action="fileUpload" method="post" enctype="multipart/form-data">
		  	<input type="file" name="uploadName">
		   	<input type="text" name="token" value="${token}" />
		  	<input type="submit" value="提交">
 	 </form>
		<br><br>
	<a href="springmvc/testViewAndViewResolver">test ViewAndViewResolver</a>
	
		<br><br>
	<a href="springmvc/testView">test View</a>
	
		<br><br>
	<a href="viewexcel">test ExcelView</a><br><br>
	<a href="a/b">test annotation</a>
	
</body>
</html>