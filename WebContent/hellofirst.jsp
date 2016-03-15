<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<% out.println(request.getParameter("username")); %>
<% out.println(request.getParameter("password")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
<title>Insert title here<%= request.getParameter("password") %></title>
<script type="text/javascript">
</script>
</head>
<body>
	body
	${param.username}:
	${param.password}
</body>
</html>