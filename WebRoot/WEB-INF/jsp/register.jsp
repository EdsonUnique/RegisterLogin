<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Register</title>
	</head>
	<body>
		<div align="center" id="register">
			<form action="${pageContext.request.contextPath}/servlet/DoRegister" method="post">
				<table border="0" >
					<tr>
						<td>用户名</td>
						<td><input type="text" name="uname" id="uname" value="${param.uname }"/><font color="red">*</font>${form.uname} </td>
					</tr>
					
					<tr>
						<td>密码</td>
						<td><input type="password" name="password" id="password" value="${param.password }"/><font color="red">*</font>${form.password }</td>
					</tr>
					
					<tr>
						<td>确认密码</td>
						<td><input type="password" name="password1" id="password1" value= "${param.passward1 }"/><font color="red">*</font>${form.password1 }</td>
					</tr>
					
					<tr>
						<td>邮箱</td>
						<td><input type="text" name="email" id="email" value="${param.email}"/><font color="red">*</font>${form.email }</td>
					</tr>
					
					<tr>
						<td>生日</td>
						<td><input type="text" name="birthday" id="birthday" value="${param.birthday}"/>${form.birthday }</td>
					</tr>
					
					<tr>
						<td>昵称</td>
						<td><input type="text" name="nickname" id="nickname" value="${param.nickname}"/><font color="red">*</font>${form.nickname }</td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="register" id="register" value="注册"/></td>
					</tr>
				
				
				</table>
			
			</form>
		</div>

	
	</body>

</html>