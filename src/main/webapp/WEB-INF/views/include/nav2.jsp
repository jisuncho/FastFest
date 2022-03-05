<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.woori.yourhome.common.*" %>

<%
request.setAttribute("commonURL", request.getContextPath());

// request 객체에 저장된 데이터를 ${변수명} 이렇게 가져다 쓸수있어요
// 

String userid= StringUtil.nullToValue(session.getAttribute("userid"), "");
String username= StringUtil.nullToValue(session.getAttribute("username"), "");
String email= StringUtil.nullToValue(session.getAttribute("email"), "");
String phone= StringUtil.nullToValue(session.getAttribute("phone"), "");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css">
	
</head>
<body>
<section class="ftco-section">
		<div class="container">
			<img src="<%=request.getContextPath() %>/resources2/images/logo.png" height="200" style="text-align:left;">
			<div class="d-flex justify-content-start">
				<div class="col-md-6 text-center mb-5">
				 
					<!-- <h2 class="heading-section">Website menu #05</h2> -->
				</div>
			</div>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg ftco_navbar ftco-navbar-light" id="ftco-navbar">
		    <div class="container">
		    	<a class="navbar-brand" href="index.html">Logo</a>
		      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="fa fa-bars"></span> Menu
		      </button>
		      <div class="collapse navbar-collapse" id="ftco-nav">
		        <ul class="navbar-nav ml-auto mr-md-3">
		        	           <li class="nav-item">
             <a class="nav-link active" href="${commonURL}/board/list">게시판</a>
           </li>
          <li class="nav-item">
             <a class="nav-link" href="${commonURL}/gallery/list">갤러리</a>
           </li>
           <li class="nav-item">
             <a class="nav-link active" href="${commonURL}/freeboard/list">답글게시판</a>
           </li>
         
           <%if(userid.equals("")) {%>
           <li class="nav-item">
             <a class="nav-link" href="${commonURL}/member/join">회원가입</a>
           </li>
           <li class="nav-item">
             <a class="nav-link" href="${commonURL}/member/login">로그인</a>
           </li>
           <%}else{%>
           <li class="nav-item">
             <a class="nav-link" href="${commonURL}/member/myinfo">내정보</a>
           </li>
            <li class="nav-item">
             <a class="nav-link" href="${commonURL}/member/logout">로그아웃</a>
           </li>
           <%} %>
		          <li class="dropdown nav-item d-md-flex align-items-center">
                <a href="#" class="dropdown-toggle nav-link d-flex align-items-center justify-content-center icon-cart p-0" id="dropdown04" data-toggle="dropdown" aria-expanded="false">
                  <i class="fa fa-shopping-cart"></i>
                  <b class="caret"></b>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown04">
                  <a href="#" class="dropdown-item">Action</a>
                  <a href="#" class="dropdown-item">Another action</a>
                  <a href="#" class="dropdown-item">Something else here</a>
                  <div class="dropdown-divider"></div>
                  <a href="#" class="dropdown-item">Separated link</a>
                  <div class="dropdown-divider"></div>
                  <a href="#" class="dropdown-item">One more separated link</a>
                </div>
              </li>
		        </ul>
		      </div>
		    </div>
		  </nav>
    <!-- END nav -->
  </div>

	</section>

	<script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/js/popper.js"></script>
  <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/js/main.js"></script>
  
</body>
</html>
