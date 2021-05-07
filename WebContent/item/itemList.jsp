<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.takeit.model.dto.*" %>
<%@ include file="/common/taglib_menu.jsp" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::카테고리상품</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/item.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<%
	if(((ArrayList<Item>)request.getAttribute("categoryItemList")).isEmpty()){
		response.sendRedirect("/takeit/item/noItemList.jsp");
		return;
	}
%>
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

<!-- contents menu -->
<%
ArrayList<Item> categoryItemList = (ArrayList<Item>)request.getAttribute("categoryItemList");
String categoryName = categoryItemList.get(0).getItemCategoryName();
%>
<div id="title" style="width: fit-content; margin: 0 auto;">
	<h3>[<%= categoryName %>] 상품 목록</h3>
</div>

<div class="item_wrap">
<%
	for(Item dto : categoryItemList){
%>
	<div class="item_list" style="white-space: nowrap;">
		<div>
		<a href="/takeit/item/itemController?action=itemDetail&itemNo=<%= dto.getItemNo() %>">
			<img id="itemListImg" src="/takeit/img/item/<%= dto.getItemImg() %>">
		</a>
		</div>
		<a href="/takeit/item/itemController?action=itemDetail&itemNo=<%= dto.getItemNo() %>">
		<span id="shop-name">[<%= dto.getShopName() %>]</span><br>
		<span id="itemLI"><%= dto.getItemName() %></span><br>
		</a>
		<span id="itemFr">신선도 :<%= dto.getFreshPercent() %>%</span><br>
		<span id="itemPr">&#8361;<fmt:formatNumber value="<%= dto.getItemPrice() %>" pattern="###,###"/></span>
		<span id="itemDc" style="color: red">(<%= dto.getDiscRate()%>%할인)</span>
		<span id="itemDiscPrice"><fmt:formatNumber value="<%= (dto.getItemPrice())*(100-(dto.getDiscRate()))/100 %>" pattern="###,###"/>원</span>
	</div>
<%
	}
%>
</div>		

<!-- floating Banner -->
<jsp:include page="/common/floatingBanner.jsp"></jsp:include>
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>