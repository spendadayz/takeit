<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 조회</title>
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

#mypage_btn{
		width:30%;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		background-color: #7B977A;
		color: white;
		margin-top: 15px;
		border: 1px solid #7B977A;
		margin-right: 20px;
}

#sellerInfo{
	display: inline-block;
    padding: 0;
    width: 800px;
    height: 700px;
    float: left;
    margin-left: 50px;
	text-align: -webkit-center;
	margin-left: 130px;
}


#mypage_sellerInfo{
 padding: 0;
    width: 1000px;
    height: 700px;
    float: left;
    margin-left: 130px;
}

#myInfo_table{
	width: 500px;
}

#infoUpdateBtn {
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		border: 1px solid #7B977A;
		color: white;
		background: #7B977A;

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
<h3 align="center">내 정보 조회</h3>

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
		
		
		<div id="mypage_sellerInfo">
			<h3>내 정보 조회</h3>
			<hr>
	<div id="sellerInfo">
		<form action="/takeit/member/mypageController?action=" method="post">
			<table id="myInfo_table">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" id="sellerId" name="sellerId" value="${seller.sellerId }" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" id="sellerPw" name="sellerPw" value="${seller} }">
						<input id="infoUpdateBtn" type="button" value="비밀번호 변경">
					</td>		
				</tr>
				<tr>
					<th>이름</th>	
					<td>
						<input type="text" id="name" name="name" value="${seller}">
					</td>	
				</tr>
				<tr>
					<th>사업자등록번호</th>	
					<td>
						<input type="text" id="sellerNo" name="sellerNo" value="${seller}">
					</td>	
				</tr>
				<tr>
					<th>상점명</th>	
					<td>
						<input type="text" id="shopName" name="shopName" value="${seller}">
					</td>	
				</tr>
				<tr>
					<th>상점연락처</th>	
					<td>
						<input type="text" id="shopMobile" name="shopMobile" value="${seller}">
					</td>	
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>
						<input type="text" id="mobile" name="mobile" value="${seller}">
					</td>		
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" id="email" name="email" value="${seller}">
					</td>		
				</tr>
				<tr>
					<th>가입일자</th>	
					<td>
						<input type="text" id="entryDate" name="entryDate" value="${seller}" readonly="readonly">
					</td>	
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" id="postno" name="postno" value="${seller}">
					</td>		
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" id="addrss" name="addrss" value="${seller}">
					</td>		
				</tr>
				<tr>
					<th>상세주소</th>
					<td>
						<input type="text" id="addrssDetail" name="addrssDetail" value="${seller}">
					</td>		
				</tr>
				<tr>
					<th>등급</th>	
					<td>
						<input type="text" id="grade" name="grade" value="${seller}" readonly="readonly">
					</td>	
				</tr>
				<tr>
					<th>주요제품</th>	
					<td>
						<input type="text" id="shopCategoryNo" name="shopCategoryNo" value="${seller}">
					</td>	
				</tr>
				<tr>
					<th>카카오톡아이디</th>	
					<td>
						<input type="text" id="shopKaKaoId" name="shopKaKaoId" value="${seller}">
					</td>	
				</tr>
				<tr>
					<th>상점구역코드</th>	
					<td>
						<input type="text" id="shopLocCode" name="shopLocCode" value="${seller}" readonly="readonly">
					</td>	
				</tr>
			</table>
		</form>
		<div id="sellerInfo_btn">
				<input id = "mypage_btn" class="inline" type="button" value="홈으로 이동" onclick="location.href='/takeit/member/index.jsp'">
				<input id = "mypage_btn" class="inline" type="button" value="내 정보 수정하러가기" onclick="location.href='/takeit/member/myInfoUpdate.jsp'">
		</div>
	</div>



</div>


</div>
 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>