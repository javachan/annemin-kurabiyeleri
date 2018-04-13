package com.yilmazmehmet.anneminkurabiyeleri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KategoriDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;

@Controller
public class PageController {
	
	@Autowired 
	private KategoriDAO kategoriDAO;
	
	
@RequestMapping(value = {"/","/anasayfa","/index"})
public ModelAndView index(){
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","Anasayfa");
	//kategorilri getirme
	mv.addObject("kategoriler",kategoriDAO.listele());
	
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
/*tüm ürünleri yükleyen method kategoride*/
@RequestMapping(value ="/goster/hepsi/urunler")
public ModelAndView urunleriListele(){
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","Tum Urunler");
	//kategorilri getirme
	mv.addObject("kategoriler",kategoriDAO.listele());
	
	mv.addObject("tumUrunleriListeleMi",true);
	return mv;
}

@RequestMapping(value ="/goster/kategori/{id}/urunler")
public ModelAndView kategoriyeGoreListele(@PathVariable("id") int id){
	
	ModelAndView mv = new ModelAndView("page");
	
	//tek kategoriye göre  kategoriDAO getirme
	Kategori kategori=null;
	kategori=kategoriDAO.get(id);
	mv.addObject("title",kategori.getAd());
	//kategori listesini gönderme
	mv.addObject("kategoriler",kategoriDAO.listele());
	//tek kategori objesini gönderme
		mv.addObject("kategori",kategori);
	mv.addObject("kategoriyeGoreListeliMi",true);
	return mv;
}
}
