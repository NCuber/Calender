<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
  text-align:center;
}
button{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:30px;
  width:150px;
  font-size:1em;
  padding:0 1em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border=1 align=center>
<tr>
<td colspan=3> ${text} </td>
</tr><tr>
<td> <button type="button" onclick="window.open('/midtermfinal/logininfo','_blank', 'width=400, height=300')"> 정보보기 </button> </td>


<td width=25></td>
<td> <button type="button" onclick="location='logout'"> 로그아웃 </button> </td>
</table>
</body>
</html>