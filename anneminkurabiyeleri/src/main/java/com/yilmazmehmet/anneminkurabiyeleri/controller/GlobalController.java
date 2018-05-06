package com.yilmazmehmet.anneminkurabiyeleri.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yilmazmehmet.anneminkurabiyeleri.model.KullaniciModel;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KullaniciDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private KullaniciDAO kullaniciDAO;
	
	private KullaniciModel kullaniciModel=null;
	@ModelAttribute("kullaniciModel")
	public KullaniciModel getKullaniciModel(){
		
		
		if(session.getAttribute("kullaniciModel")==null){
			
			Authentication auth=SecurityContextHolder.getContext().getAuthentication();
			Kullanici kullanici=kullaniciDAO.emaileGoreGetir(auth.getName());
			if(kullanici!=null){
				kullaniciModel=new KullaniciModel();
				kullaniciModel.setId(kullanici.getId());
				kullaniciModel.setEmail(kullanici.getEmail());
				kullaniciModel.setRole(kullanici.getRole());
				kullaniciModel.setAdSoyad(kullanici.getAd() + " " + kullanici.getSoyad());
				
				if(kullaniciModel.getRole().equals("KULLANICI")){
					
					
					kullaniciModel.setSepet(kullanici.getSepet());
				}
				
				session.setAttribute("kullaniciModel", kullaniciModel);
			}
		
		}
		
		return (KullaniciModel)session.getAttribute("kullaniciModel");
	}
	
}
