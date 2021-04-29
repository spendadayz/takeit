<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Take it::즐거움의 시작</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<!-- 상단 메뉴 -->
<c:choose>
	<c:when test="${empty memberId or empty grade}">
		<!-- 로그인 전 메뉴 -->
		<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
	</c:otherwise>
</c:choose>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>
<!-- 메인배너 -->
<section id="main-visual">
	<div class="container">
		<div class="inner">
		<img alt="메인배너" src="/takeit/img/main/main1.jpg">
		</div>
		<div class="inner">
		<img alt="메인배너" src="/takeit/img/main/main2.jpg">
		</div>
		<div class="inner">
		<img alt="메인배너" src="/takeit/img/main/main3.jpg">
		</div>
		<div class="inner">
		<img alt="메인배너" src="/takeit/img/main/main4.jpg">
		</div>
		<div class="inner">
		<img alt="메인배너" src="/takeit/img/main/main5.jpg">
		</div>
	</div>
</secion>
<div id="btn-wrap" class="view-width">
<button class="btn1">1</button>
<button class="btn2">2</button>
<button class="btn3">3</button>
<button class="btn4">4</button>
<button class="btn5">5</button>
</div>
<script type="text/javascript">
document.querySelector(".btn2").addEventListener('click', function(){
	document.querySelector('.container').style.transform = 'translate(-100vw)';
});
document.querySelector(".btn3").addEventListener('click', function(){
	document.querySelector('.container').style.transform = 'translate(-200vw)';
});
document.querySelector(".btn4").addEventListener('click', function(){
	document.querySelector('.container').style.transform = 'translate(-300vw)';
});
document.querySelector(".btn5").addEventListener('click', function(){
	document.querySelector('.container').style.transform = 'translate(-400vw)';
});
document.querySelector(".btn1").addEventListener('click', function(){
	document.querySelector('.container').style.transform = 'translate(0vw)';
});
</script>
</section>
<!-- 상품추천 구역-->
<h3 style="width:fit-content; margin: 20px auto; font-size: 30px;">이 상품 어때요?</h3>
<div id="item-recomm" class="view-width">
<ul>
	<li>
		<a href="#">
		<img id="itemImg" alt="소불고기" src="/takeit/img/item/item1.jpg">
		</a>
	</li>
	<li id="itemTitle">[일상味소]불고기 200g(냉장)</li>
	<li id="discRate">35%</li>
	<li id="salePrice">5,525원</li>
	<li id="price">8,500원</li>
</ul>
<ul>
	<li>
		<a href="#">
		<img id="itemImg" alt="맛간장" src="/takeit/img/item/item2.jpg">
		</a>
	</li>
	<li id="itemTitle">[미자언니네]프리미엄 맛간장</li>
	<li id="salePrice">12,000원</li>
</ul>
<ul>
	<li>
		<a href="#">
		<img id="itemImg" alt="소불고기" src="/takeit/img/item/item3.jpg">
		</a>
	</li>
	<li id="itemTitle">[상하목장]마이리틀 유기농 자먹는 요거트 3종</li>
	<li id="discRate">26%</li>
	<li id="salePrice">2,575원</li>
	<li id="price">3,480원</li>
</ul>
<ul>
	<li>
		<a href="#">
		<img id="itemImg" alt="소불고기" src="/takeit/img/item/item4.jpg">
		</a>
	</li>
	<li id="itemTitle">[매그넘]부드러운 클래식라인 아이스크림 바 3종 (4입팩)</li>
	<li id="discRate">59%</li>
	<li id="salePrice">3,271원</li>
	<li id="price">7,980원</li>
</ul>
</div>

<!-- 후기 구역 -->
<h3 style="width:fit-content; margin: 20px auto; font-size: 30px;">베스트후기</h3>
<div id="best-review" class="view-width">
<ul>
	<li>
		<a href="#">
		<img id="review-img" alt="매그넘" src="/takeit/img/review/magnum.jpg">
		</a>
	</li>
	<li id="reviewTitle">초코코팅이 정말 맛있어요!</li>
	<li id="reviewWriter">user01</li>
	<li id="review"> 너무 좋아요! 다음에 또 사먹...</li>
</ul>
<ul>
	<li>
		<a href="#">
		<img id="review-img" alt="소불고기" src="/takeit/img/review/bulgogi.jpg">
		</a>
	</li>
	<li id="reviewTitle">1인가구 안성맞춤</li>
	<li id="reviewWriter">user03</li>
	<li id="review">친구 초대해서 같이 먹었는데 좋...</li>
</ul>
<ul>
	<li>
		<a href="#">
		<img id="review-img" alt="샐러드" src="/takeit/img/review/salad.jpg">
		</a>
	</li>
	<li id="reviewTitle">신선하고 재료도 푸짐해요</li>
	<li id="reviewWriter">user05</li>
	<li id="review">다이어트는 앞으로 이 샐러드와 함...</li>
</ul>
<ul>
	<li>
		<a href="#">
		<img id="review-img" alt="우유" src="/takeit/img/review/milk.jpg">
		</a>
	</li>
	<li id="reviewTitle">우리 애기가 좋아해요</li>
	<li id="reviewWriter">user05</li>
	<li id="review">우유 비린내도 없고 고소해서 좋...</li>
</ul>
</div>
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>