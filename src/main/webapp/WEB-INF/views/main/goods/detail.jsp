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
			$(document).on("click", "button[name=minus]", function() {
				let updateNum = parseInt($(this).next().val()) - 1;
				if(updateNum <= 0){
					alert("수량을 하나 이상 입력해주세요.");
					updateNum = 1;
				}
				$(this).next().val(updateNum);
				calcTotalPrice();
			}); // 수량 감소 업데이트 종료
			
			// 수량 증가 시 DB 업데이트
			$(document).on("click", "button[name=plus]", function() {
				let updateNum = parseInt($(this).prev().val()) + 1;
				$(this).prev().val(updateNum);
				calcTotalPrice();
			}); // 수량 증가 업데이트 종료
			
			$("#cart").click(function() {
				$.ajax({
					url : "${path}/cart/insert",
					type : "post",
	    			dataType: "text",
	    			data: {cartQty:$("#orderLineQty").val(), goodsId:$("#goodsId").val(), userId:"${loginUser.userId}"},
					success : function(result) {
						alert("장바구니에 상품이 담겼습니다.")
					},
					error : function(error) {
						alert(error)
					}
				}); // 아작스 종료
			})
		})
	</script>
	</head>
	<body>
		<h2>${goods.goodsName}</h2>
		${goods.goodsName} ${goods.goodsId} ${goods.goodsClassId} ${goods.goodsDetail} ${goods.goodsPrice}
		<img src="${path}/resources/images/goods/${goods.goodsThumbnail}">
		
		<form id="orderForm" action="${path}/main/order-form" method="post">
			<input hidden type="text" name="goodsId" id="goodsId" value="${goods.goodsId}">
			<input type="text" class="form-control" id="orderLineQty" name="orderLineQty" value="1">
			<input type="submit" id="order" class="btn btn-dark" value="구매">
			<input type="button" id="cart" class="btn btn-dark" value="장바구니">
		</form>
	</body>
</html>