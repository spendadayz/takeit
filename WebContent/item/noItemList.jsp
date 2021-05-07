<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<%@ page import="com.takeit.model.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::상품리스트조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/item.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
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
<div class="view-width">
	<div id="noItemList-wrap">
		<div id="noItemList-title">
			<h3>상품 목록 조회 결과</h3>
		</div>
		<img alt="오류" id="warning" src="/takeit/img/icon/warning-sign.png">
		<div id="noItemList-info">
			<span>이용에 불편을 드려 죄송합니다.</span><br>
			<span>해당 카테고리에 등록된 상품이 없습니다.</span><br>
			<span>상품 준비에 더욱 노력하겠습니다.</span><br>
			<span>문의사항을 남겨주시면 빠르게 처리하겠습니다.</span>
		</div>
		<a href="/takeit/index" class="link" style="margin-top: 30px;">홈으로 이동</a>
	</div>
</div>
<!-- floating Banner -->
<jsp:include page="/common/floatingBanner.jsp"></jsp:include>
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
</body>
</html>