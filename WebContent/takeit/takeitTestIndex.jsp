<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트용 링크 페이지</title>
</head>
<body>
<div style="text-align: center">
<h1> 테스트용 링크 페이지</h1>
<h3>
	<a href="/takeit/takeit/takeitController?action=takeitItemList">1. 테이크잇상품 리스트</a><br>
	<a href="/takeit/takeit/takeitController?action=test">2. 회원구역 테스트</a><br>
	<a href="/takeit/takeit/takeitController?action=shopLocInputForm">3. 관리자용 상점구역 등록</a><br>
	<a href="/takeit/takeit/takeitController?action=takeitInputForm">4. 관리자용 잇거래 등록</a><br>
	<a href="/takeit/order/order.jsp">5. 결제하기</a><br>
	<a href="/takeit/order/orderController?action=sellerOrderList">6. 판매자 판매내역조회</a><br>
</h3>
</div>
</body>
</html>
