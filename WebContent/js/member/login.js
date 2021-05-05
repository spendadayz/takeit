$(document).ready(function() {
	
	/* 아이디 포커스 */
	$("#memberId").focus();
	$("#memberId").on('focus', function() {
		$("#memberId").css({
			'background' : "#E8F0FE"
		});
	});
	$("#memberId").on('focusout', function() {
		$("#memberId").css({
			'background' : "white"
		});
	});

	/* 비밀번호 포커스 */
	$("#memberPw").on('focus', function() {
		$("#memberPw").css({
			'background' : "#E8F0FE"
		});
	});
	$("#memberPw").on('focusout', function() {
		$("#memberPw").css({
			'background' : "white"
		});
	});

	$("#sellerId").focus();
	$("#sellerId").on('focus', function() {
		$("#sellerId").css({
			'background' : "#E8F0FE"
		});
	});
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
	$("#sellerPw").on('focusout', function() {
		$("#sellerPw").css({
			'background' : "white"
		});
	});

	/* 회원가입 이동 이벤트 */
	$("#inputNormal").click(function() {
		 location.href = "/takeit/member/memberInput.jsp"
	});

	/* 회원가입 이동 이벤트 */
	$("#inputSeller").click(function() {
		location.href = "/takeit/member/sellerInput.jsp"
	});
	
	/* 일반 로그인 이벤트 */
	$("#normalLoginFrom").click(function() {
		 location.href = "/takeit/member/memberLogin.jsp"
	});
	
	/* 판매자 로그인 이벤트 */
	$("#sellerLoginFrom").click(function() {
		location.href = "/takeit/seller/sellerLogin.jsp"
	});
});