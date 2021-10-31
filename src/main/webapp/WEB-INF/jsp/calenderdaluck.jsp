<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css" rel="stylesheet"/>
<link href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css" rel="stylesheet"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>
<meta charset="EUC-KR">
<style type="text/css">
#Daluck{
width:300px;
height:300px;
margin:0 auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
<Form Action="calender" Method = "get">
    <div id="Daluck">
    <script>
        $(function () {
        	$('#Daluck').multiDatesPicker({
        		dateFormat: "yy-mm-dd",
        		maxPicks: 2
        	});
        });
              
        $("form").submit(function() {
			document.getElementById("date").value = document.getElementById("Daluck").value;
        });
    </script>
    <input type="hidden" id="date" name="date"> 
   날짜 <Input Type ="Submit" Value="검색">
    <br>
    </div>
    
    </Form>
    </body>
</html>