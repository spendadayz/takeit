<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/link.css">
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/member/input.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${CONTEXT_PATH}/js/member/input.js"></script>
<!-- 우편번호 api -->
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
<!-- 인증번호 팝업 -->
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

<table>
		<tr>
			<td align="center">
				일반 <input type="radio" id="normalInputFrom" name="normalInputFrom" />
				판매자 <input type="radio" id="sellerInputForm" name="sellerInputForm" checked="checked"/>
			</td>
		</tr>
</table>
<form action="${CONTEXT_PATH}/seller/controller?action=sellerInput" method="post" enctype="multipart/form-data">
<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합" id="sellerId" name="sellerId" />
				<input type="button" value="중복확인" id="id_button" onclick="idCheckSellerSeller()"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="sellerIdResult1" class="inputResult"></span>
				<span id="sellerIdResult2" class="inputResult"></span>
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" placeholder="비밀번호를 입력해주세요" id="sellerPw" name="sellerPw" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="sellerPwResult1" class="inputResult"></span>
			</td>
		</tr>
		
		<tr>
			<td>비밀번호 확인</td>
			<td>
				<input type="password" placeholder="비밀번호를 한번 더 입력해주세요" id="pwChk" name="pwChk" />
				<input type="checkbox" id="pwCheckbox" name="pwCheckbox" onclick="pwCheckbox_onclick_seller()"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="pwChkResult1" class="inputResult"></span>
			</td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><input type="text" placeholder="이름을 입력해주세요" id="name" name="name" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="nameResult1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td>휴대폰</td>
			<td>
				<input type="text" id="mobile" placeholder="예:000-00-00000" id="mobile" name="mobile"  />
				<input type="button" value="인증번호" id="mobile_button" name="mobile_button" onclick="mobilePopup();"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="mobileResult1" class="inputResult"></span>
			</td>
		</tr>
		
		<tr>
			<td>인증번호</td>
			<td>
				<input type="text" placeholder="인증번호 선택" id="mobileNum" name="mobileNum"  readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="mobileNumResult1" class="inputResult"></span>
			</td>
		</tr>
		
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" placeholder="예:takeit@take.com" id="email" name ="email" />
				<input type="button" value="중복확인" id="email_button" name="email_button" onclick="emailCheckSeller()"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="emailNumResult1" class="inputResult"></span>
				<span id="emailNumResult2" class="inputResult"></span>
			</td>
		</tr>
		
		<tr>
			<td>우편번호</td>
			<td>
				<input type="text" placeholder="우편번호" id="postNo" name="postNo" readonly="readonly"/>
				<input type="button" id="postNoBtn" name="postNoBtn" onclick="goPopup();" value="우편번호"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="postNoResult1" class="inputResult"></span>
			</td>
		</tr>
			
		<tr>
			<td>도로명주소</td>
			<td>
				<input type="text" placeholder="도로명주소" id="address" name="address" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="addressResult1" class="inputResult"></span>
			</td>
		</tr>
		
		<tr>
			<td>상세주소</td>
			<td>
				<input type="text" placeholder="상세주소" id="addressDetail" name="addressDetail"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="addressDetail1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td>상점구역</td>
			<td>
				<select name="shopLocCode" id="shopLocCode">
					<option value="none">:::선택:::</option>
					<c:forEach var="shopLoc" items="${shopLocList}">
						<option value="${shopLoc.shopLocCode}">${shopLoc.shopLocName }</option>
					</c:forEach>
					
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="shopLocCodeResult1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td>사업자등록번호</td>
			<td><input type="text" placeholder="예:000-00-00000" id="sellerNo" name="sellerNo" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="sellerNoResult1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td>상점연락처</td>
			<td><input type="text" placeholder="상점 연락처를 입력해주세요" id="shopMobile" name="shopMobile" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="shopMobileResult1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td>상점명</td>
			<td><input type="text" placeholder="상점명을 입력해주세요" id="shopName" name="shopName" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="shopNameResult1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td>카카오톡아이디</td>
			<td><input type="text" placeholder="카카오톡 아이디를 입력해주세요." id="shopKakaoId" name="shopKakaoId" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="shopKakaoIdResult1" class="inputResult"></span>
			</td>
		</tr>	

		<tr>
			<td>상점이미지</td>
			<td>
				<input type="file" placeholder="상점 이미지를 등록해주세요." id="shopImg" name="shopImg" />			
					
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="shopImgResult1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td>카테고리</td>
			<td>
				<select name="shopCategoryNo" id="shopCategoryNo">
					<option value="none">:::선택:::</option>
					<option value="1">야채</option>
					<option value="2">과일</option>
					<option value="3">정육</option>
					<option value="4">밑반찬</option>
					<option value="5">쌀</option>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<span id="shopCategoryNoResult1" class="inputResult"></span>
			</td>
		</tr>	
		
		<tr>
			<td colspan="3" align="center"><input type="submit" value="가입하기" id="sellerSubmit" name="sellerSubmit"  onclick="return inputCheck()"/></td>
		</tr>
	</table>
</form>
</div>
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html> 