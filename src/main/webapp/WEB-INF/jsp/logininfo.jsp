<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head> 
<body>

이메일 :  ${user.email} <br><br>
이름 : ${user.name} <br><br>
전화번호 : ${user.phone} <br><br>
주소 : ${user.address} <br><br>
가입일 : ${user.regdate} <br><br>

<center><button type="button" id="button" onclick="location='modifyuser'"> 수정  </button>　　
<Input Type ="button" Value="닫기" onclick="window.close()"></center>

</body>
</html>