$(document).ready(function() {
	
	/* 이름 포커스 */
	$("#name").focus();
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
	
});