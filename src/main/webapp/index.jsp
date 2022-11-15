<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="${path}/resources/css/main.css">
	<script type="text/javascript">
		location.href="${path}/main/users/login"
	</script>
	</head>
	<body>
		<h1>빠라바라바바밤</h1>
		<h3>${loginUser}</h3>
		<a href="${path}/main/logout" class="btn btn-dark">로그아웃</a>
	</body>
</html>