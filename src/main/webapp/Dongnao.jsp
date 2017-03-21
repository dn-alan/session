<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>session跨域演示</title>
</head>
<body>
<form action="session/save" method="post" target="iframe">
	用户名：<input type="text" name="userName" value=""/>
	年龄：<input type="text" name="age" value=""/>
	<input type="submit" value="保存session"/>
	<br>
	<iframe name="iframe"></iframe>
</form><br>
<form action="session/getSession" method="post" target="iframe1">
	<iframe name="iframe1"></iframe>
	<input type="submit" value="获取session"/>
</form>
</body>
</html>