package com.woori.yourhome.free_board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeBoardController {
//this is a testy test
   @Resource(name="freeboardService")
   FreeBoardService service;
   
   @RequestMapping("/freeboard/list")
   String freeboard_list(FreeBoardDto dto, Model model)
   {
	  dto.setStart(dto.getPg()*dto.getPageSize());
	  
      model.addAttribute("boardList", service.getList(dto));
      model.addAttribute("totalCnt", 30);
      return "/freeboard/freeboard_list";
   }
   
   @RequestMapping("/freeboard/datalist")
   @ResponseBody
   List<FreeBoardDto> freeboard_datalist(FreeBoardDto dto)
   {
      return service.getList(dto);
   }
   
   
   @RequestMapping(value="/freeboard/save",  method=RequestMethod.POST)
   @ResponseBody
   HashMap<String, String> freeboard_save( FreeBoardDto dto)
   {
      if(dto.getGroup_id()==0)
         service.insert(dto);
      else 
         service.insert_reply(dto);
      
      HashMap<String, String> map = new HashMap<String, String>();
      
      map.put("result", "success");
      return map;
   }
   
   @RequestMapping("/freeboard/write")
   String freeboard_write(Model model)
   {
      FreeBoardDto dto=new FreeBoardDto();
      model.addAttribute("boardDto", dto);
      
      return "/freeboard/freeboard_write";
   }
   
   @RequestMapping("/freeboard/view")
   String freeboard_write(FreeBoardDto paramDto, Model model)
   {
      FreeBoardDto dto= service.getView(paramDto);
      model.addAttribute("boardDto", dto);
      
      return "/freeboard/freeboard_view";
   }
   
   @RequestMapping("/freeboard/reply")
   String freeboard_reply(FreeBoardDto paramDto, Model model)
   {
      FreeBoardDto dto= service.getView(paramDto);
      
      //dto.setTitle("Re:" + dto.getTitle());
      dto.setSeq("");
      dto.setContents("");
      
      model.addAttribute("boardDto", dto);
      model.addAttribute("mode", "reply");
      return "/freeboard/freeboard_write";
   }
}








