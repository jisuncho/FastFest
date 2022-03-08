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
    * 글씨체 변경 (로컬에만 저장 되어있는 글씨체이므로) 
    * 달력 코드  + 지도 코드 합침  
      * web-app> resources> css> css파일 따로 생성 (calendar.css, map.css)
    * 지도 크기 고정
    * 달력에 ●표시로 지역별 축제 툴팁표기(지역별 컬러값 다르게)
    * 지도에서 지역 선택 시 하단에 축제 리스트 출력
      * resouces폴더밑에 image폴더 생성
    * 축제데이터 DB생성

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
  - 달력에 ●표시로 지역별 축제 툴팁표기(지역별 컬러값 다르게)
  - 지도에서 지역 선택 시 하단에 축제 리스트 출력
  - resouces폴더밑에 image폴더 생성

## 220303

- 축제 이미지 크기 동일하게 변경 (500px X 360px)
  - .jpg파일로 변경
- MapDto -> DateDto로 파일명 변경하면서 생긴 에러 수정
  - DB에서 데이터 리스트 불러오는것까지 확인
- 향후과제
  - 달력에 ●표시로 지역별 축제 툴팁표기(지역별 컬러값 다르게)
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
  
     ​	


![지도툴팁기능](https://user-images.githubusercontent.com/95202440/156756655-b013e697-c40d-495c-98b6-a5f51e9b2ad3.JPG)

- 향후과제
	- 툴팁글씨체(깨져보여서) , 전체 글씨체 변경
	- 확대된 지도 수정하기
	- 지도의 지역명 마다 링크
		- 하단에 이미지와 함께 리스트로 출력



## 220307

- 글씨체 변경 (구글웹폰트-하이멜로디체)
- 축제 이미지 크기 동일하게 변경 (500px X 360px)
  - .jpg파일로 변경   --------- 삭제되서 다시 만듦
- css -card 찾음..... (수정하기) 
  - "https://codepen.io/FlorinPop17/pen/dyPvNKK"
- 향후과제
  - 달력크기줄이기
  - 달력에서 일요일만 밀리는 현상
  - 이전달 데이터 변경(모든달이 3월행사로 채워져있음)
  - 지역별 링크걸어서 하단에 축제 리스트 띄우기...ing

## 220308

- 글씨체 변경 (구글웹폰트 - 동글체)

- 달력크기 줄임

- 달 마다 데이터 변경

- 지역별 링크로 하단에 축제 리스트 띄우기

  - 지역 클릭시 하단에 리스트 쌓임문제 

- DB 수정(이미지파일 확장자 수정, 4월 행사 추가)

- 지도 클릭 전 후 상황  

  - 지역 누르기전 이미지 띄우기 
  - 띄울 이미지 크기조절 안됨 - (상단에 img설정 부분이 있었음) 
  - 축제 리스트가 뜨면 지워져야 함 

- 지도클릭시 축제가 있고 없고의 상황에 맞추기

  - 축제가 없는 지역에선 축제가 없는 지역이라고 띄우기

- 지도 '지역명' 글자 크기 키우기

  - 글자크기와 지도크기를 같이 키워야 하는 상황 - 글자만 키워서 x,y좌표값으로 글자위치 조절

    ```javascript
    $('#group').attr("transform", "scale(0.5,0.5)");	 //지도크기	
    $('#group1').attr("transform", "scale(0.6,0.6)");    //글자크기
    --------------------------------------------------------------
    <text id="LCD41" class="TEXT" x="110" y="175" >서울&인천&경기</text>  //글자위치조절
    
    ```

- README.md 파일 잔디가 안심어지는 현상!! - (루트를 제대로 못찾았었음) 

- 향후과제

  - 오늘날짜가 일요일이면 달력 데이터 잘리는 현상
  - 달력크기(폰트)  전체적으로 조금 키우기
  - 지도클릭하고 하단에 리스트 뜰때, 스크롤 자동으로 하단으로 내려가기



