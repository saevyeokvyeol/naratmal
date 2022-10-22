<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.userTel}</td>
					<td>${user.addr} ${user.addrDetail}</td>
					<td>${user.userInsertDate}</td>
					<td>
						<c:if test="${user.userQuit == 'T'}">
							탈퇴
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<nav aria-label="Page navigation example" id="pagenation">
			<ul class="pagination justify-content-center">
				<c:set var="doneLoop" value="false" />
				<c:if test="${(startPage - blockCount) > 0 and userList.size() != 0}">
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