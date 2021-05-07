<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/myPage.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

</head>
<body>

<c:choose>
	<c:when test="${not empty dto and not empty sellerId}">
		<jsp:forward page="/order/orderController?action=sellerOrderList"/>
	</c:when>
	<c:when test="${not empty dto and not empty memberId}">
		<jsp:forward page="/order/orderController?action=memberOrderList"/>
	</c:when>
	<c:otherwise>
		<jsp:forward page="/index"/>
	</c:otherwise>
</c:choose>

<!-- 상단 메뉴 -->
<c:if test="${empty memberId and empty sellerId}">
	<!-- 로그인 전 메뉴 -->
	<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
</c:if>
<c:if test="${not empty memberId or not empty sellerId}">
	<!-- 로그인 후 메뉴 -->
	<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
</c:if>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>
	
<h3 id ="title" align="center">마이페이지</h3>
<div id="container">
	<c:choose>
		<c:when test ="${sellerId != null}">
	 		<!-- 판매자 마이페이지 메뉴 -->
	 		<jsp:include page="/common/mypage_seller_menu.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<!-- 일반회원 마이페이지 메뉴 -->
			<jsp:include page="/common/mypage_member_menu.jsp"></jsp:include>
			<div id="mypage_order">
			<h3>주문내역</h3>
				<hr>
				<div id="order_Info">
					<h4>주문번호 : xxxxxxxxx </h4>
					<div>
						<img class="order_img" src="/takeit/img/item/item1.jpg">	
						<div id="itemInfo">
							<h6 style="font-size: 20px;">상품명 : 1등급 마블링 한우</h6>
							<h6 style="font-size: 16px;">상품 수량 : 1개</h6>
							<h6 style="font-size: 16px;">결제금액 : 4000원</h6>
							<h6 style="font-size: 16px;">수령 방법 : 배송</h6>
						</div>
						<div id="order_item">
							<h6 id="orderState" style="font-size: 20px;">주문 상태 : 배송중</h6>
							<input id="item_review_btn" class="linkBtn" type="button" value="상품 후기" >
							<input type="button" class="linkBtn" value="상품 문의" onclick="location.href='/takeit/boardController?action=boardList&boardCategory=3'">
						</div>
					</div>
				</div>
				<hr>
			</div>
		</c:otherwise>
	</c:choose>
 </div>
 
 <!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
 
</body>
</html>