$(document).ready(function() {
	
	/* 일반 회원가입 버튼 이벤트 */
	$("#nomal_inputForm").click(function() {
		 location.href = "/takeit/member/memberInput.jsp"
	});
	
	/* 판매자 회원가입 버튼 이벤트 */
	$("#seller_inputForm").click(function() {
		location.href = "/takeit/seller/controller?action=sellerInputForm"
	});
});