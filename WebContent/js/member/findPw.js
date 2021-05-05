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

	/* 이름 포커스 */
	$("#name").on('focus', function() {
		$("#name").css({
			'background' : "#E8F0FE"
		});
	});
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
	$("#email").on('focusout', function() {
		$("#email").css({
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
	
});