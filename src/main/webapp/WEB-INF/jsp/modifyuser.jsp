<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head> 
<body>



<table>
<tr><th colspan=2> 회원 정보 수정 <Form Action="modifyd" Method = "post"> </th></tr>
	
		<tr><td> 이메일 </td><td> ${user.email} </td></tr>
		<tr><td> 새 비밀번호 </td><td> <input Type = "PassWord" Name ="PASSWORD" size=20> </td></tr>
		<tr><td> 새 비밀번호 확인 </td><td> <input Type = "PassWord" Name ="CONFIRMPASSWORD" size=20> </td></tr>
		<tr><td> 이름 </td><td>  ${user.name} </td></tr>
		<tr><td> 전화번호 </td><td> <input Type = "Text" Name ="PHONE" size=20 value= ${user.phone} > </td></tr>
		<tr><td> 주소 </td><td> <input Type = "Text" Name ="ADDRESS" size=20 value=${user.address}> </td></tr>
		<tr></tr><tr><td></td><td><Input Type ="Submit" Value="수정"> / <Input Type ="button" Value="닫기" onclick="window.close()"></td></tr>
		
	</Form>
</table>

</body>
</html>