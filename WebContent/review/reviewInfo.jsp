<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 후기</title>
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

		<div id="mypage_info" align='center'>
			<h3>작성 후기조회</h3>
			<hr>
<div id="review">
	<form action ="/takeit/review/reviewController?action=setReview" method="post">
	<table id="review_table">
		<tr>
			<th>후기번호</th>
			<td>
			<input type="text" id="reviewNo" name="reviewNo" value="${review.reviewNo }" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>
			<input type="text" id="memberId" name="memberId" value="${review.memberId }" readonly="readonly">
	
			</td>		
		</tr>
		<tr>
			<th>상품번호</th>	
			<td>
			<input type="text" id="itemNo" name="itemNo" value="${ review.itemNo}" readonly="readonly">
			</td>	
		</tr>
		<tr>
			<th>후기작성일</th>
			<td>
			<input type="text" id="reviewDate" name="reviewDate" value="${review.reviewDate}">
			</td>		
		</tr>
		<tr>
			<th>후기제목</th>
			<td>
			<input type="text" id="reviewTitle" name="reviewTitle" value="${review.reviewTitle}">
			</td>		
		</tr>
		<tr>
			<th>후기내용</th>	
			<td><textarea name="contents" rows="7" cols="50"></textarea>
			</td>	
		</tr>
		<tr>
			<th>상품평점</th>
			<td>
			<input type="text" id="reviewScore" name="reviewScore" value="${review.reviewScore }" >
			</td>		
		</tr>
		<tr>
			<th>후기사진</th>
			<td>
			<input type="file" id="reviewImg" name="reviewImg" value="${review.reviewImg }">
			</td>		
		</tr>
		
		
		<tr>
		   <td colspan="2" align="center">
			 <br><input type="submit" value="후기 수정">
			     <input type="submit" value="후기 삭제">
			</td>
		</tr>
	</table>
</form>
	<div id="home_btn">
			<br><input id = "home_btn"  type="button" value="홈으로 이동" onclick="location.href='/takeit/index.jsp'">
	</div>
</div>
</div>

 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>
 
