<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기</title>
<style type="text/css">
img[src$="img/.jpg/"] {
	width: 30px;
	height: 30px;
}
</style>
</head>
<body>
	<div align='right'>
			<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
	</div>
	<div id=logo_menu>
		<div align='center'>
			<a href="/takeit/index.jsp"><img src="/takeit/img/takeit.png" title="시작페이지이동" alt="이미지 준비중"></a>
		</div>
		<hr class="line1"> 
		<div align='center'> 
			<a href="">전체 카테고리</a> 
			<a href="">신상품</a> 
			<a href="">베스트</a> 
			<a href="">알뜰쇼핑</a> 
			<a href="">헤택상품</a> 
			<a href="">IT거래</a> 
			<a href="">공지사항</a>
		</div>
	</div>
	<h3 align="center">후기</h3>
	<div align="center">
	   <img src="/takeit/img/item/item2.jpg" width="250" height="300">
	   <div style="width: fit-content;" >
					<h3>짭짤한 맛간장</h3>
					<div >
						 <span> 제목:맛간장의 맛	</span>
						 <span> 작성자:user02		</span>
						
					</div>
	   
		<img src="/takeit/img/item/item3.jpg" width="250" height="300">
		<div style="width: fit-content;">
					<h3>마이 리틀 요거트</h3>
					<div >
					     <span> 제목:요거트 가격이 너무 좋아요</span>
						 <span> 작성자:user03	</span>
					
					</div>
		
		<img src="/takeit/img/item/item4.jpg" width="250" height="300">
		<div style="width: fit-content;">
					<h3>매그넘 아이스크림</h3>
					<div >
					     <span> 제목:매그넘 아이스크림 개수	</span>
						 <span>작성자:user04</span>
					
					</div>
		</div>
		<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>