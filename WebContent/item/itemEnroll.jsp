<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit2/css/item.css">

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

	<h3 align="center">판매상품 등록</h3>
	<div align='center'>
	  <form name="form1" method="post" enctype="multipart/form-data"> 
		<table class="enroll_table" id="enroll_table">

			<tr>
				<td>상품카테고리이름</td>
				<td><input type="text" name="title" placeholder="상품카테고리이름">
				</td>
			</tr>

			<tr>
				<td>판매자</td>
				<td><input type="text" name="title" placeholder="판매자">
				</td>
			</tr>

			<tr>
				<td>상품</td>
				<td><input type="text" name="title" placeholder="상품번호">
				</td>
			</tr>


			<tr>
				<td>판매가</td>
				<td><input type="text" name="title" placeholder="판매가">
				</td>
			</tr>

			<tr>
				<td>원산지</td>
				<td><input type="text" name="title" placeholder="원산지">
				</td>
			</tr>

			<tr>
				<td>재고량</td>
				<td><input type="text" name="title" placeholder="재고량">
				</td>
			</tr>
          
			<tr>
				<td>상품이미지</td>
				<td><input type="file" name="file1" placeholder="상품이미지">
				</td>
			</tr>
	

			<tr>
				<td>잇거래여부</td>
				<td><select onchange="takeIt">
						<option value="">==잇거래 여부==</option>
						<option value="">True(등록)</option>
						<option value="">False(등록안함)</option>
				</select></td>
			</tr>

			<tr>
				<td>포장타입</td>
				<td><input type="text" name="title" placeholder="포장타입">
				</td>
			</tr>

			<tr>
				<td>유통기한</td>
				<td><input type="text" name="title" placeholder="유통기한">
				</td>
			</tr>

			<tr>
				<td>안내사항</td>
				<td><input type="text" name="title" placeholder="안내사항">
				</td>
			</tr>

			<tr>
				<td>신선도</td>
				<td><input type="text" name="title" placeholder="신선도">
				</td>
			</tr>
			

		</table>
	<br></form>
		<div id="signup" align='center'>
		
			<tr>
				<td><input type="submit" value="상품등록"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</div>
	</div>
	<!-- scroll function -->
	<jsp:include page="/common/back_to_top.jsp"></jsp:include>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
