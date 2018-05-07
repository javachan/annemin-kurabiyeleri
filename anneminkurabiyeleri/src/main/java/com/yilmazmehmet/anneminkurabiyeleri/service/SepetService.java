package com.yilmazmehmet.anneminkurabiyeleri.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.anneminkurabiyeleri.model.KullaniciModel;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.SepetAlaniDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.UrunDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.SepetAlani;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

@Service("sepetService")
public class SepetService {

	@Autowired
	private SepetAlaniDAO sepetAlaniDAO;
	
	@Autowired
	private UrunDAO urunDAO;

	@Autowired
	private HttpSession session;

	private Sepet sepetGetir() {

		return ((KullaniciModel) session.getAttribute("kullaniciModel"))
				.getSepet();
	}
	
	public List<SepetAlani> sepetAlaniGetir(){
		
 
		return sepetAlaniDAO.listele(this.sepetGetir().getId());
	}

	public String sepetAlaniYonet(int sepetAlanId, int adet) {
		 
		SepetAlani sepetAlani=sepetAlaniDAO.get(sepetAlanId);
		
		if(sepetAlani==null){
			
			return "sonuc=hata";
		}else {
			Urun urun = sepetAlani.getUrun();
			double oldToplam=sepetAlani.getToplam();
			if(urun.getMiktar()<adet){
				
				return "sonuc=mevcutDegil";
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

	public String sepetAlanSil(int sepetAlanId) {
		 SepetAlani sepetAlani=sepetAlaniDAO.get(sepetAlanId);
		 
		 if(sepetAlani==null){
			 return "sonuc=hata";
		 }
		 else{
			 
			 Sepet sepet = this.sepetGetir();
			 sepet.setToplamTutar(sepet.getToplamTutar()-sepetAlani.getToplam());
			 sepet.setSepettekiler(sepet.getSepettekiler()-1);
			 sepetAlaniDAO.sepetGuncelle(sepet);
			 sepetAlaniDAO.sil(sepetAlani);
			 return "sonuc=silindi";
		 }
}

	public String sepetAlanEkle(int urunId) {
	 
		String response =null;
		Sepet sepet = this.sepetGetir();
		
		SepetAlani sepetAlani=sepetAlaniDAO.sepetVeUruneGoregetir(sepet.getId(), urunId);
		
		if(sepetAlani==null){
			
			sepetAlani=new SepetAlani();
			
			Urun urun = urunDAO.get(urunId); //o
			
			sepetAlani.setSepetId(sepet.getId()); //
			
			sepetAlani.setUrun(urun); //o
			
			sepetAlani.setSatisFiyati(urun.getFiyat());//o
			
			sepetAlani.setUrunSayisi(1); // ok
			
			sepetAlani.setToplam(urun.getFiyat()); // ok
			
			sepetAlani.setMevcutMu(true); //ok
			
			sepetAlaniDAO.ekle(sepetAlani); // ok
			
			sepet.setSepettekiler(sepet.getSepettekiler()+1); // ok
			sepet.setToplamTutar(sepet.getToplamTutar()+sepetAlani.getToplam()); // ok
			
			sepetAlaniDAO.sepetGuncelle(sepet);
			
			response ="sonuc=eklendi";
		}
		else {
			if(sepetAlani.getUrunSayisi()<3){
				response=this.sepetAlaniYonet(sepetAlani.getId(),sepetAlani.getUrunSayisi()+1);
				
				
			}else{
				
				response="sonuc=maximum";
			}
			
		}
		return response;
	}
	
}
