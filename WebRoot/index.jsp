<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    
    <title>首页</title>
	
  </head>
  
  <body style="text-align: center;">
  
  	<h1>$$$$$$$$$网站</h1>
  	<br/><br/>
  
	  <div align="right">
	  	  <c:if test="${user!=null }">
	  		欢迎回来：${user.nickname }<a href="${pageContext.request.contextPath }/servlet/DoLogout">注销</a>
		  </c:if>
		  
		  <c:if test="${user==null }">
		    <a href="${pageContext.request.contextPath }/servlet/RegisterServlet">注册</a><%--通过Servlet来找jsp目录下对应的jsp --%>
		    <a href="${pageContext.request.contextPath }/servlet/LoginServlet">登录</a>
	      </c:if>
	  </div>
	  <hr>
  </body>
</html>
