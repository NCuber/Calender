<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>
<script type="text/javascript">

$(function(){
	$.datepicker.setDefaults({ dateFormat: 'yy-mm-dd'});
    $("#date1").datepicker();
    $("#date2").datepicker();

});

</script>

<body>
<table style="padding:3px">
<tr>
<Form Action="calenderwrite" method="post" enctype="multipart/form-data">

<td colspan = 4>시작일 : <input type="text" name="sdate" id="date1" size="20" />
</td>
</tr><tr>
<td colspan = 4>종료일 : <input type="text" name="edate" id="date2" size="20" />
</td></tr>
<tr>
<td colspan = 4>
<textarea name="value" rows="4" cols="50">해야할 일정을 입력해주세요.</textarea>

	
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