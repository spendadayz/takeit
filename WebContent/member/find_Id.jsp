<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기 페이지</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="/takeit/js/slide.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#header").load("../common/header.jsp")
	$("#footer").load("../common/footer.jsp")
});
</script>
<style>
	#contents_box {	
		margin: auto;
	}
		
	#contents_box > table {		
		font-size: 9px;
	}
		
	#check_submit{
		width:100%;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		background-color: #7B977A;
		color: white;
		border: 1px solid #7B977A;
	}
		
	#name{
		width:250px;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		border: 1px solid #7B977A;
	}
	
	#email{
		width:250px;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		margin-bottom: 10px;
		border: 1px solid #7B977A;
	}

</style>
</head>
<body>

<div id="header"><h1>header</h1></div>

<div id="contents_box" align="center">
<h3>아이디 찾기</h3>
<table>
	<tr>
		<td>이름</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="고객님의 이름을 입력해주세요" id="name"/></td>
	</tr>
	<tr>
		<td>이메일</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="가입 시 등록하신 이메일 주소를 입력해주세요" id="email"/></td>
	</tr>
	
	<tr>
		<td><input type="submit" value="찾기" id="check_submit"/></td>
	</tr>
</table>
</div>
</body>
</html> 