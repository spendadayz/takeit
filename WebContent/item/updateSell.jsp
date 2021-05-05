<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자등록상품</title>
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

<h3 align="center">내 등록상품 조회</h3>
	<div align='center'>
	<form action ="/takeit/item/itemController?action=setSellItem" method="post">
		<table id="updateSEll_table" id="updateSEll_table">



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
			

		<tr>
		   <td colspan="2" align="center">
			 <br><input type="submit" value="상품수정">
			     <input type="submit" value="취소">
			</td>
		</tr>
	</table>
</form>
	<div id="home_btn">
			<br><input id = "home_btn"  type="button" value="홈으로 이동" onclick="location.href='/takeit/index.jsp'">
	</div>
</div>
</div>

 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>
 
