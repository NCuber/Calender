<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table style="padding:3px">
<tr>
<Form Action="modifydcalender" method="post">
<input type=hidden name="key" value=${calender.id}>
<td colspan = 4>시작일 : <input Type = "Text" Name ="sdate" size=20 value= ${calender.sdate}>
</td>
</tr><tr>
<td colspan = 4>종료일 : <input Type = "Text" Name ="edate" size=20 value= ${calender.edate}>
</td></tr>
<tr>
<td colspan = 4>
<textarea name="value" rows="4" cols="50">${calender.value}</textarea>
	
</td>
</tr>
<tr></tr><tr>
<td> <Input Type ="Submit" Value="작성">　
<Input Type ="button" Value="닫기" onclick="window.close()"> </td>
</tr>
</table>
</Form>
</body>
</html>