<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table border=1>
<tr>
<td>  <jsp:include page="loginstate.jsp"></jsp:include>	</td>
<td colspan=3 rowspan=4> <jsp:include page="calendermain.jsp"></jsp:include> </td>
</tr><tr>
<td><jsp:include page="mainmenu.jsp"></jsp:include></td>
</tr><tr>
<td><jsp:include page="calendermenu.jsp"></jsp:include></td>
</tr><tr>
<td><jsp:include page="calenderdaluck.jsp"></jsp:include></td>
</tr>

</table>

</body>
</html>
