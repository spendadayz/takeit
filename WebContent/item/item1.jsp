<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Take it</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/item.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
	<!-- 상단 메뉴 -->
	<c:if test="${empty memberId }">
		<!-- 로그인 전 메뉴 -->
		<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
	</c:if>
	<c:if test="${not empty memberId }">
		<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>
	</c:if>
	<!-- logo.jsp 삽입 -->
	<jsp:include page="/common/logo.jsp"></jsp:include>
	<!-- 네비게이션 -->
	<jsp:include page="/common/navigation.jsp"></jsp:include>

	<form>
		<div id="enroll_total">
			<div style="display: flex;">
				<div style="width: fit-content;">
					<img alt='소불고기' src="/takeit/img/item/item1.jpg" width="450"
						height="320">

				</div>

				<div id="meat_div" style="width: fit-content;">
					<h1>[일상味소]불고기 200g(냉장)</h1>
					<div>
						<span style="color: red"> 5,525원 </span> <span> (35%할인) </span>
						&emsp;&emsp;&emsp; <span> 소비자
							권장소매가: </span> <span> 8,500원 </span>
					</div>
					<hr class="line1">
					<div>
						<span> 카테고리 </span> &nbsp; <span> 고기류</span>
					</div>
					<div>
						<span> 판매단위 </span> &nbsp; <span> 200g </span>
					</div>
					<div>
						<span> 재고량 </span> &nbsp; <span> 7 </span>
					</div>
					<div>
						<span> 원산지</span> &nbsp; <span>호주 </span>
					</div>
					<div>
						<span> 포장타입 </span>&nbsp; <span>냉장포장</span>
					</div>
					<div>
						<span> 판매자</span> &nbsp; <span> 임우진 </span>
					</div>
					<div>
						<span> 고객평점 </span> &nbsp; <span> 9.8점 </span>
					</div>
					<div>
						<span> 등록일자 </span> &nbsp; <span> 2021-05-02 </span>
					</div>
				</div>

			</div>

		</div>

		<div id="signup" align='center'>
			<input type="submit" name="buy" id="buy" value="바로 구매"> <input
				type="submit" name="cart" id="cart" value="장바구니">
		</div>
	</form>

</body>
</html>