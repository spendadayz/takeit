<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/link.css">
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/member/find.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${CONTEXT_PATH}/js/member/find.js"></script>
<script type="text/javascript">
function mobilePopup() {
     // window.name = "부모창 이름"; 
     window.name = "parentForm";
     // window.open("open할 window", "자식창 이름", "팝업창 옵션");
     window.open("${CONTEXT_PATH}/member/mobilePopup.jsp",
             "childForm", "width=570, height=350, resizable = no, scrollbars = no");    
}
</script>
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

<!--내용 -->
<div id="contents_box" align="center">
<h1>비밀번호 찾기</h1>
<form action="${CONTEXT_PATH}/seller/controller?action=sellerFindPw" method="post">
<table>
	<tr>
		<td>아이디</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="고객님의 아이디를 입력해주세요" id="sellerId" name="sellerId" required="required"/></td>
	</tr>
	<tr>
		<td>이름</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="고객님의 이름을 입력해주세요" id="name" name="name" required="required"/></td>
	</tr>
	<tr>
		<td>이메일</td>
	</tr>
	<tr>
		<td>
			<input type="text" placeholder="가입 시 등록하신 이메일 주소를 입력해주세요" id="email" name="email" required="required"/>
			<input type="button" value="인증번호" id="mobile_button" name="mobile_button" onclick="mobilePopup();"/>
		</td>
	</tr>
	<tr>
		<td>인증번호</td>
	</tr>
	<tr>
		<td>
			<input type="text" placeholder="인증번호 입력" id="mobileNum" name="mobileNum"  required="required" readonly="readonly"/>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="찾기	" id="check_submit"/></td>
	</tr>
</table>
</form>
</div>
</body>
</html> 