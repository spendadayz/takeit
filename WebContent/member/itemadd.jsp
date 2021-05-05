<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ include file="/common/taglib_menu.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/itemadd.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
	<!-- 상단 메뉴 -->
<c:choose>
	<c:when test="${empty seller.sellerId or empty seller.grade}">
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
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>

	<h3 align="center">판매상품 등록</h3>
	<div align='center'>
	  <form action="/takeit/member/mypageController?action=itemadd" method="post" enctype="multipart/form-data"> 
		<table class="itemadd_table" id="itemadd_table">
	
			<tr>
				<th>상품</th>
				<td><input type="text" id="itemName" name="itemName"  placeholder="상품명" required="required">
				</td>
			</tr>
			
			<tr>
				<th>판매가</th>
				<td><input type="text" id="itemPrice"  name="itemPrice"  placeholder="판매가" required="required">
				</td>
			</tr>
			<tr>
				<th>판매단위</th>
				<td><input type="text" id="salesUnit" name="salesUnit"  placeholder="판매단위" >
				</td>
			</tr>
			<tr>
				<th>상품카테고리이름</th>
				<td>
					<select id="itemCategoryNo" name="itemCategoryNo" style="width: 100px;" required="required">
						
					<c:if test="${categoryList != null}"> 	
				<c:forEach items="${categoryList }" var="list">
							<option value ="${list.itemCategoryNo }">${list.itemCategoryName }</option>
					</c:forEach>
					</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<th>재고량</th>
				<td><input type="text" id="itemStock" name="itemStock"  placeholder="재고량" required="required">
				</td>
			</tr>
          

			<tr>
				<th>원산지</th>
				<td><input type="text" id="itemOrigin" name="itemOrigin"  placeholder="원산지" required="required">
				</td>
			</tr>

			
			<tr>
				<th>상품이미지</th>
				<td><input type="file" name="itemImg" placeholder="상품이미지">
				</td>
			</tr>
	

			<tr>
				<th>잇거래여부</th>
				<td><select  id ="itemTakeit" name ="itemTakeit" required="required">
						<option value="">==잇거래 여부==</option>
						<option value="T">등록</option>
						<option value="F">등록안함</option>
				</select></td>
			</tr>
			
				
			<tr>
				<th>판매자</th>
				<td><input type="text" id="sellerId" name="sellerId"  placeholder="판매자" value="${seller.sellerId }">
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input class="itemaddBtn" type="reset" value="취소">
					<input class="itemaddBtn" type="submit" value="상품등록">
				</td>
			</tr>
		</table>
	<br></form>
		
	</div>
	<!-- scroll function -->
	<jsp:include page="/common/back_to_top.jsp"></jsp:include>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
