<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<%@include file="../include/nav2.jsp" %> 
<form name="myform" id="myform">
   <input type="hidden" name="idcheck" id="idcheck" value="N"/>
   
<div class="container" style="margin-top:80px; width:60%">
  <h1>아이디찾기</h1>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="이메일" name="email" id="email">
  </div>

  <div class="input-group mb-3">
    <input type="text" class="form-control" name="phone" id="phone" placeholder="전화번호">
  </div>

  
     <div class="container" style="text-align:right">
    
     <div class="btn-group">
       
       <button type="button" class="btn btn-primary" onclick="goFindId()">아이디찾기</button>&nbsp;&nbsp;
       <button type="button" class="btn btn-primary" onclick="goCancel()">취소</button>&nbsp;&nbsp;
     </div>
     
   </div>
    
    <div class="input-group mb-3">
     	<div id="result"> </div>
    </div>
</div>

</form>   

</body>
</html>

<script>

function goFindId()
{
   var frmData = new FormData(document.myform);
   console.log( frmData );
       
   $.ajax({
      url:"${commonURL}/member/findid_proc",
      data:frmData,
      contentType:false,
      processData:false,
      type:"POST",
   })
   .done( (result)=>{
      	if(result.result=="fail")
		{
      		alert("해당하는 아이디를 찾을 수 없습니다.");
		}
       	else  //패스워드 실패시 3을 보낸다  
      	{
      		$("#result").html("아이디는 <strong>" + result.result + "</strong> 입니다");	
      	}
   })
   .fail( (error)=>{
      console.log(error);
   })
}



function goCancel()
{
	// document - HTML 객체 라고 생각하시면 되요.. 여기에 지금 이 페이지에 있는 HTML 태그 정보가 다 들어있어요
	// document.태그name 을 가져오면 이태그의 데이터를 가져올수도 있고 조작할수도 있어요
	// <form name="myform" id="myform">
	// commonURL 네 이 변수는 어디서 가져오죠? 그러게요 신기한친구네
  var frm = document.myform;
   frm.action="${commonURL}/board/list";
   frm.submit();
}
</script>