<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 로그인</title>
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/link.css">
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/member/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${CONTEXT_PATH}/js/member/login.js"></script>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('ef7d648c9d8cef88d6c092d4942eee41'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      scope: 'account_email',
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  const kakao_account = response.kakao_account;
        	  //$("#id").text(response.id);
        	  //("#email").text(response.kakao_account.email);
        	  console.log(response)
        	  
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
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

<!-- 내용 -->
<div id="contents_box" align="center">
<form action="${CONTEXT_PATH}/member/controller?action=memberLogin" method="post">
<table>
	<tr>
		<td align="center">
			일반 <input type="radio" id="normalLoginFrom" name="normalLoginFrom" checked="checked"/>
			판매자 <input type="radio" id="sellerLoginFrom" name="sellerLoginFrom"/>
		</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="고객님의 아이디를 입력해주세요" id="memberId" name="memberId" required="required"/></td>
	</tr>
	<tr>
		<td><input type="password" placeholder="고객님의 비밀번호를 입력해주세요" id="memberPw" name="memberPw" required="required"/></td>
	</tr>
	<tr>
		<td id="find" align="right">
			<a href="memberFindId.jsp">아이디찾기</a>
			<a href="memberFindPw.jsp">비밀번호찾기</a>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="로그인" id="normalLogin"/></td>
	</tr>
	<tr>
		<td><input type="button" value="일반 회원가입" id="inputNormal" name="inputNormal"/></td>
	</tr>
	<tr>
		<td align="center" onclick="kakaoLogin();">
			<a href="javascript:void(0)">
				<img src="/takeit/img/login/kakao_login_medium_narrow.png" alt="" id="kakaoLogin"/>
			</a>
		</td>
		<!-- <td><input type="button" value="카카오 로그인" id="kakaoLogin" onclick="kakaoLogin();"/></td> -->
	</tr>
</table>
<!-- <div>
	회원번호 : <span id ="id"></span><br>
	이메일 : <span id="email"></span><br>
</div> -->
</form>
</div>
</body>
</html> 