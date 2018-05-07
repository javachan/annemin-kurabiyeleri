package com.yilmazmehmet.anneminkurabiyeleri.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.anneminkurabiyeleri.model.KullaniciModel;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.SepetAlaniDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.SepetAlani;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

@Service("sepetService")
public class SepetService {

	@Autowired
	private SepetAlaniDAO sepetAlaniDAO;

	@Autowired
	private HttpSession session;

	private Sepet sepetGetir() {

		return ((KullaniciModel) session.getAttribute("kullaniciModel"))
				.getSepet();
	}
	
	public List<SepetAlani> sepetAlaniGetir(){
		
 
		return sepetAlaniDAO.listele(this.sepetGetir().getId());
	}

	public String sepetAlanGuncelle(int sepetAlanId, int adet) {
		 
		SepetAlani sepetAlani=sepetAlaniDAO.get(sepetAlanId);
		
		if(sepetAlani==null){
			
			return "sonuc=hata";
		}else {
			Urun urun = sepetAlani.getUrun();
			double oldToplam=sepetAlani.getToplam();
			if(urun.getMiktar()<=adet){
				
				adet=urun.getMiktar();
			}
			
			sepetAlani.setUrunSayisi(adet);
			sepetAlani.setSatisFiyati(urun.getFiyat());
			
			sepetAlani.setToplam(urun.getFiyat()*adet);
			
			sepetAlaniDAO.guncelle(sepetAlani);
			
			Sepet sepet= this.sepetGetir();
			sepet.setToplamTutar(sepet.getToplamTutar()-oldToplam+sepetAlani.getToplam());
			
			sepetAlaniDAO.sepetGuncelle(sepet);
			
			return "sonuc=guncellendi";
		}
		
	}
}
