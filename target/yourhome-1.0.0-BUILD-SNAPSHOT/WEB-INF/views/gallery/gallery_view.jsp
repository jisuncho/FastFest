<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.woori.yourhome.gallery.*" %>
<%@page import="com.woori.yourhome.common.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
    <%@include file="../include/nav.jsp" %>
	<%
		String key = StringUtil.nullToValue(request.getParameter("key"), "1");
		String keyword = StringUtil.nullToValue(request.getParameter("keyword"), "");
		String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	%>
	<%
	GalleryDto dto = (GalleryDto)request.getAttribute("galleryDto");
	%>
	
	<form name="myform">
		<input type="hidden" name="id"      value="<%=dto.getId()%>" >
		<input type="hidden" name="pg"      value="<%=pg%>" >
		<input type="hidden" name="key"     value="<%=key%>" >
		<input type="hidden" name="keyword" value="<%=keyword%>" >
		
    <div class="container" style="margin-top:80px">
        <h2>게시판 상세보기</h2>
        <table class="table table-hover " style="margin-top:30px;">
            <tbody>
              <tr class="table-secondary">
                <th >제목</th>
                <td colspan="3"><%=dto.getTitle()%></td>
              </tr>
              <tr >
                <th >작성자</th>
                <td><%=dto.getWriter()%></td>
                <th>작성일</th>
                <td><%=dto.getWdate()%></td>
       
              </tr>
              <tr>
                <th colspan="4"  >내용</td>
              </tr>
              <tr>
                <td colspan="4">             
					<%=dto.getComment().replaceAll("\n", "<br/>")%>
                </td>
              </tr>
              
               <tr>
                <td colspan="4">             
					<img src="../upload/<%=dto.getImage()%>"/>
                </td>
              </tr>
              
            </tbody>
          </table>

 
       
          <div class="container mt-3" style="text-align:right;">
            <a href="#none" onclick="goList()" class="btn btn-secondary">목록</a>
         	<a href="#none" onclick="goModify()" class="btn btn-secondary">수정</a>
         	<a href="#none" onclick="goDelete()" class="btn btn-secondary">삭제</a>
          </div>
          
    </div>
    
    </form>
</body>
</html>

<script>
function goList()
{
	var frm = document.myform;
	frm.action="<%=request.getContextPath()%>/gallery/list";
	frm.submit();
}

function goModify()
{
	var frm = document.myform;
	frm.action="<%=request.getContextPath()%>/gallery/modify";
	frm.submit();
}


function goDelete()
{
	if( confirm("삭제하시겠습니까?"))
	{
		var frm = document.myform;
		frm.action="<%=request.getContextPath()%>/gallery/delete";
		frm.submit();
	}
}

</script>











