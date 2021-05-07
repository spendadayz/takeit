<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::검색결과</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
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

<%
	ArrayList<Search> searchList = (ArrayList<Search>)request.getAttribute("searchList");
	String searchInput = (String)request.getAttribute("searchInput");
%>

<h3 style="width:fit-content; margin: 20px auto; font-size: 30px;">[<%= searchInput %>]검색결과</h3>
<div id="item-recomm" class="view-width">
<%
for(Search dto : searchList) {
	double disc_rate = (100 - dto.getDiscRate())*0.01;
%>
<ul>
	<li>
		<a href="/takeit/item/itemController?action=itemDetail&itemNo=<%= dto.getItemNo() %>">
		<img id="itemImg" src="/takeit/img/item/<%= dto.getItemImg() %>">
		</a>
	</li>
	<li id="itemTitle">[<%= dto.getShopName() %>]<%=dto.getItemName() %></li>
	<li id="sellerName"><b>판매자</b><%= dto.getName() %></li>
	<li id="discRate" class="blink"><%= dto.getDiscRate() %>%할인</li>
	<li id="salePrice">	&#8361;<fmt:formatNumber value="<%= dto.getItemPrice()*disc_rate %>" pattern="###,###"/></li>
</ul>
<%
	}
%>
</div>
<a href="/takeit/index" class="link">홈으로이동</a>
<!-- floating Banner -->
<jsp:include page="/common/floatingBanner.jsp"></jsp:include>
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>