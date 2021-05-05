<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 등록</title>
</head>
<body>
<h3>잇거래 등록</h3>


<form action="${CONTEXT_PATH}/takeit/takeitController?action=takeitInput" method="post">
	<table>
		<td>상점구역선택</td>
		<td>
		<select id="shopLocCode" name="shopLocCode">
			<c:forEach items="${shopLocList}" var="shopLoc">
				<option value="${shopLoc.shopLocCode}">${shopLoc.shopLocName}</option>
			</c:forEach>
		</select>
		</td>	
		<tr>
			<td>모집금액</td>
			<td><input type="number" required="required" name="takeitPrice" />
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록"/>
				<input type="reset" value="초기화"/>
			</td>
		</tr>
	</table>
</form>


</body>
</html>