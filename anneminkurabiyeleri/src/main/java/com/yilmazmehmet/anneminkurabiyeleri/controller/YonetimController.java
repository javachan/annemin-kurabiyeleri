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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yilmazmehmet.anneminkurabiyeleri.util.DosyaYuklemeU;
import com.yilmazmehmet.anneminkurabiyeleri.validason.UrunValidasyon;
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
	
	@RequestMapping(value="/{id}/urun",method=RequestMethod.GET)
	public ModelAndView urunleriDuzenle(@PathVariable int id){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("urunYonetimMi",true);
		mv.addObject("title","Urunleri Yonet");
		
		Urun yeniUrun= urunDA.get(id);
		yeniUrun.setSaticiId(1);
		yeniUrun.setAktifMi(true);
		mv.addObject("urun",yeniUrun);
		
		 
		return mv;
		
	}
	@RequestMapping(value="/urunler",method=RequestMethod.POST)
	public String urunlerPostEtme(@Valid @ModelAttribute("urun") Urun mUrun ,BindingResult results, Model model,HttpServletRequest request){
		
		
		if(mUrun.getId()==0){
			
			new UrunValidasyon().validate(mUrun, results);
		}else{
			
			if(!mUrun.getFile().getOriginalFilename().equals("")){
				new UrunValidasyon().validate(mUrun, results);

				
			}
		}
		
		
		
		if(results.hasErrors()){
			
			model.addAttribute("urunYonetimMi",true);
			model.addAttribute("title","Urunleri Yonet");
			model.addAttribute("mesaj","Eksik yerleri doldurunuz !!");
			return "page";
		}
		
		
		logger.info(mUrun.toString());
		//yeni urun kaydet
		if(mUrun.getId()==0){
				urunDA.ekle(mUrun);}
		else{
			
			urunDA.guncelle(mUrun);
		}
				
				
				
		if(!mUrun.getFile().getOriginalFilename().equals("")){
			
			DosyaYuklemeU.dosyaYukle(request,mUrun.getFile(),mUrun.getKod());
			
		}		
				
				
				
		return "redirect:/yonetim/urunler?operation=urun"; 
	}
	@RequestMapping(value="/urun/{id}/aktifEtme",method=RequestMethod.POST)
	@ResponseBody
	public String urunAktifEtme(@PathVariable int id){
		Urun urun =urunDA.get(id);
		boolean aktifMi=urun.isAktifMi();
		urun.setAktifMi(!urun.isAktifMi());
		urunDA.guncelle(urun);
		return (aktifMi) ? urun.getId() + " Numarali Urun Deaktif edilmistir . " 
				: urun.getId() + " Numarali Urun aktif edilmistir . " ;
		
	}
	@ModelAttribute("kategoriler")
	public List<Kategori> kategorileriGetir(){
		
		return kategoriDAO.listele();
	}

}
