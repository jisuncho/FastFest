package com.woori.yourhome.main;

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
public class MainController {

   @Resource(name="MainService")
   MainService service;
   
   @RequestMapping("/")
   String Main_list(MainDto dto, Model model)
   {
	 
	  
      model.addAttribute("mainList", service.getList(dto));
      //model.addAttribute("mainList", service.getList(dto));
    
      
      return "/home";
   }
   
   
   }



