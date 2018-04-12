package com.yilmazmehmet.anneminkurabiyeleri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	
@RequestMapping(value = {"/","/anasayfa","/index"})
public ModelAndView index(){
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","Anasayfa");
	mv.addObject("anasayfaMi",true);
	return mv;
}


@RequestMapping(value = "/hakkimizda")
public ModelAndView hakkimizda(){
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","Hakkimizda");
	mv.addObject("hakkimizdaMi",true);
	return mv;
}

@RequestMapping(value = "/iletisim")
public ModelAndView iletisim(){
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","Iletisim");
	mv.addObject("iletisimMi",true);
	return mv;
}
/*
@RequestMapping(value="/test")
public ModelAndView test(@RequestParam(value="greating",required=false)String greating){
	if(greating==null){
		greating="Hello There";
	}
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting",greating);
	return mv;
}*/

@RequestMapping(value="/test/{greating}")
public ModelAndView test(@PathVariable("greating")String greating){
	if(greating==null){
		greating="Hello There";
	}
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","Anasayfa");
	return mv;
}
}
