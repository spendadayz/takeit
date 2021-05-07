<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 error</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
</head>
<body>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<div class="view-width">
<h3 class="warningMessage">경고!</h3>
<img alt="오류" id="warning" src="/takeit/img/icon/warning-sign.png">
<pre id="warningInfo">
죄송합니다.
요청하신 페이지를 찾을 수 없습니다.
입력하신 주소가 정확한지 다시 한 번 확인해주시기 바랍니다.
기타 문의사항을 남겨주시면 빠르게 처리하겠습니다.
</pre>
<a href="/takeit/index" class="link">홈으로 이동</a>
</div>
</body>
</html>