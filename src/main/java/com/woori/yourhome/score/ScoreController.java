package com.woori.yourhome.score;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoreController {
	@Resource(name="scoreService")
	ScoreService service;
	
	
	@RequestMapping("/score/list")
	String score_list(Model model)
	{
		model.addAttribute("scoreList", service.getList());
		
		return "score/score_list";
	}
	
	//  /score/write 치면 -> score_write.jsp로 이동하기 
	@RequestMapping("/score/write")
	String score_write()
	{
		return "score/score_write";
	}
	
	@RequestMapping("/score/save")
	String score_save(ScoreDto dto)
	{
		service.insert(dto);  //에러안나가만들것 
		
		return "redirect:/score/list";
	}

	@RequestMapping("/score/view")
	String score_view(int id, Model model)
	{
		model.addAttribute("scoreDto", service.getView(id));
		return "score/score_view";
	}
	
}







