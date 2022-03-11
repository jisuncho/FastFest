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
    .overlay_info .fes-title {display: block; background: #d95050; background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center; text-decoration: none; color: #fff; padding:12px 36px 12px 14px; font-size: 14px; border-radius: 6px 6px 0 0}
    .overlay_info .fes-title strong {background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/place_icon.png) no-repeat; padding-left: 27px;}
    .overlay_info .desc {padding:14px;position: relative; min-width: 190px; height: 56px}
    .overlay_info img {vertical-align: top;}
    .overlay_info .address {font-size: 14px; color: #333; position: absolute; left: 10px; right: 14px; top: 20px; white-space: normal}
    .overlay_info .address2 {font-size: 12px; color: #333; position: absolute; left: 10px; right: 14px; top: 24px; white-space: normal}
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

<%@include file="../include/nav.jsp" %>
<p style="margin-top:10px">
</p>
<div id="map"  style="margin:auto; margin-top:70px; width:900px;height:650px;"></div>
<div style="text-align:center;">

  <div class="button-1" style="margin-top:10px" onclick="window.history.back(document.referrer);">
    <div class="eff-1"></div>
    <a href="#"> 뒤로가기 </a>
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
        content += '    <div class="fes-title"><strong>축제장소</strong></div>';
        content += '    <div class="desc">';
        //content += '        <img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/place_thumb.png" alt="">';
        content += '        <span class="address">'+'<%=(String)request.getAttribute("fes_name")%>'+'</span><br/>';
		content += '		<p class="address2" style="margin-top:15px"> 장소 : ' + '<%=(String)request.getAttribute("fes_place")%>' + '</p>';
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