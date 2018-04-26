package com.yilmazmehmet.anneminkurabiyeleri.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yilmazmehmet.anneminkurabiyeleri.util.DosyaYuklemeU;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KategoriDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.UrunDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

@Controller
@RequestMapping("/yonetim")
public class YonetimController {
	
	@Autowired
	private KategoriDAO kategoriDAO;
	
	@Autowired
	private UrunDAO urunDA;
	private static Logger logger=LoggerFactory.getLogger(YonetimController.class);
	
	
	@RequestMapping(value="/urunler",method=RequestMethod.GET)
	public ModelAndView urunleriYonet(@RequestParam(name="operation",required=false)String operation){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("urunYonetimMi",true);
		mv.addObject("title","Urunleri Yonet");
		
		Urun yeniUrun= new Urun();
		yeniUrun.setSaticiId(1);
		yeniUrun.setAktifMi(true);
		mv.addObject("urun",yeniUrun);
		
		if(operation!=null){
			if(operation.equals("urun")){
				
				mv.addObject("mesaj","Urun Basarili Sekilde Gonderildi");
			}
			
		}
		return mv;
		
	}
	
	@RequestMapping(value="/urunler",method=RequestMethod.POST)
	public String urunlerPostEtme(@Valid @ModelAttribute("urun") Urun mUrun ,BindingResult results, Model model,HttpServletRequest request){
		if(results.hasErrors()){
			
			model.addAttribute("urunYonetimMi",true);
			model.addAttribute("title","Urunleri Yonet");
			model.addAttribute("mesaj","Eksik yerleri doldurunuz !!");
			return "page";
		}
		
		
		logger.info(mUrun.toString());
		//yeni urun kaydet
				urunDA.ekle(mUrun);
				
				
				
		if(!mUrun.getFile().getOriginalFilename().equals("")){
			
			DosyaYuklemeU.dosyaYukle(request,mUrun.getFile(),mUrun.getKod());
			
		}		
				
				
				
		return "redirect:/yonetim/urunler?operation=urun"; 
	}
	
	@ModelAttribute("kategoriler")
	public List<Kategori> kategorileriGetir(){
		
		return kategoriDAO.listele();
	}

}
