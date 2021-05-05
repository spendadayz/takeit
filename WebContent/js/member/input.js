$(document).ready(function() {
		
	/* 일반회원 시작 */
	/* 아이디 포커스 */
	$("#memberId").focus();
	
	$("#memberId").on('focus', function() {
		$("#memberId").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 아이디 포커스 아웃 */
	$("#memberId").on('focusout', function() {
		
		$("#memberId").css({
			'background' : "white"
		});

		var memberId = $("#memberId").val();
		var memberId_Valid = memberId_data(memberId)
		if(memberId_Valid) {
			$('#memberId_result').hide();	
			//$('#memberId_result').show().html("<h6>사용가능한 아이디입니다</h6>");
		}else {
			$('#memberId_result').show().html("<h6>최소4 ~ 최대12자리 영문+숫자만 사용가능</h6>");
			$('#memberId_result').css('color','red')
		} 
	});

	/* 비밀번호 포커스 */
	$("#memberPw").on('focus', function() {
		$("#memberPw").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 비밀번호 포커스 아웃 */
	$("#memberPw").on('focusout', function() {
		
		$("#memberPw").css({
			'background' : "white"
		});
		
		var memberPw = $("#memberPw").val();
		var memberPw_Valid = memberPw_data(memberPw)
		if(memberPw_Valid) {
			$('#memberPw_result').hide();	
			//$('#memberPw_result').show().html("<h6>사용가능한 비밀번호입니다</h6>");
			event.preventDefault();
		}else {
			$('#memberPw_result').show().html("<h6>최소  4 ~ 최대 12자리, 영문+숫자+특수문자 필수포함</h6>");
			$('#memberPw_result').css('color','red')
		} 
	});
	
	/* 비밀번호 확인 포커스 */
	$("#pwChk").on('focus', function() {
		$("#pwChk").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 비밀번호 확인 포커스 아웃 */
	$("#pwChk").on('focusout', function() {
		$("#pwChk").css({
			'background' : "white"
		});
	});
		
	/* 이름 포커스 */
	$("#name").on('focus', function() {
		$("#name").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 이름 포커스 아웃 */
	$("#name").on('focusout', function() {
		$("#name").css({
			'background' : "white"
		});
	});
	
	/* 이메일 포커스 */
	$("#email").on('focus', function() {
		$("#email").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 이메일 포커스 아웃 */
	$("#email").on('focusout', function() {
		$("#email").css({
			'background' : "white"
		});
	});

	/* 휴대폰 포커스 */
	$("#mobile").on('focus', function() {
		$("#mobile").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 휴대폰 포커스 아웃 */
	$("#mobile").on('focusout', function() {
		$("#mobile").css({
			'background' : "white"
		});
	});

	/* 인증번호 포커스 */
	$("#mobileNum").on('focus', function() {
		$("#mobileNum").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 인증번호 포커스 아웃 */
	$("#mobileNum").on('focusout', function() {
		$("#mobileNum").css({
			'background' : "white"
		});
	});
	
	/* 우편번호 포커스 */
	$("#postNo").on('focus', function() {
		$("#postNo").css({
			'background' : "#E8F0FE"
		});
	});
	/* 우편번호 포커스 아웃 */
	$("#postNo").on('focusout', function() {
		$("#postNo").css({
			'background' : "white"
		});
	});
	
	/* 주소 포커스 */
	$("#address").on('focus', function() {
		$("#address").css({
			'background' : "#E8F0FE"
		});
	});
	/* 주소 포커스 아웃 */
	$("#address").on('focusout', function() {
		$("#address").css({
			'background' : "white"
		});
	});

	/* 상세주소 포커스 */
	$("#addressDetail").on('focus', function() {
		$("#addressDetail").css({
			'background' : "#E8F0FE"
		});
	});
	/* 상세주소 포커스 아웃 */
	$("#addressDetail").on('focusout', function() {
		$("#addressDetail").css({
			'background' : "white"
		});
	});

	/* 생년월일 포커스 */
	$("#brith").on('focus', function() {
		$("#brith").css({
			'background' : "#E8F0FE"
		});
	});
	/* 생년월일 포커스 아웃 */
	$("#brith").on('focusout', function() {
		$("#brith").css({
			'background' : "white"
		});
	});
	/* 일반회원 끝 */

	/* 판매자회원 시작*/
	/* 아이디 포커스 */
	$("#sellerId").on('focus', function() {
		$("#sellerId").css({
			'background' : "#E8F0FE"
		});
	});
	/* 아이디 포커스 아웃*/
	$("#sellerId").on('focusout', function() {
		$("#sellerId").css({
			'background' : "white"
		});
	});

	/* 비밀번호 포커스 */
	$("#sellerPw").on('focus', function() {
		$("#sellerPw").css({
			'background' : "#E8F0FE"
		});
	});
	/* 비밀번호 포커스 아웃*/
	$("#sellerPw").on('focusout', function() {
		$("#sellerPw").css({
			'background' : "white"
		});
	});

	/* 비밀번호확인 포커스 */
	$("#sellerPw_chk").on('focus', function() {
		$("#sellerPw_chk").css({
			'background' : "#E8F0FE"
		});
	});
	/* 비밀번호확인 포커스 아웃*/
	$("#sellerPw_chk").on('focusout', function() {
		$("#sellerPw_chk").css({
			'background' : "white"
		});
	});
	
	/* 사업자등록번호 포커스 */
	$("#sellerNo").on('focus', function() {
		$("#sellerNo").css({
			'background' : "#E8F0FE"
		});
	});
	/* 사업자등록번호 포커스 아웃*/
	$("#sellerNo").on('focusout', function() {
		$("#sellerNo").css({
			'background' : "white"
		});
	});
	
	/* 싱잠연락처 포커스 */
	$("#shopMobile").on('focus', function() {
		$("#shopMobile").css({
			'background' : "#E8F0FE"
		});
	});
	/* 싱잠연락처 포커스 아웃*/
	$("#shopMobile").on('focusout', function() {
		$("#shopMobile").css({
			'background' : "white"
		});
	});
	
	/* 싱잠명 포커스 */
	$("#shopName").on('focus', function() {
		$("#shopName").css({
			'background' : "#E8F0FE"
		});
	});
	/* 상점명 포커스 아웃*/
	$("#shopName").on('focusout', function() {
		$("#shopName").css({
			'background' : "white"
		});
	});
	
	/* 카카오톡아이디 포커스 */
	$("#shopKakaoId").on('focus', function() {
		$("#shopKakaoId").css({
			'background' : "#E8F0FE"
		});
	});
	/* 카카오톡아이디 포커스 아웃*/
	$("#shopKakaoId").on('focusout', function() {
		$("#shopKakaoId").css({
			'background' : "white"
		});
	});

	/* 상점이미지 포커스 */
	$("#shopImg").on('focus', function() {
		$("#shopImg").css({
			'background' : "#E8F0FE"
		});
	});
	/* 상점이미지 포커스 아웃*/
	$("#shopImg").on('focusout', function() {
		$("#shopImg").css({
			'background' : "white"
		});
	});

	/* 상점카테고리번호 포커스 */
	$("#shopCategoryNo").on('focus', function() {
		$("#shopCategoryNo").css({
			'background' : "#E8F0FE"
		});
	});
	/* 상점카테고리번호 포커스 아웃*/
	$("#shopCategoryNo").on('focusout', function() {
		$("#shopCategoryNo").css({
			'background' : "white"
		});
	});
	/* 판매자회원 끝*/
	
 /* 아이디 : 생략불가, 중복불가,  최소  4 ~ 최대 12자리, 영문+숫자만 사용가능*/
 function memberId_data(take) {
 	var pattern = new RegExp(/^[a-zA-Z0-9]{4,12}$/);
 	return pattern.test(take);
 }

 /* 비밀번호 : 생략불가, 최소  4 ~ 최대 12자리, 영문+숫자+특수문자 필수포함*/
 function memberPw_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
 }

 /* 비밀번호 재확인 : 생략불가, 비밀번호와 값이 일치해야함 */
 function memberPw2_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
 }
 
 /* 비밀번호 표시 */
 function pwCheckbox_onclick() {
		
	var pwCheckboxElement = document.getElementById("pwCheckbox")
	var memberPwElement = document.getElementById("memberPw")
	var pwChk_Element = document.getElementById("pwChk")
	
	if(pwCheckboxElement.checked) {
		memberPwElement.type = "text"
		pwChk_Element.type = "text"
	}else {
		memberPwElement.type = "password"
		pwChk_Element.type = "password"
	}
}

});
