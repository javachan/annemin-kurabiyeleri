package com.yilmazmehmet.anneminkurabiyeleribackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KullaniciDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.SepetAlaniDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.UrunDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.SepetAlani;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

public class CartLineTestCase {
	private static AnnotationConfigApplicationContext context;

	private static SepetAlaniDAO sepetAlaniDAO=null;
	private static UrunDAO urunDAO=null;
	private static KullaniciDAO kullaniciDAO=null;
	
	
	private Urun urun=null;
	private Kullanici kullanici=null;
	private Sepet sepet =null;
	private SepetAlani sepetAlani=null;
		
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.yilmazmehmet.anneminkurabiyeleribackend");
		context.refresh();
		urunDAO = (UrunDAO) context.getBean("urunDAO");
		kullaniciDAO = (KullaniciDAO) context.getBean("kullaniciDAO");
		sepetAlaniDAO = (SepetAlaniDAO) context.getBean("sepetAlaniDAO");
	}

	
	@Test
	public void testYeniSepetAlaniEkle(){
		
		kullanici=kullaniciDAO.emaileGoreGetir("mehmet@cankaya.pro");
		sepet=kullanici.getSepet();
		
		urun=urunDAO.get(1);
		
		sepetAlani=new SepetAlani();
		sepetAlani.setUrun(urun);
		sepetAlani.setSatisFiyati(urun.getFiyat());
		
		sepetAlani.setUrunSayisi(sepetAlani.getUrunSayisi()+1);
		
		sepetAlani.setToplam(sepetAlani.getUrunSayisi()*urun.getFiyat());
		
		sepetAlani.setMevcutMu(true);
		sepetAlani.setSepetId(sepet.getId());
		
		
		assertEquals("Sepet alaniinda eklerken hat avar ",true,sepetAlaniDAO.ekle(sepetAlani));
		
		
		sepet.setToplamTutar(sepet.getToplamTutar()+sepetAlani.getToplam());
		sepet.setSepettekiler(sepet.getSepettekiler()+1);
		
		assertEquals("Sepet alaniinda guncellerken hat avar ",true,sepetAlaniDAO.sepetGuncelle(sepet));
		
	}
}
