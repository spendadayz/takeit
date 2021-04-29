<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 네비게이션 -->
<div id="navi-wrap" class="view-width">
	<div id="navi">
		<a href="#" id="category-wrap">전체카테고리</a>
		<span id="pipe">|</span>
		<a href="#">신상품</a>
		<span id="pipe">|</span>
		<a href="#">베스트</a>
		<span id="pipe">|</span>
		<a href="#">잇거래</a>
		<span id="pipe">|</span>
		<a href="/takeit/board/noticeList.jsp">공지사항</a>
	</div>
	<form action="#" id="mainSearch">
		<input type="text" id="searchInput" name="searchInput"  placeholder="검색어를 입력하세요..">
		<button id="search-btn" name="search-btn">
		<img alt="검색" src="/takeit/img/icon/ico_search_x2.png">
		</button>
	</form>
</div>
<div id="drop-menu">
	<ul class="sub-nav">
		<li><a href="#">채소</a></li>
		<li><a href="#">과일/견과/쌀</a></li>
		<li><a href="#">수산/해산/건어물</a></li>
		<li><a href="#">정육/계란</a></li>
		<li><a href="#">국/반찬/메인요리</a></li>
		<li><a href="#">샐러드/간편식</a></li>
		<li><a href="#">면/양념/오일</a></li>
		<li><a href="#">간식/과자/떡</a></li>
	</ul>
</div>
<hr>
<script type="text/javascript">
	$(document).ready(function(){
		$("#drop-menu").hide();
	});
	$("#category-wrap, #drop-menu").hover(function(){
		$("#drop-menu").stop().slideToggle(400);
	});	
	
</script>