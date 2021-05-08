<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 내 정보 조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/sellerInfo.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
var goPopup = function() {
	 var pop = window.open("${CONTEXT_PATH}/member/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes");
 } 
var jusoCallBack = function(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo){
	 document.getElementById("postNo").value = zipNo; 
	 document.getElementById("address").value = roadAddrPart1; 
	 document.getElementById("addressDetail").value = addrDetail; 
	 if(addressDetail.length>30){ 
		alert('상세주소를 30자 이내로 입력하세요.'); 
		return; 
	} 
}
</script>
<script type="text/javascript">
function mobilePopup() {
     window.name = "parentForm";
     window.open("${CONTEXT_PATH}/member/mobilePopup.jsp",
             "childForm", "width=570, height=350, resizable = no, scrollbars = no");    
}
</script>
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
<br>
<div id="container" class="view-width">
<div class="side-menu">
<c:choose>
	<c:when test ="${not empty sellerId}">
 		<!-- 판매자 마이페이지 메뉴 -->
 		<jsp:include page="/common/mypage_seller_menu.jsp"/>
	</c:when>
	<c:when test="${not empty memberId}">
		<!-- 일반회원 마이페이지 메뉴 -->
		<jsp:include page="/common/mypage_member_menu.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="/member/memberLogin.jsp"/>
	</c:otherwise>
</c:choose>
</div>
<div class="memberInfo-wrap">
	<h1 style="width:fit-content; margin: 0 auto;">내 정보 조회</h1>
	<br>
	<form action="/takeit/member/mypageController?action=setSellerInfo" method="post">
		<table id="sellerInfo_table">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="sellerId" name="sellerId" value="${seller.sellerId }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" id="sellerPw" name="sellerPw" value="${seller.sellerPw}">
					<input id="memberInfo_button" type="button" value="비밀번호 변경" onclick="location.href='/takeit/member/mypageController?action=memberPwUpdateForm'">
				</td>		
			</tr>
			<tr>
				<th>이름</th>	
				<td>
					<input type="text" id="name" name="name" value="${seller.name}">
				</td>	
			</tr>
			<tr>
				<th>사업자등록번호</th>	
				<td>
					<input type="text" id="sellerNo" name="sellerNo" value="${seller.sellerNo}">
				</td>	
			</tr>
			<tr>
				<th>상점명</th>	
				<td>
					<input type="text" id="shopName" name="shopName" value="${seller.shopName}">
				</td>	
			</tr>
			<tr>
				<th>상점연락처</th>	
				<td>
					<input type="text" id="shopMobile" name="shopMobile" value="${seller.shopMobile}">
				</td>	
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>
					<input type="text" id="mobile" name="mobile" value="${seller.mobile}">
				</td>		
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" id="email" name="email" value="${seller.email}">
				</td>		
			</tr>
			<tr>
				<th>가입일자</th>	
				<td>
					<input type="text" id="entryDate" name="entryDate" value="${seller.entryDate}" readonly="readonly">
				</td>	
			</tr>
			
			<tr>
				<th>상점이미지</th>	
				<td>
				<img id="shopImg" alt="${seller.shopImg}" src="/takeit/img/seller/${seller.shopImg}">
				</td>	
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" placeholder="우편번호 선택" id="postNo" name="postNo" readonly="readonly" value="${seller.postNo }"/>
					<input type="button" id ="memberInfo_button" id="postNoBtn" name="zipNoBtn" onclick="goPopup();" value="우편번호"/>
				</td>
			</tr>
			<tr>
				<th>도로명주소</th>
				<td>
					<input type="text" placeholder="도로명주소" id="address" name="address" readonly="readonly" value="${ seller.address}"/>
				</td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td>
					<input type="text" placeholder="상세주소" id="addressDetail" name="addressDetail" value="${seller.addressDetail }"/>
				</td>
			</tr>			
			<tr>
				<th>등급</th>	
				<td>
					<input type="text" id="grade" name="grade" value="${seller.grade}" readonly="readonly">
				</td>	
			</tr>
			<tr>
				<th>주요제품</th>	
				<td>
					<input type="text" id="shopCategoryNo" name="shopCategoryNo" value="${seller.shopCategoryNo}">
				</td>	
			</tr>
			<tr>
				<th>카카오톡아이디</th>	
				<td>
					<input type="text" id="shopKaKaoId" name="shopKaKaoId" value="${seller.shopKakaoId}">
				</td>	
			</tr>
			<tr>
				<th>상점구역코드</th>	
				<td>
					<input type="text" id="shopLocCode" name="shopLocCode" readonly="readonly" value="${seller.shopLocCode }">
				</td>	
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input class="updateBtn" type="submit" value="내 정보 수정">
				</td>
			</tr>
		</table>
		<br>
	</form>
		<a href="/takeit/member/myPage.jsp" id="mypage_Btn">마이페이지로 이동</a>
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