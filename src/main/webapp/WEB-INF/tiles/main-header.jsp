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
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<link type="text/css" rel="stylesheet" href="${path}/resources/css/main.css">
	</head>
	<body>
		<div id="header">
			<div>
				<a href="${path}/main/user/signup" class="btn btn-light">회원가입</a>
				<c:choose>
					<c:when test="${loginUser == null}">
						<a href="${path}/main/user/login" class="btn btn-light">로그인</a>
					</c:when>
					<c:otherwise>
						${loginUser.userName}
						<a href="${path}/main/user/logout" class="btn btn-light">로그아웃</a>
						<a href="${path}/main/user/profile" class="btn btn-light">프로필</a>
						<a href="${path}/main/cart/list" class="btn btn-light">장바구니 보기</a>
					</c:otherwise>
				</c:choose>
				<a href="${path}/admin/user/list" class="btn btn-light">유저리스트</a>
			</div>
			<div>
				<a href="${path}/admin/goods/list" class="btn btn-light">관리자 | 상품 리스트</a>
				<a href="${path}/admin/goods/insert" class="btn btn-light">관리자 | 상품 추가</a>
			</div>
			<div>
				<a href="${path}/main/goods/list" class="btn btn-light">일반 회원 | 상품 리스트</a>
			</div>
		</div>
	</body>
</html>