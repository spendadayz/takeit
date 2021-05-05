<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<%@ page import="com.takeit.model.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::장바구니</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<%
	if(session.getAttribute("memberId")== null){
		MessageEntity message = new MessageEntity("message" , 0);
		message.setLinkTitle("로그인");
		message.setUrl("/takeit/member/memberLogin.jsp");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
	}
%>
<!-- 상단 메뉴 -->
<!-- 로그인 후 메뉴 -->
<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>
<br>
<h1 style="width:fit-content; margin: 0 auto;">${memberId }님의 장바구니</h1>
<br>
<div id="shipfee-info">
<span id="shipfee-free"><b style="color: red;">*</b>50,000원 이상 결제 시 배송비 무료</span>
</div>
<div id="cart-wrap">
<%
	ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
	for(Cart cart : cartList){
%>
	<div id="cart">
		<div>
			<img id="cart-img" alt="" src="/takeit/img/item/<%= cart.getItemImg() %>">
		</div>
		<div id="cart-info">
			<b>상품명</b>&emsp;
			<span id="cart-itemName"><a href="/takeit/item/itemController?action=itemDetail&itemNo=<%= cart.getItemNo() %>"><%= cart.getItemName() %></a></span><br><br>
			<b>판매자</b>&emsp;
			<span id="cart-itemSeller"><%= cart.getSellerName() %></span><br>
			<b>배송비</b>&emsp;
			<span id="cart-shippingFee">3,500원</span><br>
			<b>판매가</b>&emsp;
			<span id="cart-itemPrice"><fmt:formatNumber value="<%= cart.getItemPrice()  %>" pattern="###,###"/>원</span><br>
			<b>수량</b>&emsp;&emsp;
			<span id="cart-itemQty"><%= cart.getCartItemQty() %></span><br>
			<form action="/takeit/cartController?action=changeCartQty&itemNo=<%= cart.getItemNo()%>" method="post">
				<b>수량 변경</b>
				<input type="number" value="<%= cart.getCartItemQty() %>" id="change-cart-itemQty" name="change-cart-itemQty">
				<input type="submit" value="변경" class="cart-change-btn">		
			</form>
			<br>
		</div>
		<div id="cart-btn-wrap">
			<div>
				<b>결제금액</b>&emsp;<span id="cart-totPrice">
				&#8361;<fmt:formatNumber value="<%= cart.getTotalPrice()+3500 %>" pattern="###,###"/>
				</span>
			</div><br>
			<form action="#" method="post">
				<input type="submit" value="구매" class="small-btn" style="margin-bottom: 10px;">
			</form>
			<form action="/takeit/cartController?action=removeCart&itemNo=<%= cart.getItemNo() %>" method="post">
				<input type="submit" value="삭제" class="small-btn">
			</form>
		</div>
	</div>
	<hr style="width: 1050px;">
</div>
<%
	}
	int cartTotalPrice = (int) session.getAttribute("cartTotalPrice");
%>
<br>
<div id="cart-final-area">
	<div id="cart-final-price-area">
		<b>전체 결제 금액: </b><span id="cartTotalPrice">
		&#8361;<fmt:formatNumber value="<%= cartTotalPrice  %>" pattern="###,###,###"/></span>
	</div>
	<div id="cart-fainal-btn-area">
		<form action="#" method="post">
			<input type="submit" value="전체 구매" class="small-btn" style="margin-right: 10px">
		</form>
		<form action="/takeit/cartController?action=removeAllCart" method="post">
			<input type="submit" value="전체 삭제" class="small-btn">
		</form>
	</div>
</div>
</body>
</html>