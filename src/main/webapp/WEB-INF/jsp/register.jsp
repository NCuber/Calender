<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th colspan=2> 회원 가입 <Form Action="registercheck" Method = "post"> </th></tr>
	
		<tr><td> 이메일 </td><td> <input Type = "Text" Name ="Email" size=20> </td></tr>
		<tr><td> 이름 </td><td> <input Type = "Text" Name ="Name" size=20> </td></tr>
		<tr><td> 비밀번호 </td><td> <input Type = "PassWord" Name ="Password" size=20> </td></tr>
		<tr><td> 비밀번호 확인 </td><td> <input Type = "PassWord" Name ="ConfirmPassword" size=20> </td></tr>
		<tr><td> 전화번호 </td><td> <input Type = "Text" Name ="Phone" size=20> </td></tr>
		<tr><td> 주소 </td><td> <input Type = "Text" Name ="Address" size=20> </td></tr>
		<tr><td></td><td><Input Type ="Submit" Value="회원가입"> / <Input Type ="button" Value="닫기" onclick="window.close()"></td></tr>
		
	</Form>
</table>
</body>
</html>