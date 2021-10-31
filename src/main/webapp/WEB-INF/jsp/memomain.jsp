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
	
		<c:forEach var="memo" items="${mlist}" varStatus="status">
		<tr>
		<td>　<c:choose><c:when test="${memo.important}">★</c:when><c:otherwise>☆</c:otherwise></c:choose></td><td>　 [${memo.date}] </td><td>　  <a href ="/midtermfinal/memoinfo?id=${memo.id}" onclick="window.open(this.href,'_blank', 'width=400, height=300'); return false;" href="memo" > ${memo.value}</a> </td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>