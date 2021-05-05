<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 폼</title>
</head>
<body>

<form action="${CONTEXT_PATH}/order/orderController?action=order" method="post">
	<input type="submit" value="결제하기"/>
</form>

</body>
</html>