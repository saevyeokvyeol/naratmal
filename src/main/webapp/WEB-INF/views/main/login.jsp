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
	</head>
	<body>
		<div id="main-content-body">
			<form action="${pageContext.request.contextPath}/main/login-complete" method="post">
				<div class="form-floating">
					<input type="text" class="form-control" id="floatingId" name="userId" placeholder="아이디">
					<label for="floatingId">아이디</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="floatingPassword" name="userPassword" placeholder="비밀번호">
					<label for="floatingPassword">비밀번호</label>
				</div>
				<input type="submit" class="btn btn-dark" value="로그인">
				<a href="${path}/main/signup" class="btn btn-dark">회원가입</a>
			</form>
		</div>
	</body>
</html>