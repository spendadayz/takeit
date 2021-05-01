<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<style type="text/css">

.myPage_menu_aside ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
}
.myPage_menu_aside li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}
.myPage_menu_aside h3.active {
    background-color: #5a7d59;
    color: white;
}
.myPage_menu_aside li a:hover:not(.active) {
    background-color: #5a7d59;
    color: white;
}
#container{
	height: 700px;
	display: flex;
}
.myPage_menu_aside {
	width: 200px;
	height: 500px;
	float: left;
	margin-left: 200px;
	margin-top: 100px;
}

#mypage_remove{
 padding: 0;
    width: 800px;
    height: 700px;
    float: left;
    margin-left: 130px;

}
#myInfoRemove{
display: inline-block;
    padding: 0;
    width: 800px;
    height: 700px;
    float: left;
    margin-left: 50px;
	text-align: -webkit-center;
	margin-left: 60px;
	margin-top: 50px;
}

#myInfo_table{
	width: 500px;
}
</style>
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
<h3 align="center">회원탈퇴</h3>

<div id="container">
	<c:choose>
		<c:when test ="${grade == 'S' }">
	 		<!-- 판매자 마이페이지 메뉴 -->
	 		<jsp:include page="/common/mypage_seller_menu.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<!-- 일반회원 마이페이지 메뉴 -->
			<jsp:include page="/common/mypage_member_menu.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>


	<div id="mypage_remove">
	<h3>회원 탈퇴</h3>
	<hr>
		<div id="myInfoRemove">
			<table id="myInfo_table">
				<tr>
					<th>아이디</th>
					<td>
					<input type="text" id="member_id" name="member_id">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
					<input type="text" id="member_pw" name="member_pw">
					</td>		
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
					<input type="text" id="member_pw2" name="member_pw2">
					</td>		
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input class="mypage_menu" class="inline" type="button" value="탈퇴하기" onclick="location.href='/takeit/member/myInfoUpdate.jsp'">
				</tr>
			
			</table>
		
		</div>
	</div>
</div>

 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>
