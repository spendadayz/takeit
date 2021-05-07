<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.MessageEntity" %>


<%@ include file="/common/taglib_menu.jsp" %> 
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">


<title>인덱스</title>
</head>
<body>

          <a href="/takeit/item/itemController?action=enrollItemForm">상품등록</a>
      
		 <a href="/takeit/item/itemController?action=itemList">상품전체조회</a>

		<a href="/takeit/item/reviewController?action=enrollReviewForm">후기등록</a>
	 
		 <a href="/takeit/item/reviewController?action=reviewList">후기전체조회</a>
		
		 <a href="/takeit/item/reviewController?action=myReviewList">내가 쓴 후기조회</a>
		
		<a href="/takeit/item/itemController?action=myitemList">판매자 등록 상품보기 </a>
			
	
		
		
</body>
</html>