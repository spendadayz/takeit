<%@page import="com.takeit.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script type="text/javascript">
        //인증번호받기
        function getMobileNum(){
            document.getElementById("send").value = <%= Utility.getSecureNumber(6)%>
        }

        //전달하기
        function getParentText(){
            opener.document.getElementById("mobileNum").value =  document.getElementById("send").value;
            window.close();
        }
</script>
</head>


<body>
	<table>
		<tr>
			<td>
			    <input type="text" id="send"> <input type="button" value="전달하기" onclick="getParentText()"><br>
			</td>
			<td>
		    	<input type="button" value="인증번호받기" onclick="getMobileNum()">
			</td>
		</tr>
	</table>
</body>
</html>

