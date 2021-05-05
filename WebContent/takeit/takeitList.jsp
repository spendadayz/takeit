<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 상품 목록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/takeit.css">
<style>
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
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
			
			takeitTimeElement.innerHTML = "남은시간 :" +d1 + "일 "+ h1+"시간 "+m1+"분 "+s1 + "초"
			
		}
	}
	$(document).ready(function (){
		getTakeitTime();
		setInterval(getTakeitTime, 1000);
	});
</script>
</head>
<body>
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

<h3 style="width:fit-content; margin: 20px auto; font-size: 30px;">잇거래</h3>
<div id="item-recomm" class="view-width">
	<c:forEach items="${takeitItemList}" var="dto">
	<div class="takeit_item_wrap">
		
		
		<ul class="takeit_item">
			<li style="width: 250px;">
				<span class="takeitTime takeit-listTime blink" data-takeittime="${dto.takeitDate}"></span><br>
				<a href="/takeit/takeit/takeitController?action=takeitItemDetail&itemNo=${dto.itemNo }">
					<img id="takeitImg" alt="${dto.itemImg}" src="/takeit/img/item/${dto.itemImg}">
				</a>
				<span class="item-fresh">신선도${100-(dto.discRate)}%</span>
			</li>
			<fmt:formatNumber var="itemPrice" value="${dto.itemPrice}" type="number"/>
			<fmt:formatNumber var="discPrice" value="${dto.itemPrice * (100-dto.discRate) / 100}" type="number"/>
			<fmt:parseNumber  var="intPrice" value="${(dto.itemPrice * (100-dto.discRate) / 100)/1000}" integerOnly="true"/>
			<fmt:formatNumber var="takeitItemPrice" value="${intPrice*1000}" type="number"/>
			<fmt:formatNumber var="itemDiscRate" value="${dto.discRate / 100}" type="percent"/>
			<fmt:formatNumber var="takeitDisc" value="${(dto.itemPrice * (100-dto.discRate) / 100) - intPrice*1000 }" type="number"/>
			<br>
			<li id="itemTitle">${dto.itemName}</li>
			<li id="discRate">(할인 ${itemDiscRate}+${takeitDisc}원)</li>
			<li id="salePrice">${takeitItemPrice}원</li>
			<li id="price">${dto.itemPrice}원</li>
		</ul>
	</div>
	</c:forEach>
</div>


<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
