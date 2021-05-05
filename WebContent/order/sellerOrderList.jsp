<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 판매목록 조회</title>
</head>
<body>
<c:forEach var="order" items="${orderList}">
<div>
	주문번호 : ${order.orderNo} <br>
	주문자 : ${order.memberId}<br>
	배송상태 : ${order.shipStatus} <br>
	요청사항 : ${order.shipRequest}<br>
	
	<c:forEach var="orderDetail" items="${order.orderDetails}">
	<div>
		상품명 : ${orderDetail.itemName} <br>
		상품개수 : ${orderDetail.itemQty}개 <br>
		상품결제금액 : ${orderDetail.itemPayPrice}원 <br> 
	</div><br>
	</c:forEach>

</div><br>
</c:forEach>


</body>
</html>