<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MQ测试页面</title>
</head>
<body>
<form method="post" action="/MymqService/webservice" >
	<table border="1" style="width:550px;height:100px" cellpadding="0" cellspacing="0">
		<col style="width:100px;">
		<col>
		<col style="width:80px;text-align: center;">
		<tr>
			<td>消息内容：</td>
			<td><input name="content" type="text" style="width:99%;height:90%;"></td>
		</tr>
	</table>
	
	<div style="margin-top: 10px"><input type="submit" value="提交" style="width:100px;"></div>
</form>
</body>
</html>