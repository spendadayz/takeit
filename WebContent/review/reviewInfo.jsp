<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.takeit.model.dto.Review"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 후기</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/review.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

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
<div id="reviews">
	<div id="title">
	<div id="review_info" align='center'>
		<h3>작성 후기조회</h3>
	</div>
	<form action="/takeit/item/reviewController?action=setReviewInfo&reviewNo=${review.reviewNo}" method="post">
		<table class="review-table">
			<tr >
				<th>후기번호</th>
				<td><input type="text" id="reviewNo" name="reviewNo"
					value="${review.reviewNo }" disabled="disabled"></td>

				<th>상품번호</th>
				<td><input type="text" id="itemNo" name="itemNo"
					value="${ review.itemNo}" disabled="disabled"></td>
			</tr>
			<tr >
				<th>조회수</th>
				<td><input type="text" id="reviewViews" name="reviewViews"
					value="${review.reviewViews}" disabled="disabled"></td>

				<th>상품평점</th>
				<td><input type="text" id="reviewScore" name="reviewScore"
					value="${review.reviewScore}"></td>
			</tr>
			<tr >
				<th>작성자</th>
				<td><input type="text" id="memberId" name="memberId"
					value="${review.memberId }" disabled="disabled"></td>

				<th>후기작성일</th>
				<td><input type="text" id="reviewDate" name="reviewDate"
					value="${review.reviewDate}" disabled="disabled"></td>
			</tr>
			<tr >
				<th>후기제목</th>
				<td colspan="3"><input type="text" id="reviewUpdate-Title" name="reviewTitle" size="100"
					value="${review.reviewTitle}"></td>
			</tr>
			<tr>
				<th colspan="2">후기이미지</th>
				<th colspan="2">내용</th>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><img id="review-img" src="/takeit/img/review/${review.reviewImg}"></td>
				<td colspan="2"><textarea id="reviewContents" name="reviewContents" >${review.reviewContents}</textarea></td>
			</tr>
		</table>
		<div class="btn-area" align='center'>
			<input class="link" type="submit" style="display: inline-block; line-height: 35px; vertical-align: middle;" value="내후기수정">
			<a href="/takeit/member/myPage.jsp"  style="display: inline-block; line-height: 35px; vertical-align: middle;" class="link">마이페이지</a>
		</div>
		
		<input type="hidden" value="${review.itemNo}" name="itemNo"/>
		<input type="hidden" value="${review.reviewTitle}" name="reviewTitle"/>
		<input type="hidden" value="${review.reviewContents}" name="reviewContents"/>
		<input type="hidden" value="${review.reviewViews}" name="reviewViews"/>
		<input type="hidden" value="${review.reviewScore}" name="reviewScore"/>
		<input type="hidden" value="${review.reviewImg}" name="reviewImg"/>

		</form>
	</div>
</div>

<!-- floating Banner -->
<jsp:include page="/common/floatingBanner.jsp"></jsp:include>
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>

