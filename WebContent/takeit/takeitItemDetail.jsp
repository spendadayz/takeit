<%@page import="com.takeit.model.dto.TakeitItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 상품 상세조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/takeit.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/cart.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script>
function getTakeitTime() {
	var date = new Date();
	
	for (i = 0; i < $(".takeitTime").length; i++) {
		var takeitTimeElement = $(".takeitTime").get(i);
		var takeitTime = takeitTimeElement.dataset.takeittime;
		var takeitDate =new Date(takeitTime);
		var result = takeitDate - date;
		result = result + 604800000;
		var d1 = parseInt(result / 86400000);
		var h1 = Math.floor((result % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		var m1 = Math.floor((result % (1000 * 60 * 60)) / (1000 * 60));
		var s1 = Math.floor((result % (1000 * 60)) / 1000);
		
		takeitTimeElement.innerHTML = d1 + "일 "+ h1+"시간 "+m1+"분 "+s1 + "초"
	}
}
$(document).ready(function (){
	getTakeitTime();
	setInterval(getTakeitTime, 1000);
	
	$("#addCart-area").hide();
	
	$("#addCart").on("click",function(){
		$("#addCart-area").slideToggle(300);
	});
});

</script>
</head>
<!-- 상단 메뉴 -->
<c:if test="${empty memberId }">
	<!-- 로그인 전 메뉴 -->
	<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
</c:if>
<c:if test="${not empty memberId }">
	<!-- 로그인 후 메뉴 -->
	<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
</c:if>

<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>

<div class="takeit_detail">
	<div class="takeit_item-content takeit_detail_wrap">
		<div class="takeitImg-wrap" >
			<img id="takeitImg" style="width:330px; height: 400px; " src="/takeit/img/item/${takeitItem.itemImg}">
		</div>
		<div class="desc takeit_detail_wrap">
			<fmt:formatNumber var="itemPrice" value="${takeitItem.itemPrice}" type="number"/>
			<fmt:formatNumber var="discPrice" value="${takeitItem.itemPrice * (100-takeitItem.discRate) / 100}" type="number"/>
			<fmt:parseNumber  var="intPrice" value="${(takeitItem.itemPrice * (100-takeitItem.discRate) / 100)/1000}" integerOnly="true"/>
			<fmt:formatNumber var="takeitItemPrice" value="${intPrice*1000}" type="number"/>
			<fmt:formatNumber var="itemDiscRate" value="${takeitItem.discRate / 100}" type="percent"/>
			<fmt:formatNumber var="takeitDisc" value="${(takeitItem.itemPrice * (100-takeitItem.discRate) / 100) - intPrice*1000 }" type="number"/>
			<ul class="takeit_info">
				<h2>${takeitItem.itemName}</h2>
				<li style="list-style: none">
					<span style="color: grey; text-decoration: line-through;">${itemPrice}원</span>
					<span style="color: black; font-weight: 700;">${discPrice}원</span>
					<span>(할인 ${itemDiscRate})</span>
					<span style="color: red; font-size:20px; font-weight: 700;">${takeitItemPrice}원</span>
					<span style="color: grey;">(잔돈할인 ${takeitDisc}원)</span>
				<hr>
				<span class="it_info"><b>판매단위</b>&emsp;${takeitItem.salesUnit}</span><br>
				<span class="it_info"><b>남은시간</b>&emsp;<span class="takeitTime takeit-detailTime blink" data-takeittime="${takeitItem.takeitDate}"></span></span><br>
				<span class="it_info"><b>원산지</b>&emsp;&emsp;${takeitItem.itemOrigin}</span><br>
				<span class="it_info"><b>포장타입</b>&emsp;${takeitItem.packTypeName}</span><br>
				<span class="it_info"><b>판매자</b>&emsp;&emsp;[Item 도메인에 sellerName, shopName 추가할것]</span><br>
				<span class="it_info"><b>고객평점</b>&emsp;${takeitItem.itemCustScore}</span><br>
				<span class="it_info"><b>유통기한</b>&emsp;${takeitItem.expirationDate}</span><br>
				<span class="it_info"><b>등록일자</b>&emsp;${takeitItem.itemInputDate}</span><br>
				<span class="it_info"><b>구역번호</b>&emsp;<span style="font-weight: 600;">${takeitItem.shopLocCode}-${takeitItem.memberLocNo }</span> ([구역이름을 takeitItem 도메인에 추가하기])</span><br>
				<fmt:formatNumber var="takeitRate" type="percent" value="${takeitItem.takeitCurrPrice/takeitItem.takeitPrice}" />
				<fmt:formatNumber var="takeitCurrPrice" type="number" value="${takeitItem.takeitCurrPrice}" />
				<fmt:formatNumber var="takeitPrice" type="number" value="${takeitItem.takeitPrice}" />
				<span class="it_info"><b>목표금액 달성률</b>&emsp; <span style="color: red; font-weight: 600;">${takeitRate}</span> (${takeitCurrPrice}원 / ${takeitPrice}원)</span><br>
			</ul>
		</div>
	</div>
	<div class="btn-area">
	<input type="button" class="link" id="addCart"  style="display: inline-block;" value="장바구니"/>
	<form action="#" method="post" style="display: inline-block;">
	<input type="button" class="link" style="display: inline-block;" value="구매"/>
	</form>
	</div>
	<!-- 장바구니 등록 -->
	<div id="addCart-area">
	<form action="/takeit/cartController?action=addCart&itemNo=${takeitItem.itemNo }" method="post">
	<!-- <form action="/takeit/cartController?action=addCart" method="post"> -->
	<br><hr>
		<div id="addCart-info">
			<div id="cart-info">
				<b>상품명</b>&emsp;
				<span id="addcart-itemName">${takeitItem.itemName }</span><br>
				<b>판매자</b>&emsp;
				<span id="addcart-itemSeller">${takeitItem.sellerName }</span><br>
				<b>배송비</b>&emsp;
				<span id="addcart-shippingFee">3500원</span><br>
				<b>수량</b>&emsp;&emsp;
				<select id="addcart-itemQty" name="cart-itemQty">
				<%
					for(int i=1; i<10; i++){
				%>
					<option value="<%= i %>"><%= i %></option>
				<%
					}
				%>
				</select>
			</div>
		</div>
		<div id="addCart-btn-area">
			<input type="submit" class="link" value="장바구니 추가"/>
		</div>
	</form>
	</div>
</div>

<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>