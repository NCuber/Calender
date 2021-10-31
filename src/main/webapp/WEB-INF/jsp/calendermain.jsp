<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.ellip {
		text-align:left;
		width:600px;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}

</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div class="ellip" >
	<table>
	
		<c:forEach var="calender" items="${clist}" varStatus="status">
		<tr>
		<td>　<c:if test="${calender.complete}">V</c:if>　</td><td> [${calender.sdate}　~　${calender.edate}]</td><td>　  <a href ="/midtermfinal/calenderinfo?id=${calender.id}" onclick="window.open(this.href,'_blank', 'width=400, height=300'); return false;" href="calender" > ${calender.value}</a> </td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>