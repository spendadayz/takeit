<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.Review"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.MessageEntity"%>

<%@ include file="/common/taglib_menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/review.css">
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
	<h1 class="title" align='center'>REVIEW</h1>

	<div id="small-btn">
		<a href="/takeit/item/reviewController?action=enrollReviewForm">후기작성</a>
	</div>
	<br>
	<br>
	<table id="review_tbl" class="review_">
		<!-- 제목행 -->
		<tr>
			<th>후기번호</th>
			<th>회원아이디</th>
			<th>상품번호</th>
			<th>후기등록일자</th>
			<th>후기제목</th>
			<th>후기내용</th>
			<th>후기평점</th>
			<th>후기사진</th>


		</tr>

		<%
			ArrayList<Review> reviewList = (ArrayList<Review>) request.getAttribute("reviewList");
			for (Review dto : reviewList) {
		%>
		<tr>
			<td><%=dto.getReviewNo()%></td>
			<td><%=dto.getMemberId()%></td>
			<td><%=dto.getItemNo()%></td>
			<td><%=dto.getReviewDate()%></td>
			<td><%=dto.getReviewTitle()%></td>
			<td><%=dto.getReviewContents()%></td>
			<td><%=dto.getReviewScore()%></td>
			<td><%=dto.getReviewImg()%></td>
		</tr>
		<%
			}
		%>

	</table>
	<br>
	<a href="/takeit/index.jsp" class="link">홈으로이동</a>


	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>