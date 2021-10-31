<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table style="padding:3px">
<tr height="30">
<td colspan = 4>시작일 : ${calender.sdate}
</td>
</tr>
<tr height="30">
<td colspan = 4>종료일 : ${calender.edate}
</td>
</tr>
<tr height="30">
<td colspan = 4>

<c:forEach var="string" items="${value}" varStatus="status">
<c:choose>
<c:when test = "${fn:contains(string,'*file')}"> 

<a href='/midtermfinal/download?name=${string}' >${string}<br></a>
</c:when>
<c:otherwise>
${string}<br>
</c:otherwise>
</c:choose>


</c:forEach>
</td>
</tr>
<tr><td> 완료 여부 : ${calender.complete} </td></tr>





</table>

<center>
<Input Type ="button" Value="완료" onclick="location='calendercomplete?id=${calender.id}'">　　
<Input Type ="button" Value="미완료" onclick="location='calendernotcomplete?id=${calender.id}'">　　
<Input Type ="button" Value="수정" onclick="location='modifycalender?id=${calender.id}'">　　
<Input Type ="button" Value="삭제" onclick="location='calenderdelete?id=${calender.id}'">　　
<Input Type ="button" Value="닫기" onclick="window.close()">
</center> 
</body>
</html>