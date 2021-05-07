<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 회원 목록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/myPage.css">
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
<br>

	<h1 style="width:fit-content; margin: 0 auto;">판매자 회원 목록</h1>
	<br>
	<table id="memberList_table">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>사업자등록번호</th>
			<th>상점명</th>
			<th>상점연락처</th>
			<th>평점</th>
			<th>휴대폰</th>
			<th>이메일</th>
			<th>가입일자</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상점구역코드</th>
			<th>카카오톡아이디</th>
			<th>등급</th>
			<th>탈퇴</th>
		</tr>
		<c:forEach var="dto" items="${ sellerList}">
		<tr>
		
			<td>
				${ dto.getSellerId()}
			</td>
			<td>
				${ dto.getSellerPw()}
			</td>
			<td>
				${ dto.getName()}
			</td>
			<td>
				${ dto.getSellerNo()}
			</td>
			<td>
				${ dto.getShopName()}
			</td>
			<td>
				${ dto.getShopMobile()}
			</td>
			<td>
				${ dto.getCustScore()} 점
			</td>
			<td>
				${ dto.getMobile()}
			</td>
			<td>
				${ dto.getEmail()}
			</td>
			<td>
				${ dto.getEntryDate()} 
			</td>
			<td>
				${ dto.getPostNo()}
			</td>
			<td>
				${ dto.getAddress()} ${ dto.getAddressDetail()}
			</td>
			<td>
				${ dto.getShopLocCode()}
			</td>
			<td>
				${ dto.getShopKakaoId()}
			</td>
			<td>
				${ dto.getGrade()}
			</td>
			<td>
				<input type="button" value="탈퇴" id="deleteBtn" onclick="location.href='${CONTEXT_PATH}/member/mypageController?action=AceRemoveSeller&sellerId=${ dto.getSellerId()}&sellerPw=${ dto.getSellerPw()}'">
			</td>
		</tr>
		
		</c:forEach>
	
	</table>

<a href="/takeit/member/myPage.jsp" id="mypage_Btn">마이페이지로 이동</a>




 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>