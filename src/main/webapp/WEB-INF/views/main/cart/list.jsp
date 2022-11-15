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
	<script type="text/javascript">
		$(function() {
			$(".delete-cart").click(function() {
				$.ajax({
					url : "${path}/cart/delete/" + $(this).attr("id"),
					type : "post",
					success : function() {
						location.reload()
					},
					error : function(error) {
						alert("장바구니를 삭제할 수 없습니다.");
					}
				}); // 아작스 종료
			})
			
			
				
			// 수량 감소 시 DB 업데이트
			$(document).on("click", "button[name=minus]", function() {
				let updateNum = parseInt($(this).next().val()) - 1;
				if(updateNum <= 0){
					alert("수량을 하나 이상 입력해주세요.");
					updateNum = 1;
				}
				$(this).next().val(updateNum);
				$.ajax({
					url: "${path}/main/cart/update",
					type: "post",
					dataType : "json",
					data: {cartId: $(this).prev().val(), cartQty: $(this).next().val()},
					success: function() {
						location.reload();
					},
					error: function(err) {
						alert("장바구니 내역을 수정할 수 없습니다.");
					}
				}) // ajax 종료
			}); // 수량 감소 업데이트 종료
			
			// 수량 증가 시 DB 업데이트
			$(document).on("click", "button[name=plus]", function() {
				let updateNum = parseInt($(this).prev().val()) + 1;
				$(this).prev().val(updateNum);
				$.ajax({
					url: "${path}/main/cart/update",
					type: "post",
					dataType : "text",
					data: {cartId: $(this).prev().prev().prev().val(), cartQty: $(this).prev().val()},
					success: function() {
						location.reload();
					},
					error: function(err) {
						alert("장바구니 내역을 수정할 수 없습니다.");
					}
				}) // ajax 종료
			}); // 수량 증가 업데이트 종료
		})
	</script>
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
					<td>
						<input type="text" hidden value="${cart.goods.goodsId}">
						<button type="button" class="btn btn-outline-dark shadow-none btn-sm" name="minus"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash" viewBox="0 0 16 16"><path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/></svg></button>
						<input type="number" class="form-control-plaintext num" name="cartQty" min="1" max="9999" step="1" value="${cart.cartQty}" readonly="readonly">
						<button type="button" name="plus" class="btn btn-outline-dark shadow-none btn-sm"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16"><path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/></svg></button>
					</td>
					<td><button class="btn btn-outline-dark delete-cart" id="${cart.cartId}"><i class="fa-solid fa-xmark"></i></button></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>