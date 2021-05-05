<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.takeit.model.dto.Item" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.MessageEntity" %>
<%@ include file="/common/taglib_menu.jsp" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 상품목록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/item.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
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

<!-- contents menu -->
<h1 class="title" style="width:fit-content; margin: 20px auto; font-size: 30px;">신상품</h1>
<table>

	
	<c:forEach var="dto" items="${itemList}">
		<div class="item_wrap">
		<ul class="item_list" >
			<li>
			<a href="/takeit/item/itemController?action=itemDetail&itemNo=${dto.itemNo}">
				<img id="itemImg" alt="${dto.itemImg}" src="/takeit/img/item/${dto.itemImg}">
			
				</a>
			</li>

				<!--<li id="itemLI">${dto.itemImg}</li>-->
				<li id="itemLI">${dto.itemName}</li>
				<li id="itemFr">신선도 :${dto.freshPercent}%</li>
				<li id="itemDc" style="color: red">${dto.discRate}%</li>
				<li id="itemPr">${dto.itemPrice}원</li>
			  
	       
</ul>
</div>		
	</c:forEach>	
</table>

<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>