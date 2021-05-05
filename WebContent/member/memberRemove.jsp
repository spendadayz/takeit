<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/memberRemove.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">

function removeCheck(){
	
	var memberPwElement = document.getElementById("memberPw");
	var memberPwElement2 = document.getElementById("memberPw2");
	
	var memberPw = memberPwElement.value;
	var memberPw2= memberPwElement2.value;
	
	var memberPwMessageElement = document.getElementById("memberPwMessage");
	
	if(memberPw != memberPw2){
		memberPwMessageElement.innerHTML = "비밀번호가 일치하지 않습니다.";
		memberPwElement2.value="";
		memberPwElement2.focus();
		return false;
	}
}


function sellerRemoveCheck(){
	
	
	var sellerElement = document.getElementById("sellerPw");
	var sellerElement2 = document.getElementById("sellerPw2");
	
	var sellerPw = sellerElement.value;
	var sellerPw2= sellerElement2.value;
	
	var memberPwMessageElement = document.getElementById("memberPwMessage");
	
	if(sellerPw != sellerPw2){
		memberPwMessageElement.innerHTML = "비밀번호가 일치하지 않습니다.";
		sellerElement2.value="";
		sellerElement2.focus();
		return false;
	}
}

</script>
<style type="text/css">


.error {
	color: red;
	font-weigth: bold;
	font-size: 7px;
}
</style>

</head>
<body>
<!-- 상단 메뉴 -->
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
<h3 id ="title" align="center">회원탈퇴</h3>

<div id="container">
	<c:choose>
		<c:when test ="${member.grade == 'S' or seller.grade== 'S'}">
	 		<!-- 판매자 마이페이지 메뉴 -->
	 		<jsp:include page="/common/mypage_seller_menu.jsp"></jsp:include>
	 		<div id="mypage_remove">
				<h3>판매자 회원 탈퇴</h3>
				<hr>
		<div id="myInfoRemove">
			<form action = "/takeit/member/mypageController?action=removeSeller" method="post">
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
					<th>비밀번호 확인</th>
					<td>
					<input type="password" id="sellerPw2" name="sellerPw2">
					<div id="memberPwMessage" class="error"></div>
					</td>		
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit"  class ="deleteBtn" value="탈퇴하기" onclick="return sellerRemoveCheck()">
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
			<h3>일반회원 탈퇴</h3>
			<hr>
				<div id="myInfoRemove">
					<form action="/takeit/member/mypageController?action=removeMember" method="post" name="memberRemove">
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
							<input type="password" id="memberPw" name="memberPw">
							</td>		
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td>
							<input type="password" id="memberPw2" name="memberPw2">
							<div id="memberPwMessage" class="error"></div>
							</td>		
						</tr>
						
						<tr>
							<td colspan="2" align="center">
							<input type="submit" class ="deleteBtn" value="탈퇴하기" onclick="return removeCheck()">
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
