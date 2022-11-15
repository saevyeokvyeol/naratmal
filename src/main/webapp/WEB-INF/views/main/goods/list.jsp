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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>
	<body>
		<table class="table">
			<tr>
				<th>상품 코드</th>
				<th>상품 카테고리</th>
				<th>상품명</th>
				<th>상품 가격</th>
				<th>상품 상태</th>
			</tr>
			<c:forEach items="${list}" var="goods">
				<tr>
					<td>${goods.goodsId}</td>
					<td>${goods.goodsClass.goodsClassName}</td>
					<td><img src="${path}/resources/images/goods/${goods.goodsThumbnail}"><a href="${path}/main/goods/${goods.goodsId}">${goods.goodsName}</a></td>
					<td>${goods.goodsPrice}</td>
					<td>${goods.goodsState.goodsStateName}</td>
				</tr>
			</c:forEach>
		</table>
		<nav aria-label="Page navigation example" id="pagenation">
			<ul class="pagination justify-content-center">
				<c:set var="doneLoop" value="false" />
				<c:if test="${(startPage - blockCount) > 0 and list.size() != 0}">
					<li class="page-item">
						<a class="page-link" href="${URL}?page=${startPage-1}">이전</a>
					</li>
				</c:if>
				<c:forEach var='i' begin='${startPage}' end='${(startPage - 1) + blockCount <= totalPage ? (startPage - 1) + blockCount : totalPage}'>
					<c:if test="${not doneLoop}">
						<li class="page-item"><a class="page-link ${i == page ? 'active' : 'page'}" href="${URL}?page=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${(startPage+blockCount) <= totalPage}">
					<li class="page-item">
						<a class="page-link" href="${URL}?${location.search}page=${startPage + blockCount}">다음</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</body>
</html>