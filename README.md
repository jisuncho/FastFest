# FastFest
지능형 5조

## 220221
* 주제 선정 (전국 각지의 축제에 대한 정보 및 날짜 제공)
* 프로젝트 기획안 작성
* 상세 메뉴 선정

## 220222

* 요구사항 명세서 작성

* 메인화면 디자인

## 220223

* DB 테이블 명세서 작성
* 메인화면 디자인
* 달력 & 지도 페이지 구현 계획
  * 구현방법 계획 및 이미지 검색

## 220224 
- dev1 브랜치 생성

- '축제' 엑셀 데이터 작성

- 수행일지 작성

- 메인화면 디자인

  ![FF_](https://user-images.githubusercontent.com/95202440/155690518-0835f6aa-e97a-43ce-89c1-a3fb4b326bc3.png)

- 페이지별 메뉴 디자인

  ![로고](https://user-images.githubusercontent.com/95202440/155953637-69bd71f4-e487-40f0-9600-d9eadb5679a1.PNG) 

- 지도 관련 이미지 png => svg 로 확정

## 220225
- 메인 화면 디자인 수정

![FF_a](https://user-images.githubusercontent.com/95202440/155688977-76b15980-48a4-4fd7-9df1-10b38f61bbea.png)

- DB테이블 명세서 수정

- '축제' 엑셀 데이터 수정

- 축제 메인 이미지 데이터 수집

- 지도이미지 구현 완성 - (SVG사용)

  - svg : 스케일러블 벡터 그래픽스는 2차원 벡터 그래픽을 표현하기 위한 XML 기반의 파일 형식

  - 구현 기능

    - 지역별 색상

    -  마우스오버&아웃기능추가

      ```javascript
      //제주
      document.getElementById("CD50").addEventListener("mouseover", function (event) {
          if(flag == false) {
              document.getElementById("usetag").setAttribute("href", "#CD41");
              document.getElementById("CD50").style.stroke=region_colors[9];
              flag = true;
          }
      },false);
      document.getElementById("CD50").addEventListener("mouseout", function (event) {
          if( flag == true) {
              document.getElementById("CD50").style.stroke=region_colors[0];
              flag = false;
          }
      },false);
      ```

    - 지도크기변경

      ```javascript
      <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
      
      //지도 사이즈
      $('#group').attr("transform", "scale(0.5,0.5)");
      $('#group1').attr("transform", "scale(0.5,0.5)");
      ```

      

  - 향후 과제
    - <a href> 링크 수정하기
    -  하단 리스트 기능 추가

![지도12](https://user-images.githubusercontent.com/95202440/155957588-75ac9ee8-f772-400f-acfa-8b1f3ac3e27d.png)

## 220228

* 달력디자인 (지도라인,색상 구성)

* 달력, 지도 화면구성 ( 한 화면에 같이 보이도록)

  ![0228](https://user-images.githubusercontent.com/95202440/155954295-8bf09869-00c5-4ec8-a59b-93eae260a43f.PNG)

  * 향후과제
    * ~~글씨체 변경 (로컬에만 저장 되어있는 글씨체이므로~~) -> 구글 웹폰트로 변경
    * 달력 코드  + 지도 코드 합침  
      * web-app> resources> css> css파일 따로 생성 (calendar.css, map.css)
    * 지도 크기 고정
    * 달력에 ●표시로 지역별 축제 툴팁표기(지역별 컬러값 다르게)
    * 지도에서 지역 선택 시 하단에 축제 리스트 출력
      * ~~resouces폴더밑에 image폴더 생성~~
    * ~~축제데이터 DB생성~~

## 220302

* 지도 크기 고정
  * (calendar.css)

```javascript
.container {
	display: flex;
	height:500px;
	width:1000px;
}
```

- 축제 데이터 DB생성 및 데이터 삽입
- Festdata 테이블 연동 
  - dto, dao, service,mapper 파일 구현
- 향후과제
  - ~~달력에 ●표시로 지역별 축제 툴팁표기(지역별 컬러값 다르게)~~
  - 지도에서 지역 선택 시 하단에 축제 리스트 출력
  - ~~resouces폴더밑에 image폴더 생성~~

## 220303

- 축제 이미지 크기 동일하게 변경 (500px X 360px)
  - .jpg파일로 변경
- MapDto -> DateDto로 파일명 변경하면서 생긴 에러 수정
  - DB에서 데이터 리스트 불러오는것까지 확인
- 향후과제
  - ~~달력에 ●표시로 지역별 축제 툴팁표기(지역별 컬러값 다르게)~~
  - 지도에서 지역 선택시 하단에 축제 리스트 출력 (div로 데이터 출력은 확인)

## 220304

- ~~MapDto -> DateDto로 파일명 변경하면서 생긴 에러 수정~~

  => DateData파일로 그냥 구현하기로하고 복원 함 

  => FFgit3 에서 작업하고 기본 프로젝트로 사용함

  => 깃허브 FastFest - main에서 작업할 예정

- resouces폴더밑에 image폴더에 이미지 집어넣기

- 달력에 지역별 다른색상의 ●표시, 축제명&end날짜 툴팁표기 

  - (CalendarController.java)
  
  ```javascript
  List<FestDataDto> list = service.getList(searchDto);
  Map<String, String> colorMap = new HashMap<String, String>();
  colorMap.put("서울특별시", "#ff7c35"); ....      //지역마다 색상 주기
  ──────────────────────────────────────────────────────────────────
  for (MapDto dateDto : dateList) {
      String festDetail = "";
      for (FestDataDto fdto : list) {
          String tmp="";
          if(!dateDto.getDate().isEmpty()) {					
              tmp = String.format("%02d", Integer.parseInt(dateDto.getDate()));
      }  // 비어있지않은 날짜중에 한자리수면 0을 넣어서 2자리로 맞춰주기
  
      if (fdto.getFES_STARTDATE().split("-")[2].equals(tmp)) {
          dateDto.setSchedule(fdto.getFES_NAME());
  
          // area 별로 festDetail 변경
          //String.format("%02d", dateDto.getDate())
          festDetail += "<div class=\"tooltip\">\r\n"
              + "<div style=\"border-radius:75px; width:10px; height:10px; margin:2px; background-color:"     // ●표시
              + colorMap.get(fdto.getFES_AREA()) + "; display:inline-block\"></div>\r\n"
               + "<span class=\"tooltiptext\">" + fdto.getFES_NAME()+':'+'~'+ 				fdto.getFES_ENDDATE()+" </span>\r\n" + "</div>"; //툴팁에 나타낼 정보
              dateDto.setSchedule_detail(festDetail);
          }
      }
  }
  ```
  
  - (calendar.css) : 툴팁 기본코드

   ```java script
   /* Tooltip container */
   .tooltip {
     position: relative;
     display: inline-block;
   }
   
   /* Tooltip text */
   .tooltip .tooltiptext {
     visibility: hidden;
     width: 350px;
     background-color: #fd6aa5;
     color: #fff;
     text-align: center;
     padding: 5px 0;
     border-radius: 6px;
    
     /* Position the tooltip text - see examples below! */
     position: absolute;
     z-index: 1;
     bottom: 100%;
     left: 50%;
     margin-left: -60px;
   }
   
   /* Show the tooltip text when you mouse over the tooltip container */
   .tooltip:hover .tooltiptext {
     visibility: visible;
   }
   ```

  - (Calendarmap.xml) : 날짜에서 '-' 기호 빼고 년&월 만 가져오기
  
    

```
<select id="Calenmap_getList"  parameterType="MapDto"  resultType="FestDataDto">	
    select
        FES_NAME
        ,FES_PLACE
        ,FES_STARTDATE
        ,FES_ENDDATE
        ,FES_DOMAIN
        ,FES_AREA
        ,FES_INFO
        ,FES_PHONE
        ,FES_ADDRESS
        ,FES_IMG
        ,FEST_DATE
    from pro1_festdata
    where FES_STARTDATE like concat('${year}','-' ,'${month}', '%')
</select>
```




![지도툴팁기능](https://user-images.githubusercontent.com/95202440/156756655-b013e697-c40d-495c-98b6-a5f51e9b2ad3.JPG)

- 향후과제
	- ~~툴팁글씨체(깨져보여서) , 전체 글씨체 변경~~
	- ~~확대된 지도 수정하기~~
	- ~~지도의 지역명 마다 링크~~
		- ~~하단에 이미지와 함께 리스트로 출력~~



## 220307

- 글씨체 변경 (구글웹폰트-하이멜로디체)
- 축제 이미지 크기 동일하게 변경 (500px X 360px)
  - .jpg파일로 변경   --------- 삭제되서 다시 만듦
- css -card 찾음..... (수정하기) 
  - "https://codepen.io/FlorinPop17/pen/dyPvNKK"
- 향후과제
  - ~~달력크기줄이기~~
  - ~~달력에서 일요일만 밀리는 현상~~
  - ~~매달 데이터 변경(모든달이 3월행사로 채워져있음)~~
  - ~~지도의 지역명 마다 링크~~ 
    - ~~하단에 이미지와 함께 축제 리스트 띄우기...ing~~~~

## 220308

- css- card 디자인 수정

- 글씨체 변경 (구글웹폰트 - 동글체)

- 로고 재 변경

  ![FF0307_3](https://user-images.githubusercontent.com/95202440/157257126-11c2bb77-d955-4b71-8d39-12e6529ece30.png)

- 달력크기 줄임

- 매달 데이터 변경(모든달이 3월행사로 채워져있음)

- 지역별 링크로 하단에 축제 리스트 띄우기 (지역 클릭시 하단에 리스트 쌓임문제 있음)

  - (map.jsp)

    ```javascript
     const image_url = "'/yourhome/resources/images/" + item.fes_IMG+"'";
     console.log(image_url);
     var data = "<div id='cards' class='courses-container' style= 'margin-left: 150px; margin-bottom:80px; width:1000px; height:100px'>";
      data += "<div class='course' style='width:900px ; height:150px;'>";
      data += '<div style="width:600px; z-index:100; background-size: cover; background-image:url('+image_url+');" class="course-preview"></div>';
       data += "<div class='course-info' style='margin-left:5px; margin-bottom:5px'>";
       data += "<h5 class='card-title' style='padding:-100px; margin-top:5px; margin-bottom:5px'>이달의 "+item.fes_AREA+" 행사</h5>";
       data += "<p class='card-text' style='margin-top:5px; margin-bottom:5px'>"+item.fes_NAME+"<br/>" + item.fes_STARTDATE+" ~ "+item.fes_ENDDATE+"<br/>장소 : " +item.fes_PLACE+"</p>";
       data += "<button class='btn' style='width:100px; padding:2px;'><a href='"+item.fes_DOMAIN+"'><span style='font-size:18pt'>홈페이지</span></a></button>";
       data += " </div> </div> </div>";
          		
      document.getElementById("imagediv").style.display = "none";
      $("#festboard").append(data);
    ```

    

- DB 수정(이미지파일 확장자 수정, 4월 행사 추가)

- 지도 클릭 전 상황  

  - (board.jsp)  지역 누르기전 이미지 띄우기 

```javascript
<div id="h2sub"></div>
<div id="imagediv" style="display:block; text-align:center;"><img src="/yourhome/resources/images/클릭전2.png"></div>
```

-				 지도 클릭 후 상황

      -				 (map.jsp) -  지역 누르면 이미지 없어지기


```javascript
   for(i=$("#cards").length; i>=0; i--){
    	 $("#cards").remove();
     }
```

  - 띄울 이미지 크기조절 안됨 - (상단에 img설정 부분에서 조절) 

```css
img {
    width:30%;
    height:20%;
    margin-top:30px;
    margin-bottom:10px;
}

```

- 지도클릭시 축제가 있고 없고의 상황에 맞추기
  - (map.jsp) - 축제가 없는 지역에선 축제가 없는 지역이라고 띄우기

```
if (result.length==0){
document.getElementById("h2sub").innerText = "해당 지역에 축제가 없습니다";
} else {
document.getElementById("h2sub").innerText = "";
}    
```

- 지도 '지역명' 글자 크기 키우기

  - (map.jsp) 글자크기와 지도크기를 같이 키워야 하는 상황 
    - 글자만 키워서 x,y좌표값으로 글자위치 조절

```javascript
$('#group').attr("transform", "scale(0.5,0.5)");	 //지도크기	
$('#group1').attr("transform", "scale(0.6,0.6)");    //글자크기
--------------------------------------------------------------
<text id="LCD41" class="TEXT" x="110" y="175" >서울&인천&경기</text>  //좌표값으로 글자위치조절
```

- GIT에 README.md 파일 잔디가 안심어지는 현상!! - (루트를 제대로 못찾았었음) 
  - merge를 해줘야 잔디가 심어짐!!!
- 향후과제

  - ~~오늘날짜가 일요일이면 달력 데이터 잘리는 현상~~
  - ~~달력크기(폰트)  전체적으로 조금 키우기~~
  - ~~지도클릭하고 하단에 리스트 뜰때, 스크롤 자동으로 하단으로 내려가기~~



## 220309

- 달력과 지도를 감싸고 있는 container의 width를 줄여 둘의 간격을 적절하게 맞춤
  - (calendar.css) 

```javascript
.container {
    display: flex;
    height:500px;
    width:1000px;      //width를 줄일수록 둘의 간격이 좁아짐
}
```

- 달력크기(폰트)  전체적으로 조금 키우기 - style의 body
  
  - (calendar.jsp)

```javascript
body{
    font-family: 'Dongle' !important;
    font-size:20pt;
}
```

- today가 일요일일때, 한주가 당겨짐
  - (calendar.jsp)

```javascript
<tbody>
<tr>
    <!-- 일요일이 today 일때 -->
    <c:forEach var="dateList" items="${dateList}" varStatus="date_status">
    <c:choose>
    <c:when test="${dateList.value=='today'}">
    <c:if test="${date_status.index%7==0}">  // 한주 시작할때 넣어줌
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
		<c:when test="${date_status.index%7==0}"> //한주 끝날때 넣어줌
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
```



- 하단의 축제리스트 버튼크기 키우기

  -	(map.jsp) - font-size 변경으로인해 버튼크기와 버튼글씨 크기 조절

  ```javascript
  "<button class='btn' style='width:100px; padding:2px;'><a href='"+item.fes_DOMAIN+"'><span style='font-size:18pt'>홈페이지</span></a></button>";
  ```

  

- 축제리스트가 뜨면, 스크롤 자동으로 내려가기

  - (map.jsp)

    ```javascript
    window.scrollTo(0, document.body.scrollHeight);
    ```

    

- 지도에서  지역변경시 이전 mouse over 지역에 테두리 남아있던거 없애기

  - (map.jsp)

    ```javascript
    function mapColorInit() { // 기본값 함수 만들어 놓고
    	document.getElementById("CD11").style.stroke = region_colors[0];
    	document.getElementById("CD26").style.stroke = region_colors[0];
    	document.getElementById("CD27").style.stroke = region_colors[0];
    	document.getElementById("CD28").style.stroke = region_colors[0];
    	document.getElementById("CD29").style.stroke = region_colors[0];
    	document.getElementById("CD30").style.stroke = region_colors[0];
    	document.getElementById("CD31").style.stroke = region_colors[0];
    	document.getElementById("CD36").style.stroke = region_colors[0];
    	document.getElementById("CD42").style.stroke = region_colors[0];
    	document.getElementById("CD41").style.stroke = region_colors[0];
    	document.getElementById("CD43").style.stroke = region_colors[0];
    	document.getElementById("CD44").style.stroke = region_colors[0];
    	document.getElementById("CD45").style.stroke = region_colors[0];
    	document.getElementById("CD46").style.stroke = region_colors[0];
    	document.getElementById("CD47").style.stroke = region_colors[0];
    	document.getElementById("CD48").style.stroke = region_colors[0];
    	document.getElementById("CD50").style.stroke = region_colors[0];
    }
    ----------------------------------------------------------------------
    // 하단에 마우스 아웃시에 함수 호출
    document
        .getElementById("CD41")
        .addEventListener(
       		"mouseout",
            function(event) {
                mapColorInit();
                if (flag == true) flag=false;
           }, false);
    ```

    

- 지도에서 지역명을 클릭해도 축제리스트 띄우기

  - (map.jsp) -  지역이름에도 onclick이벤트를 줘서 지역명 클릭시에도 축제 리스트 띄우기

    ```javascript
    <text id="LCD41" style="cursor:zoom-in" onclick="getList(1)" class="TEXT" x="110" y="175" >서울&인천&경기</text>
    ```

    지역명클릭시& 지역 클릭시 마우스커서 모양 변경하기 [ style="cursor:zoom-in" ]

  - ```javascript
    <g id="group" filter="url(#dropshadow)" style="cursor:zoom-in">  //지역 클릭시
    -------------------------------------------------------------------------------
    <text id="LCD41" style="cursor:zoom-in" onclick="getList(1)" class="TEXT" x="110" y="175" >서울&인천&경기</text>    //지역명 클식시
    ```

- 축제리스트에 홈페이지 버튼 후버 색상

  - (board.jsp)

    ```javascript
    a:hover { color:#5e5e5e; }
    ```

- =================================== 일단 완성!!! =======================================

- 카카오맵API 사용하기

- " https://developers.kakao.com/ " 가입하고 , 애플리케이션 만들어서 키값 받기

  - 플랫폼> 플랫폼 설정하기 > web플랫폼 등록> 도메인 or http://http://localhost:8080/로 설정

  - kakaomap.jsp파일 생성

    - (board.jsp)

      ```
       function mapview(addr){
      	 frm = document.myform;
      	 	frm.addr.value=addr;///////////
      	 	frm.method="get";
      	 	frm.action="${pageContext.request.contextPath}/calendar/kakaomap";
      	 	frm.submit();
       }
      ```

    - (calendarController.java)

      ```javascript
      	@RequestMapping("/calendar/kakaomap")
      	public String kakaomap(String addr, String fes_name, Model model) {
      		
      		model.addAttribute("addr", addr);
      		model.addAttribute("fes_name", fes_name);
      		
      		
      		return "calenmap/kakaomap";
      	}
      ```

    - (kakaomap.jsp)

      ```javascript
      <%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
      <!DOCTYPE html>
      <html>
      <head>
          <meta charset="utf-8">
          <title>주소로 장소 표시하기</title>
          <style>
          .overlay_info {border-radius: 6px; margin-bottom: 12px; float:left;position: relative; border: 1px solid #ccc; border-bottom: 2px solid #ddd;background-color:#fff;}
          .overlay_info:nth-of-type(n) {border:0; box-shadow: 0px 1px 2px #888;}
          .overlay_info a {display: block; background: #d95050; background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center; text-decoration: none; color: #fff; padding:12px 36px 12px 14px; font-size: 14px; border-radius: 6px 6px 0 0}
          .overlay_info a strong {background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/place_icon.png) no-repeat; padding-left: 27px;}
          .overlay_info .desc {padding:14px;position: relative; min-width: 190px; height: 56px}
          .overlay_info img {vertical-align: top;}
          .overlay_info .address {font-size: 12px; color: #333; position: absolute; left: 10px; right: 14px; top: 24px; white-space: normal}
          .overlay_info:after {content:'';position: absolute; margin-left: -11px; left: 50%; bottom: -12px; width: 22px; height: 12px; background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png) no-repeat 0 bottom;}
      
       .button-1{
        width:140px;
        height:50px;
        border:2px solid #34495e;
        text-align:center;
        cursor:pointer;
        position:relative;
        box-sizing:border-box;
        overflow:hidden;
        display:inline-block;
      }
      .button-1 a{
        font-family:arial;
        font-size:16px;
        color:#34495e;
        text-decoration:none;
        line-height:50px;
        transition:all .5s ease;
        z-index:2;
        position:relative;
      }
      .eff-1{
        width:140px;
        height:50px;
        top:-2px;
        right:-140px;
        background:#34495e;
        position:absolute;
        transition:all .5s ease;
        z-index:1;
        display:inline-block;
      }
      .button-1:hover .eff-1{
        right:0;
      }
      .button-1:hover a{
        color:#fff;
      }
      
      </style>
      </head>
      <body>
      <p style="margin-top:10px">
      </p>
      <div id="map"  style="margin:auto; width:800px;height:600px;"></div>
      <div style="text-align:center;">
      
        <div class="button-1" style="margin-top:10px">
          <div class="eff-1"></div>
          <a href="javascript:window.history.back();"> 뒤로가기 </a>
        </div>
          
      </div>
      
      <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ef2aa6df6213973c542524a9ec7ed2b6&libraries=services"></script>
      <script>
      
      
      
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
          mapOption = {
              center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
              level: 3 // 지도의 확대 레벨
          };  
      
      // 지도를 생성합니다    
      var map = new kakao.maps.Map(mapContainer, mapOption); 
      
      // 주소-좌표 변환 객체를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();
      
      // 주소로 좌표를 검색합니다
      geocoder.addressSearch('<%=(String)request.getAttribute("addr")%>', function(result, status) {
      
          // 정상적으로 검색이 완료됐으면 
           if (status === kakao.maps.services.Status.OK) {
      
              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
      
              // 결과값으로 받은 위치를 마커로 표시합니다
              // var marker = new kakao.maps.Marker({
              //   map: map,
              //   position: coords
              // });
      
              var content = '<div class="overlay_info">';
              content += '    <a href="#" target="_blank"><strong>축제장소</strong></a>';
              content += '    <div class="desc">';
              //content += '        <img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/place_thumb.png" alt="">';
              content += '        <span class="address">'+'<%=(String)request.getAttribute("fes_name")%>'+'</span><br/>';
      
              content += '    </div>';
              content += '</div>';
              
              var mapCustomOverlay = new kakao.maps.CustomOverlay({
                  position: coords,
                  content: content,
                  xAnchor: 0.5, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
                  yAnchor: 1.1 // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
              });
      
              mapCustomOverlay.setMap(map);
              // infowindow.open(map, marker);
      
              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
              map.setCenter(coords);
          } 
      });    
      </script>
      </body>
      </html>
      ```

      

- 지도를 볼수있는 링크넣기 (이미지로)

  - (board.css)
```css
  .btn2 {
      border: 0;
      background-color: transparent;
      padding: 12px 25px;
      position: absolute;
      bottom: 65px;
      right: 0px;
      letter-spacing: 1px;
  }
------------------------------------------------------------------------
data += '<button class="btn2" style="cursor:zoom-in" onclick="location.href='+map_url+'" type="button"><img src='+mapimage_url+' class="image2"></button>'
```

  - (map.jsp)
  
    ```javascript
 const map_url = "'/yourhome/calendar/kakaomap?addr="+item.fes_ADDRESS+"&fes_name="+ item.fes_NAME+"'"; 
    const mapimage_url = "'/yourhome/resources/images/별.png'";
    ```
-------------------------------------------------------------
      data += '<button class="btn2" onclick="location.href='+map_url+'" type="button"><img src='+mapimage_url+' class="image2"></button>'
    ```

  - board.jsp - mapview()함수 생성
  
    ```javascript
     function mapview(addr){
    	 frm = document.myform;
    	 	frm.addr.value=addr;///////////
    	 	frm.method="get";
    	 	frm.action="${pageContext.request.contextPath}/calendar/kakaomap";
    	 	frm.submit();
     }
    ```
  
  - CalendarController.java파일 - RequestMapping("/calendar/kakaomap") 부분 구현

  - 향후과제

      - ~~축제 리스트에서 지도보기 이미지위로 올렸을때 마우스 커서모양 바꾸기~~
      - ~~(map.jsp) - zoom-in커서로 바꾸기~~
      - ~~지도보기에서 축제장소도 올리~~기
      - ~~뒤로가기버튼 마진주기~~
      - (kakaomap.jsp)
      - ~~카드 사이즈 조금 늘이기~~
          - ~~margin-left :10px;~~

    ## 220310

- 축제 리스트에서 지도보기 이미지위로 올렸을때 마우스 커서모양 바꾸기

  - (map.jsp) - zoom-in커서로 바꾸기

    ```javascript
    data += '<button class="btn2" style="cursor:zoom-in" onclick="location.href='+map_url+'" type="button"><img src='+mapimage_url+' class="image2"></button>'
    ```

  - 뒤로가기버튼 마진주기

      - (kakaomap.jsp)

        ```javascript
          <div class="button-1" style="margin-top:10px">
            <div class="eff-1"></div>
            <a href="javascript:window.history.back();"> 뒤로가기 </a>
          </div>
        ```

- 카드 사이즈 조금 늘이기(높이)

  - (map.jsp)

    ```javascript
    data += "<div class='course' style='width:900px ; height:170px;'>";
    ```

- 달력 툴팁색상변경 (calendar.jsp - tooltip)

- 툴팁에서 BR태그로 날짜 아랫줄로 내리기(calendarcontroller.java)

- 지도보기에서 축제장소 넣기

  ```javascript
  (calendarcontroll.java)
  model.addAttribute("fes_place", fes_place);
  (map.jsp)
  const map_url = "'/yourhome/calendar/kakaomap?addr="+item.fes_ADDRESS+"&fes_name="+ item.fes_NAME+ "&fes_place="+ item.fes_PLACE+ "'";
  (kakaomap.jsp)
  content += '<p class="address2" style="margin-top:15px"> 장소 : ' + '<%=(String)request.getAttribute("fes_place")%>' + '</p>';
  ```

- nav바 추가하기 

  - nav.css 파일 추가 (by원웅)
  - ★css충돌로 전면 수정★ ( 글씨체, 달력크기 및 위치, 지도 위치, 카드(하단의 축제리스트) 수정)



  ## 220311

- kakao맵 크기 수정 (kakaomap.jsp - div id="map"에서 크기수정)

- kakaomap 페이지에 nav바 추가하기  (배너클릭시 홈페이지로 넘어가는 ahref태그는 원래대로 비워둠)

- 축제장소를 클릭하는만큼 뒤로가기 버튼을 눌러야 뒤로가지는 현상

  - (kakaomap.jsp)

  ```javascript
   // 이전 페이지... 즉 한단계 뒤로 돌아가기
   histroy.go(-1);
   // 두단계 이전의 페이지로 이동
   histroy.go(-2);
   // 세단계 이전의 페이지로 이동
   histroy.go(-3);
   // history.go(-1)과 동일한 기능을 구현하나 go(-1)이 보편적으로 사용됨
   history.back();
   // history.go(1)과 동일하며 앞으로 이동
   history.forward();
   // document.referrer : 방문했던 마지막 페이지의 url 정보
  
  -------------------------------------------------------------------------------
    <div class="button-1" style="margin-top:10px" onclick="window.history.back(document.referrer);">
      <div class="eff-1"></div>
      <a href="#"> 뒤로가기 </a>
    </div>
  
  ```

- cardtext 줄간격

  (map.css)

  ```javascript
  .card-text{
  	font-family: 'Dongle', sans-serif !important; 
  	font-size :20pt;
  	line-height: 1;  // 숫자만큼 줄간격 (숫자나,% , px로 줄수 있다 )
  }
  ```

  

  