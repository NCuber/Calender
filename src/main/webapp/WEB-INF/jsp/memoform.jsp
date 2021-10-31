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
<Form Action="memowrite" method="post" enctype="multipart/form-data">
<td colspan = 4>작성일 : ${date}
</td>
</tr><tr>
<td colspan = 4>중요도 : <input type='radio' name='important' value=true> 매우 중요하다.
</td>
</tr>
<tr>
<td colspan = 4>
<textarea name="value" rows="4" cols="50">작성할 메모를 입력해주세요</textarea>
	
</td>
</tr>
<tr></tr><td colspan = 4>

<input multiple="multiple" type=file id="file" name="file">
</td><tr>
<td> <Input Type ="Submit" Value="작성">　
<Input Type ="button" Value="닫기" onclick="window.close()"> </td>
</tr>
</table>
</Form>
</body>
</html>