package com.yilmazmehmet.anneminkurabiyeleri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	
@RequestMapping(value = {"/","/home","/index"})
public ModelAndView index(){
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting","Welcome to Spring Web Mvc");
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
	mv.addObject("greeting",greating);
	return mv;
}
}
