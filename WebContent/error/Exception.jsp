<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 페이지</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
</head>
<body>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<h3 class="warningMessage">경고!</h3>
<h5 class="warningMessage"><%= exception.getClass().getName() %></h5>
<img alt="오류" id="warning" src="/takeit/img/icon/warning-sign.png">
<pre id="warningInfo">
죄송합니다.
서버에서 오류가 발생했습니다.
문의사항을 남겨주시면 빠르게 처리하겠습니다.
</pre>
<a href="/takeit/index.jsp" class="link">홈으로 이동</a>
</body>
</html>