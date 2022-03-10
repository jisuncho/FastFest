<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.woori.yourhome.calenmap.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" pageEncoding="UTF-8"%>

<html lang="ko">
<head>
<title>캘린더</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<!-- map start-->
<!-- <link href="https://fonts.googleapis.com/css?family=Gamja+Flower:400" rel="stylesheet">-->
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<!-- map end -->


<link href="<%=request.getContextPath()%>/resources/css/calendar.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/map.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/board.css" rel="stylesheet" />

</head>
<body>

<!-- nav 추가하는 곳  -->

<%@include file="../include/nav.jsp" %>
	<form name="calendarFrm" id="calendarFrm" action="" method="GET">
		<input type="hidden" name="year" value="${today_info.search_year}"/>
		<input type="hidden" name="month" value="${today_info.search_month}"/>
		<input type="hidden" name="areaId" value=""/>
		
 		<div class="container">
			<div class="calendar" style="margin-right:80px;margin-left:80px;display:block; ">

				<!--날짜 네비게이션  -->
				<div class="navigation">

					<a class="before_after_month"
						href="<%=request.getContextPath() %>/calendar?year=${today_info.before_year}&month=${today_info.before_month}">
						&lt; <!-- 이전달 -->
					</a> <span class="this_month"> &nbsp;${today_info.search_year}.
						<c:if test="${today_info.search_month<10}">0</c:if>${today_info.search_month}
					</span> <a class="before_after_month"
						href="<%=request.getContextPath() %>/calendar?year=${today_info.after_year}&month=${today_info.after_month}">
						<!-- 다음달 --> &gt;
					</a>
					
				</div>
				<div style="font-size:18pt;">●위에 마우스를 올려보세요 :)</div>
				<!-- <div class="today_button_div"> -->
				<!-- <input type="button" class="today_button" onclick="javascript:location.href='/calendar.do'" value="go today"/> -->
				<!-- </div> -->
				<table class="calendar_body" style="margin-top:5px; margin-bottom:10px;">

					<thead>
						<tr bgcolor="#ffffff">
							<td class="day sun">일</td>
							<td class="day">월</td>
							<td class="day">화</td>
							<td class="day">수</td>
							<td class="day">목</td>
							<td class="day">금</td>
							<td class="day sat">토</td>
						</tr>
					</thead>
					<tbody>
						<tr>
						<!-- 일요일이 today 일때 -->
							<c:forEach var="dateList" items="${dateList}" varStatus="date_status">
								<c:choose>
									<c:when test="${dateList.value=='today'}">
										<c:if test="${date_status.index%7==0}">
											</tr>
										</c:if>
										<td class="today" style="width: 50px;">
											<div class="date">${dateList.date}</div>
											<div class="dots">${dateList.schedule_detail}</div>
										</td>
									</c:when>
									<c:when test="${date_status.index%7==6}">
										<td class="sat_day" style="width: 50px;">
											<div class="sat">${dateList.date}</div>
											<div class="dots">${dateList.schedule_detail}</div>
										</td>
									</c:when>
									<c:when test="${date_status.index%7==0}">
									</tr>
							
									<tr>
							<td class="sun_day" style="width: 50px;" >
								<div class="sun">${dateList.date}</div>
								<div class="dots">${dateList.schedule_detail}</div>
							</td>
							
							</c:when>
							<c:otherwise>
								<td class="normal_day" style="width: 50px;" >
									<div class="date" >${dateList.date}</div>
									<div class="dots">${dateList.schedule_detail}</div>
								</td>
							</c:otherwise>
							</c:choose>
							</c:forEach>
					</tbody>

				</table>
			</div>
<%@include file="map.jsp" %>
			
		</div>
	</form>


<div style="height:300px"></div>

<%@include file="board.jsp" %>

</body>


</html>

