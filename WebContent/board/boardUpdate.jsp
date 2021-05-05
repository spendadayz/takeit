<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.takeit.model.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::공지사항 작성 페이지</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/board.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<style type="text/css">
	table, tr, th,td {
		border: solid 1px #8D959C;
		margin: 0 auto;
		border-collapse: collapse;
		padding: 5px;
		width: 1050px;
		margin-top: 30px;
		margin-bottom: 20px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		if(	$("#boardCategory option:selected").val() != '3'){
			$("#itemNo").val(null);
			$("#itemNo").attr("readonly",true);
		} else {
			$("#itemNo").attr("readonly",false);
		}
		
		$("#cancle").on("click", function(){
			history.back();
		})
	});
	
</script>
</head>
<body>
<!-- 상단 메뉴 -->
<c:if test="${empty memberId and empty sellerId}">
	<!-- 로그인 전 메뉴 -->
	<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
</c:if>
<c:if test="${not empty memberId or not empty sellerId}">
	<!-- 로그인 후 메뉴 -->
	<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
</c:if>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>
<br>
<h1 style="width:fit-content; margin: 0 auto;">게시글 수정</h1>
<br>
<%
	Board dto = (Board)request.getAttribute("board");
%>
<form action="/takeit/boardController?action=boardUpdate&boardNo=<%= dto.getBoardNo() %>" method="post">
<table>
	<tr>
		<th>글번호</th>
		<td colspan="3"><%= dto.getBoardNo() %></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td><input type="text" name="boardTitle" value="<%= dto.getBoardTitle() %>"> </td>
		<th>카테고리</th>
		<td>
			<select id="boardCategory" name="boardCategory">
		<%
			ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("category");
			for(Category category : categoryList){
		%>
			<option value="<%= category.getCategoryNo() %>"><%= category.getCategoryName() %></option>
		<% } %>
			</select>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="boardWriter" value="${memberId }" readonly="readonly"></td>
		<th >상품번호</th>
		<td><input type="text" id="itemNo" name="itemNo" value="<%= dto.getBoardItem() %>"></td>
	</tr>
	<tr>
		<th colspan="4">내용</th>
	</tr>
	<tr>
		<td colspan="4">
			<textarea rows="30" cols="100" name="boardContents"> <%= dto.getBoardContents() %> </textarea>
		</td>
	</tr>
</table>
<input type="submit" value="변경" class="link">
</form>
<div id="cancle" class="link">취소</div>
</body>
</html>