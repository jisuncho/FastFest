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