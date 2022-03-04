package com.woori.yourhome.calenmap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {

	// MapService service = mapService;
	@Resource(name = "mapService")
	MapService service;

	@RequestMapping(value = "calendar", method = RequestMethod.GET)
	public String calendar(Model model, HttpServletRequest request, MapDto mapdto) {

		Calendar cal = Calendar.getInstance();
		MapDto calendarData;
		// 검색 날짜
		if (mapdto.getDate().equals("") && mapdto.getMonth().equals("")) {
			mapdto = new MapDto(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
					String.valueOf(cal.get(Calendar.DATE)), null);
		}
		// 검색 날짜 end

		Map<String, Integer> today_info = mapdto.today_info(mapdto);
		List<MapDto> dateList = new ArrayList<MapDto>();

		// 실질적인 달력 데이터 리스트에 데이터 삽입 시작.
		// 일단 시작 인덱스까지 아무것도 없는 데이터 삽입
		for (int i = 1; i < today_info.get("start"); i++) {
			calendarData = new MapDto(null, null, null, null);
			dateList.add(calendarData);
		}

		// 날짜 삽입
		for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
			if (i == today_info.get("today")) {
				calendarData = new MapDto(String.valueOf(mapdto.getYear()), String.valueOf(mapdto.getMonth()),
						String.valueOf(i), "today");
			} else {
				calendarData = new MapDto(String.valueOf(mapdto.getYear()), String.valueOf(mapdto.getMonth()),
						String.valueOf(i), "normal_date");
			}
			dateList.add(calendarData);
		}

		// 달력 빈곳 빈 데이터로 삽입
		int index = 7 - dateList.size() % 7;

		if (dateList.size() % 7 != 0) {

			for (int i = 0; i < index; i++) {
				calendarData = new MapDto(null, null, null, null);
				dateList.add(calendarData);
			}
		}

		System.out.println(dateList);
		// System.out.println(dateList);

		// 배열에 담음
		MapDto searchDto = new MapDto();

		searchDto.setYear("2022");
		searchDto.setMonth("03");

		// 서비스 -> list 호출
		List<FestDataDto> list = service.getList(searchDto);

		Map<String, String> colorMap = new HashMap<String, String>();

		colorMap.put("서울특별시", "#ff7c35");
		colorMap.put("인천광역시", "#ff7c35");
		colorMap.put("경기도", "#ff7c35");
		
		colorMap.put("강원도", "#29d352");

		colorMap.put("충청남도", "#ff6575");
		colorMap.put("세종특별자치시", "#ff6575");
		colorMap.put("대전광역시", "#ff6575");
		
		colorMap.put("충청남도", "#b06af6");
		
		colorMap.put("경상북도", "#3c95ff");
		colorMap.put("대구광역시", "#3c95ff");
		colorMap.put("울산광역시", "#3c95ff");
		
		colorMap.put("전라북도", "#F6bc06");
		
		colorMap.put("전라남도", "#3253d8");
		colorMap.put("광주광역시", "#3253d8");
		
		colorMap.put("경상남도", "#f462f7");
		colorMap.put("부산광역시", "#f462f7");
		
		colorMap.put("제주특별자치도", "#35e3cf");

		for (MapDto dateDto : dateList) {
			String festDetail = "";
			for (FestDataDto fdto : list) {
				String tmp="";
				if(!dateDto.getDate().isEmpty()) {					
					tmp = String.format("%02d", Integer.parseInt(dateDto.getDate()));
				}

				if (fdto.getFES_STARTDATE().split("-")[2].equals(tmp)) {
					dateDto.setSchedule(fdto.getFES_NAME());

					// area 별로 festDetail 변경
					//String.format("%02d", dateDto.getDate())
					festDetail += "<div class=\"tooltip\">\r\n"
							+ "<div style=\"border-radius:75px; width:10px; height:10px; margin:2px; background-color:"
							+ colorMap.get(fdto.getFES_AREA()) + "; display:inline-block\"></div>\r\n"
							+ "<span class=\"tooltiptext\">" + fdto.getFES_NAME()+':'+'~'+ fdto.getFES_ENDDATE()+" </span>\r\n" + "</div>";
					dateDto.setSchedule_detail(festDetail);
				}
			}
		}

		// model 에 데이터 담고
		model.addAttribute("mapList", list);

		model.addAttribute("dateList", dateList); // 날짜 데이터 배열
		model.addAttribute("today_info", today_info);
		return "calenmap/calendar";
	}

	@RequestMapping("/calendar/list")
	public String getList(Model model) {
		// 서비스 -> list 호출
		List<FestDataDto> list = service.getList(null);

		System.out.println("---------->" + list);
		// model 에 데이터 담고

		model.addAttribute("mapList", list);
		// jsp 로 전송
		return "calenmap/maplist";
	}

}
