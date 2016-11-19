<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#testJson").click(function(){
		var url = this.href;
		var args = {};
		$.post(url, args, function(data){
			for(var i = 0; i < data.length; i++){
				var id = data[i].id;
				var lastName = data[i].lastName;
				alert(id + ": " + lastName);
			}
		});
		return false;
	});
})
</script>

</head>
<body>
<a href="emps">全部员工信息</a><br><br>

<a href="testJson" id="testJson">Test Json</a><br><br>

<a href="testResponseEntity" >Test ResponseEntity</a><br><br>

<a href="i18n" >Test i18n</a><br><br>

<a href="testException?id=10" >Test Exception</a><br><br>

<a href="test" >Test spring 和spring mvc整合</a><br><br>
<br>
<form action="springUpload" method="POST" enctype="multipart/form-data">
		File: <input type="file" name="file"/>
		File1: <input type="file" name="file1"/>
		Desc: <input type="text" name="desc"/>
		<input type="submit" value="文件上传"/>
	</form>
	
<br>
		<form action="testHttpMessageConverter" method="POST" enctype="multipart/form-data">
		File: <input type="file" name="file"/>
		Desc: <input type="text" name="desc"/>
		<input type="submit" value="Submit"/>
	</form>
	
	<br>
	重复提交
	<form action="save" method="post">
		<input type="text" name="name">
		<input type="text" name="password">
		 <input type="hidden" name="token" value="${token}">
		 <input type="submit" value = "提交">
	</form>
	<br>
		没有重复提交
	<form action="saveTest" method="post">
		<input type="text" name="username">
		<input type="text" name="password">
		 <input type="submit" value = "提交">
	</form>
</body>
</html>