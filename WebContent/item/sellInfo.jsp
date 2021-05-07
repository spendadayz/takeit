<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자등록상품</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit2/css/item.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/board.css">
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
	<div id="mySell" align='center'>
		<h3 align="center">내 등록상품 조회</h3>

		<form
			action="/takeit/item/itemController?action=setSellItem&itemNo=${item.itemNo}"
			method="post">
			<table id="updateSEll_table" id="updateSEll_table">


				<tr>
					<th>포장타입번호</th>
					<td><input type="text" name="packTypeNo" id="packTypeNo"
						value="${item.packTypeNo }"></td>

					<th>포장타입</th>
					<td><input type="text" name="packTypeName" id="packTypeName"
						value="${item.packTypeName }"></td>

				</tr>

				<tr>
					<th>상품카테고리번호</th>
					<td><input type="text" name="itemCategoryNo"
						id="itemCategoryNo" value="${review.itemCategoryNo }"
						readonly="readonly"></td>

					<th>상품카테고리이름</th>
					<td><input type="text" name="itemCategoryName"
						id="itemCategoryName" value="${item.itemCategoryName }"
						readonly="readonly"></td>
				</tr>

				<tr>
					<th>판매자</th>
					<td><input type="text" name="sellerName" id="sellerName"
						value="${item.sellerName }" readonly="readonly"></td>

					<th>판매가</th>
					<td><input type="text" name="itemNo" id="itemNo"
						value="${item.itemNo }"></td>
				</tr>


				<tr>
					<th>상품번호</th>
					<td><input type="text" name="itemPrice" id="itemPrice"
						value="${item.itemPrice }" readonly="readonly"></td>

					<th>상품명</th>
					<td><input type="text" name="itemName" id="itemName"
						value="${item.itemName }"></td>
				</tr>

				<tr>
					<th>원산지</th>
					<td><input type="text" name="itemOrigin" id="itemOrigin"
						value="${item.itemOrigin }"></td>

					<th>재고량</th>
					<td><input type="text" name="itemStock" id="itemStock"
						value="${item.itemStock }"></td>
				</tr>

				<tr>
					<th>고객평점</th>
					<td><input type="text" name="itemCustScore" id="itemCustScore"
						value="${item.itemCustScore }" readonly="readonly"></td>

					<th>할인율</th>
					<td><input type="text" name="discRate" id="discRate"
						value="${item.discRate }"></td>
				</tr>

				<tr>
					<th>판매단위</th>
					<td><input type="text" name="salesUnit" id="salesUnit"
						value="${item.salesUnit }"></td>

					<th>등록일자</th>
					<td><input type="text" name="itemInputDate" id="itemInputDate"
						value="${item.itemInputDate }" readonly="readonly"></td>
				</tr>

				<tr>
					<th>상품이미지</th>
					<td><input type="file" name="itemImg" id="itemImg"
						value="${item.itemImg }" readonly="readonly"></td>
					<th>안내사항</th>
					<td><input type="text" name="notice" id="notice"
						value="${item.notice }"></td>
				</tr>


				<tr>
					<th>유통기한</th>
					<td><input type="text" name="expirationDate"
						id="expirationDate" value="${item.expirationDate }">
					</td>

					<th>잇거래여부</th>
					<td><select onchange="takeIt" name="itemTakeit"
						id="itemTakeit">
							<option value="">==잇거래 여부==</option>
							<option value="">True(등록)</option>
							<option value="">False(등록안함)</option>
					</select></td>
				</tr>

				<tr>
					<th>신선도</th>
					<td><input type="text" name="freshPercent"
						placeholder="freshPercent" value="${item.freshPercent }">
					</td>

					<th>판매상점</th>
					<td><input type="text" name="shopName" id="shopName"
						value="${item.shopName }"></td>
				</tr>



			</table>
			<div id="small-btn">
				<br> <input class="link" type="submit" value="상품수정">
			</div>
			<div id="small-btn">
				<br> <input class="link" type="submit" value="상품삭제">
			</div>
		</form>

	</div>
	</div>

	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>

