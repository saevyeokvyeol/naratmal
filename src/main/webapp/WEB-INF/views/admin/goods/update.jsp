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
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function() {
			function selectAllClass() {
				$.ajax({
					url : "${path}/goods/selectClassAll",
					type : "post",
	    			dataType: "json",
					success : function(result) {
						text = ""
						$.each(result, function(index, item) {
							if (item.goodsClassId == ${goods.goodsClassId}) {
								text += `<option selected value='\${item.goodsClassId}'>\${item.goodsClassName}</option>`;
							} else {
								text += `<option value='\${item.goodsClassId}'>\${item.goodsClassName}</option>`;
							}
						})
						$("#goodsClassId").append(text);
					},
					error : function(error) {
						alert("카테고리 정보를 가져올 수 없습니다.");
					}
				}); // 아작스 종료
			} // 카테고리 가져오기 종료
			
			selectAllClass()
		})
	</script>
	</head>
	<body>
		<h2>상품 수정</h2>
		<form action="${path}/admin/goods/update-complete" method="post" enctype="multipart/form-data">
			<input type="text" name="goodsId" value="${goods.goodsId}" hidden>
			<div class="form-floating">
				<input type="text" class="form-control" id="floatingId" placeholder="상품명" name="goodsName" value="${goods.goodsName}">
				<label for="floatingId">상품명</label>
			</div>
			<select class="form-select" id="goodsClassId" name="goodsClassId" value="${goods.goodsClassId}">
				<option>상품 카테고리</option>
			</select>
			<div class="form-floating">
				<textarea class="form-control" placeholder="설명" id="floatingDetail" name="goodsDetail" style="height: 100px">${goods.goodsDetail}</textarea>
				<label for="floatingDetail">설명</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="floatingPrice" placeholder="가격" name="goodsPrice" value="${goods.goodsPrice}">
				<label for="floatingPrice">가격</label>
			</div>
			<div class="mb-3">
				<input class="form-control" type="file" id="formFile" name="file">
			</div>
			
			<input type="submit" class="btn btn-dark" value="상품 수정">
			<input type="reset" class="btn btn-dark" value="취소">
		</form>
	</body>
</html>