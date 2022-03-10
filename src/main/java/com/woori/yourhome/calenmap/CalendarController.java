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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.yourhome.board.BoardDto;

@Controller
public class CalendarController {

	// MapService service = mapService;
	@Resource(name = "festService")
	FestService service;

	@RequestMapping(value = "calendar", method = RequestMethod.GET)
	public String calendar(Model model, HttpServletRequest request, DateDto datedto) {

		Calendar cal = Calendar.getInstance();
		DateDto calendarData;
		// 검색 날짜
		if (datedto.getDate().equals("") && datedto.getMonth().equals("")) {
			datedto = new DateDto(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
					String.valueOf(cal.get(Calendar.DATE)), null);
		}
		// 검색 날짜 end

		Map<String, Integer> today_info = datedto.today_info(datedto);
		List<DateDto> dateList = new ArrayList<DateDto>();

		// 실질적인 달력 데이터 리스트에 데이터 삽입 시작.
		// 일단 시작 인덱스까지 아무것도 없는 데이터 삽입
		for (int i = 1; i < today_info.get("start"); i++) {
			calendarData = new DateDto(null, null, null, null);
			dateList.add(calendarData);
		}

		// 날짜 삽입
		for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
			 if (i == today_info.get("today")) {
			//if(i==6) {
				calendarData = new DateDto(String.valueOf(datedto.getYear()), String.valueOf(datedto.getMonth()),
						String.valueOf(i), "today");
			} else {
				calendarData = new DateDto(String.valueOf(datedto.getYear()), String.valueOf(datedto.getMonth()),
						String.valueOf(i), "normal_date");
			}
			dateList.add(calendarData);
		}

		// 달력 빈곳 빈 데이터로 삽입
		int index = 7 - dateList.size() % 7;

		if (dateList.size() % 7 != 0) {

			for (int i = 0; i < index; i++) {
				calendarData = new DateDto(null, null, null, null);
				dateList.add(calendarData);
			}
		}

		System.out.println(dateList);
		// System.out.println(dateList);
		for(DateDto dto:dateList) {
			System.out.println(dto);
		}

		// 배열에 담음
		DateDto searchDto = new DateDto();

		searchDto.setYear(datedto.getYear());
		searchDto.setMonth(String.format("%02d", Integer.parseInt(datedto.getMonth())+1));


		// 서비스 -> list 호출
		// List<FestDataDto> list = service.getList(searchDto);
		List<FestDataDto> boardList = service.getList(searchDto);

		// area 맵
		/*
		 * <text id="LCD41" class="TEXT" x="216" y="245" >서울&인천&경기</text> <text
		 * id="LCD42" class="TEXT" x="370" y="179" >강원도</text> <text id="LCD44"
		 * class="TEXT" x="105" y="449" >충남&세종&대전</text> <text id="LCD43" class="TEXT"
		 * x="294" y="381" >충북</text> <text id="LCD47" class="TEXT" x="447" y="460"
		 * >경북&대구&울산</text> <text id="LCD45" class="TEXT" x="179" y="592" >전북</text>
		 * <text id="LCD46" class="TEXT" x="138" y="764" >전남&광주</text> <text id="LCD48"
		 * class="TEXT" x="367" y="672" >경남&부산</text> <text id="LCD50" class="TEXT"
		 * x="76" y="1070" >제주</text>
		 * 
		 */

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

		System.out.println("[dateList]-----------------" + dateList);

		// 달력에서 ●툴팁 표시하는 태그생성
		for (DateDto dateDto : dateList) {
			String festDetail = "";
			for (FestDataDto fdto : boardList) {
				String tmp = "";
				if (!dateDto.getDate().isEmpty()) {
					tmp = String.format("%02d", Integer.parseInt(dateDto.getDate()));
				}

				if (fdto.getFES_STARTDATE().split("-")[2].equals(tmp)) {
					dateDto.setSchedule(fdto.getFES_NAME());

					// area 별로 festDetail 변경
					// String.format("%02d", dateDto.getDate())
					festDetail += "<div class=\"tooltip\">\r\n"
							+ "<div style=\"border-radius:75px; width:10px; height:10px; margin:2px; background-color:"
							+ colorMap.get(fdto.getFES_AREA()) + "; display:inline-block\"></div>\r\n"
							+ "<span class=\"tooltiptext\">" + fdto.getFES_NAME() +"<br/>" + fdto.getFES_STARTDATE()+'~' + fdto.getFES_ENDDATE()
							+ " </span>\r\n" + "</div>";
					dateDto.setSchedule_detail(festDetail);
				}
			}
		}
	

		// model 에 데이터 담고
		//model.addAttribute("mapList", boardList);

		//System.out.println("------------------------->" + boardList);

		model.addAttribute("dateList", dateList); // 날짜 데이터 배열
		model.addAttribute("today_info", today_info);
		return "calenmap/calendar";
	}

	@RequestMapping("/calendar/list")
	@ResponseBody
	public List<FestDataDto> getList(Model model, DateDto datedto) {
		
		
		System.out.println("==========================1============" + datedto);

		datedto.setMonth(String.format("%02d", Integer.parseInt(datedto.getMonth())));
		
		System.out.println("==========================3============" + datedto);

		List<FestDataDto> boardList = service.getList(datedto);
		
		System.out.println("---------->" + boardList);
		// model 에 데이터 담고

		//model.addAttribute("mapList", boardList);
		// jsp 로 전송
		//return "calenmap/maplist";
		return boardList;
	}
	
	@RequestMapping("/calendar/kakaomap")
	public String kakaomap(String addr, String fes_name,String fes_place, Model model) {
		
		model.addAttribute("addr", addr);
		model.addAttribute("fes_name", fes_name);
		model.addAttribute("fes_place", fes_place);
		
		return "calenmap/kakaomap";
	}

}
