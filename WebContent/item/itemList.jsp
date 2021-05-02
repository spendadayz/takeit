<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.takeit.model.dto.Item" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.MessageEntity" %>
<%@ include file="/common/taglib_menu.jsp" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">

</head>

<body>
<c:choose>
	<c:when test="${empty memberId}">
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

<!-- contents menu -->
<h3 class="title"><span class="seperator_title">|||</span>상품전체조회<span class="seperator_title">|||</span></h3>
<table>
	<!-- 제목행 -->
	<tr>	
		<th>카테고리이름</th>
		<th>판매자</th>
		<th>상품</th>
		<th>판매가</th>
		<th>원산지</th>
		<th>재고량</th>
		<th>이미지</th>
		<th>잇거래여부</th>
		<th>포장타입</th>
		<th>유통기한</th>
		<th>공지사항</th>
		<th>신선도</th>
		<th>판매단위</th>
		<th>고객평점</th>
		<th>등록일자</th>
		<th>할인율</th>
		<th>상품번호</th>
		<th>포장타입번호</th>
		<th>카테고리번호</th>
		
	</tr>
	
	<!-- 상품전체 -->
	<c:forEach var="dto" items="${list}">
		<tr>	
		
			<td>${dto.itemCategoryName}</td>
			<td>${dto.sellerId}</td>
			<td>${dto.itemName}</td>
			<td>${dto.itemPrice}</td>
			<td>${dto.itemOrigin}</td>
			<td>${dto.itemStock}</td>
			<td>${dto.itemImg}</td>
			<td>${dto.itemTakeit}</td>
			<td>${dto.packTypeName}</td>
			<td>${dto.expirationDate}</td>
			<td>${dto.notice}</td>
			<td>${dto.freshPercent}</td>
			<td>${dto.salesUnit}</td>
			<td>${dto.itemCustScore}</td>
			<td>${dto.itemInputDate}</td>
			<td>${dto.discRate}</td>
			<td>${dto.itemNo}</td>
			<td>${dto.packTypeNo}</td>
			<td>${dto.itemCategoryNo}</td>
		
	</c:forEach>	
</table>
<a href="/takeit/index.jsp" class="link">홈으로이동</a>
	<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>