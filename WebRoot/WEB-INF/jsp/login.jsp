<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>login</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" />
	</head>
	<body>
		<div id="container">
			<div id="login">
				<div id="form">
					<form action="${pageContext.request.contextPath }/servlet/DoLogin" method="post">
						<div id="input">
							用户名：<input type="text" name="uname"><br/>
							密码：<input type="password" name="password"><br/>
						</div>
						<div id="btn">
							<input type="submit" value="登录">
						</div>
					
					</form>
				
				</div>
			</div>
		</div>
	
	</body>

</html>