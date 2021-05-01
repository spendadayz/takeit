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
	$("#memberPw_chk").on('focus', function() {
		$("#memberPw_chk").css({
			'background' : "#E8F0FE"
		});
	});	
	/* 비밀번호 확인 포커스 아웃 */
	$("#memberPw_chk").on('focusout', function() {
		$("#memberPw_chk").css({
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

	/* 생년월일 포커스 */
	$("#entryDate").on('focus', function() {
		$("#entryDate").css({
			'background' : "#E8F0FE"
		});
	});
	/* 생년월일 포커스 아웃 */
	$("#entryDate").on('focusout', function() {
		$("#entryDate").css({
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
	$("#shop_mobile").on('focus', function() {
		$("#shop_mobile").css({
			'background' : "#E8F0FE"
		});
	});
	/* 싱잠연락처 포커스 아웃*/
	$("#shop_mobile").on('focusout', function() {
		$("#shop_mobile").css({
			'background' : "white"
		});
	});
	
	/* 싱잠명 포커스 */
	$("#shop_name").on('focus', function() {
		$("#shop_name").css({
			'background' : "#E8F0FE"
		});
	});
	/* 상점명 포커스 아웃*/
	$("#shop_name").on('focusout', function() {
		$("#shop_name").css({
			'background' : "white"
		});
	});
	
	/* 카카오톡아이디 포커스 */
	$("#kakao_id").on('focus', function() {
		$("#kakao_id").css({
			'background' : "#E8F0FE"
		});
	});
	/* 카카오톡아이디 포커스 아웃*/
	$("#kakao_id").on('focusout', function() {
		$("#kakao_id").css({
			'background' : "white"
		});
	});

	/* 상점이미지 포커스 */
	$("#shop_img").on('focus', function() {
		$("#shop_img").css({
			'background' : "#E8F0FE"
		});
	});
	/* 상점이미지 포커스 아웃*/
	$("#shop_img").on('focusout', function() {
		$("#shop_img").css({
			'background' : "white"
		});
	});

	/* 상점카테고리번호 포커스 */
	$("#shop_categoryNo").on('focus', function() {
		$("#shop_categoryNo").css({
			'background' : "#E8F0FE"
		});
	});
	/* 상점카테고리번호 포커스 아웃*/
	$("#shop_categoryNo").on('focusout', function() {
		$("#shop_categoryNo").css({
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
 function memberPw_Chkbox_Onclick() {
		
	var memberPw_ChkboxElement = document.getElementById("memberPw_Chkbox")
	var memberPwElement = document.getElementById("memberPw")
	
	if(memberPw_ChkboxElement.checked) {
		memberPwElement.type = "text"
	}else {
		memberPwElement.type = "password"
	}
}

});
