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
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
	</head>
	<body>
		<table class="table">
			<tr>
				<th>상품명</th>
				<th>상품 가격</th>
				<th>상품 상태</th>
			</tr>
			<c:forEach items="${list}" var="cart">
				<tr>
					<td><img src="${path}/resources/images/goods/${cart.goods.goodsThumbnail}"> <a href="${path}/admin/goods/update/${cart.goods.goodsId}">${cart.goods.goodsName}</a></td>
					<td>${cart.goods.goodsPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>