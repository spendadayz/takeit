<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 마이페이지 -> 일반회원 전용 메뉴  -->

<div class="myPage_menu_aside">
		<h3 class="active" >마이페이지</h3>
	<ul>
		<li><a href="/takeit/cartController?action=cartList">장바구니</a></li>
		<li><a href="/takeit/member/myPage.jsp">내 주문내역 조회</a></li>
		<li><a href="/takeit/member/mypageController?action=memberInfoForm">내 정보 조회</a></li>
		<li><a href="/takeit/member/mypageController?action=removeMemberForm">회원 탈퇴</a></li>
	</ul>
</div>