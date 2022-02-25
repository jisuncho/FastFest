# FastFest
지능형 5조

## 220221
* 주제 선정 (전국 각지의 축제에 대한 정보 및 날짜 제공)

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

![지도1](https://user-images.githubusercontent.com/95202440/155688554-57ff0680-97d5-4023-91ea-73824af68819.PNG)

![지도2](https://user-images.githubusercontent.com/95202440/155688665-23d683e6-7bed-4b6a-a43d-23db12c66013.PNG)