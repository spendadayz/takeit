<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품문의</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">

</head>
<body>
<!-- 상단 메뉴 -->
<c:choose>
	<c:when test="${empty memberId or empty grade}">
		<!-- 로그인 전 메뉴 -->
		<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
	</c:otherwise>
</c:choose>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>

	<h3 align="center">1:1문의</h3>
	<div align='center'>
		<table class="ask_table" id="ask_table">

			<tr>
				<td>작성자</td>
				<td><input type="text" name="boardWriter" placeholder="작성자">
				</td>
			</tr>

			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle"
					placeholder="제목을 입력해주세요"></td>
			</tr>

			<tr>
			    <td>문의내용</td>
				<td colspan="2"><textarea name=" boardContents" rows="8"
						cols="70" placeholder="문의하실 내용을 입력해주세요"></textarea></td>
			</tr>

			<tr>
				<td>문의유형</td>
				<td><select onchange="orderTypeChange(value)">
						<option value="">==문의유형을 선택해주세요==</option>
						<option value="">배송지연/불만</option>
						<option value="">반품문의</option>
						<option value="">A/S문의</option>
						<option value="">환불문의</option>
						<option value="">주문결제문의</option>
						<option value="">취소문의</option>
						<option value="">교환문의</option>
						<option value="">상품정보문의</option>
						<option value="">기타문의</option>
						<option value="">교환문의</option>
						<option value="">회원정보문의</option>
				       </select></td>
			  </tr>
		<tr>
				<td>주문상품</td>
				<td><select onchange="orderNoChange(value)">
						<option value="">==주문상품를 선택해주세요==</option>
						<option value="">[서울우유]삼각커피우유 외5건</option>
						<option value="">[테이트]브리또 외2종</option>
						<option value="">[탄단지]가벼운 한식 도시락 외3종</option>
						<option value="">[금미]쌀 떡볶이 외3건</option>
				</select></td>
			</tr>


		</table>
		<br><div id="signup" align='center'>
			<tr>
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</tr>
		</div>
	</div>
	<!-- scroll function -->
	<jsp:include page="/common/back_to_top.jsp"></jsp:include>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
</body>
</html>
