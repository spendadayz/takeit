<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!-- 마이페이지 -> 일반회원 전용 메뉴  -->

<div class="myPage_menu_aside">
		<h3 class="active"> 마이페이지</h3>
	<ul>
		<li><a href="/takeit/cartController?action=cartList">장바구니</a></li>
		<li><a href="/takeit/order/orderController?action=memberOrderList">내 주문내역 조회</a></li>
		<li><a href="/takeit/member/mypageController?action=memberInfoForm">내 정보 조회</a></li>
		<li><a href="/takeit/member/mypageController?action=removeMemberForm">회원 탈퇴</a></li>
		<li><a href="/takeit/item/reviewController?action=myReviewList">내가 등록한 후기조회</a></li>
	</ul>
	
	<c:if test="${not empty dto and dto.grade == 'A'}">
		<h3 class="active"> 잇거래</h3>
		<ul>
			<li><a href="${CONTEXT_PATH}/takeit/takeitController?action=shopLocInputForm">지역시장 등록</a></li>
			<li><a href="${CONTEXT_PATH}/takeit/takeitController?action=takeitInputForm">잇거래 등록</a></li>
		</ul>
	</c:if>
	
	
	<c:if test="${not empty dto and dto.grade == 'A'}">
		<h3 class="active"> 회원관리</h3>
		<ul>
			<li><a href="${CONTEXT_PATH}/member/mypageController?action=sellerList">판매자 회원 목록</a></li>
			<li><a href="${CONTEXT_PATH}/member/mypageController?action=memberList">일반 회원 목록</a></li>			
		</ul>
	</c:if>
</div>