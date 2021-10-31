<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<button type="button" id="button" onclick="window.open('/midtermfinal/calenderform','_blank', 'width=400, height=300')">일정 작성</button><br>
<button type="button" id="button" onclick="location='/midtermfinal/calender?complete=true'">미완료 일정</button>
<Form Action="calender" Method = "get">
단어검색<br> 
	<input Type = "Text" Name ="word" size=10>
	<Input Type ="Submit" Value="검색">

</Form>

</body>
</html>
