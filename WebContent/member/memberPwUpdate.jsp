<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/memberPwUpdate.css">
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
<h3 id ="title" align="center">비밀번호 변경</h3>

<div id="container">
	<c:choose>
		<c:when test ="${member.grade == 'S' or seller.grade== 'S'}">
	 		<!-- 판매자 마이페이지 메뉴 -->
	 		<jsp:include page="/common/mypage_seller_menu.jsp"></jsp:include>
	 		<div id="mypage_remove">
				<h3>판매자 비밀번호 변경</h3>
				<hr>
		<div id="myInfoRemove">
			<form action = "/takeit/member/mypageController?action=setSellerPw" method="post">
			<table id="myInfo_table">
				<tr>
					<th>아이디</th>
					<td>
					<input type="text" id="sellerId" name="sellerId">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
					<input type="password" id="sellerPw" name="sellerPw">
					</td>		
				</tr>
				<tr>
					<th>변경할 비밀번호</th>
					<td>
					<input type="password" id="sellerPw2" name="sellerPw2">
					</td>		
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" class="updateBtn" value="비밀번호 변경">
				</tr>
			
			</table>
		</form>
		</div>
	</div>
		</c:when>
		<c:otherwise>
			<!-- 일반회원 마이페이지 메뉴 -->
			<jsp:include page="/common/mypage_member_menu.jsp"></jsp:include>
			<div id="mypage_remove">
			<h3>비밀번호 변경</h3>
			<hr>
				<div id="myInfoRemove">
					<form action="/takeit/member/mypageController?action=setMemberPw" method="post">
					<table id="myInfo_table">
						<tr>
							<th>아이디</th>
							<td>
							<input type="text" id="memberId" name="memberId">
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
							<input type="text" id="memberPw" name="memberPw">
							</td>		
						</tr>
						<tr>
							<th>변경할 비밀번호</th>
							<td>
								<input type="text" id="memberPw2" name="memberPw2">
							</td>		
						</tr>
						
						<tr>
							<td colspan="2" align="center">
							<input type="submit" class="updateBtn"  value="비밀번호 변경">
						</tr>
					
					</table>
				</form>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

	
</div>

 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>
