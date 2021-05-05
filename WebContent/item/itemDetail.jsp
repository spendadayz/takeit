<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<%@page import="com.takeit.model.dto.Item"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/item.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

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
	<form>
		<div id="enroll_total">
			<div style="display: flex;">
				<div style="width: fit-content;">
					<img alt='맛간장' src="/takeit/img/item/${item.itemImg}" width="450"	height="310">
				</div>

				<div id="detail_div" style="width: fit-content;">
					<h1>${item.itemName}</h1>
					<fmt:formatNumber var="itemPrice" value="${item.itemPrice}" type="number"/>
					<fmt:formatNumber var="discPrice" value="${item.itemPrice * (100-item.discRate) / 100}" type="number"/>
					<fmt:parseNumber  var="realPrice" value="${(item.itemPrice * (100+item.discRate) / 100)}" integerOnly="true"/>
					<fmt:formatNumber var="itemDiscRate" value="${item.discRate / 100}" type="percent"/>
					<span style="color: red"> ${itemPrice} </span> 
					<span> (${itemDiscRate}할인) </span>&emsp;&emsp;&emsp; 
					
					<span>소비자 권장소매가: </span> 
					<span>${realPrice} </span>
					<hr class="line1">
					
					
					<span class="it_info"><b>카테고리</b>&emsp;${item.itemCategoryName}</span><br>
					<span class="it_info"><b>판매단위</b>&emsp;${item.salesUnit}</span><br>
					<span class="it_info"><b>재고량</b>&emsp;${item.itemStock}</span><br>
					<span class="it_info"><b>원산지</b>&emsp;&emsp;${item.itemOrigin}</span><br>
					<span class="it_info"><b>포장타입</b>&emsp;${item.packTypeName}</span><br>
			        <span class="it_info"><b>고객평점</b>&emsp;${item.itemCustScore}</span><br>
					<span class="it_info"><b>유통기한</b>&emsp;${item.expirationDate}</span><br>
					<span class="it_info"><b>등록일자</b>&emsp;${item.itemInputDate}</span><br>
					<span class="it_info"><b>판매상점</b>&emsp;${item.shopName}</span><br>
					<span class="it_info"><b>판매자</b>&emsp;&emsp;${item.sellerName}</span><br>
					<span class="it_info"><b>안내사항</b>&emsp;${item.notice}</span><br>					
				</div>
			</div>
		</div>

		<div class="btn-area" align='center'>
	      <input type="button" class="link"  style="display: inline-block;" value="장바구니"/>
	      <input type="button" class="link" style="display: inline-block;" value="구매"/>
	    </div>
	</form>

<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>