<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">


#button{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  width:350px;
  height:60px;
  font-size:2em;
  font-weight:bold;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
#button:hover{
  background:#fff;
  color:#1AAB8A;
}
#button:before, #button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
#button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
#button:hover:before, #button:hover:after{
  width:100%;
  transition:800ms ease all;
}
</style>
</head>
<body>

<button type="button" id="button" onclick="location='memo'"> 메　모  </button><br>
<button type="button" id="button" onclick="location='calender'"> 캘린더 </button>
</body>
</html>