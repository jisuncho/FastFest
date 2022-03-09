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
  
  - (calendar.jsp) : 툴팁 기본코드

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
  - (calendar.jsp) 

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
```

  - (map.jsp)
  
    ```javascript
 const mapimage_url = "'/yourhome/resources/images/별.png'";
    -------------------------------------------------------------
    data += '<button class="btn2" onclick="location.href='+map_url+'" type="button"><img src='+mapimage_url+' class="image2"></button>'
    ```
    
    
    
  - " https://developers.kakao.com/ " 가입하고 , 애플리케이션 만들어서 키값 받기
  
  - 플랫폼> 플랫폼 설정하기 > web플랫폼 등록> 도메인 or http://http://localhost:8080/로 설정
  
  - kakaomap.jsp파일 생성
  
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

      - 축제 리스트에서 지도 보기 이미지 마우스 아이콘 바꾸기
      - 카드 사이즈 조금 늘이기
          - margin-left :10px;

  

  

  