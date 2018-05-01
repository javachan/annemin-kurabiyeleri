package com.yilmazmehmet.anneminkurabiyeleribackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KullaniciDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Adres;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;

public class KullaniciTestCase {
	private static AnnotationConfigApplicationContext context;
	private static KullaniciDAO kullaniciDAO;
	private Kullanici kullanici = null;
	private Sepet sepet = null;
	private Adres adres = null;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.yilmazmehmet.anneminkurabiyeleribackend");
		context.refresh();
		kullaniciDAO = (KullaniciDAO) context.getBean("kullaniciDAO");
	}

	/*
	 * @Test public void testEkle(){
	 * 
	 * kullanici=new Kullanici(); kullanici.setAd("Hasan");
	 * kullanici.setSoyad("Mutlu"); kullanici.setEmail("hm@gmail.com");
	 * kullanici.setRole("KULLANICI"); kullanici.setSifre("123456");
	 * 
	 * // kullanici ekle
	 * 
	 * assertEquals("Kullanici eklerken hata oldu",true,kullaniciDAO.kullaniciEkle
	 * (kullanici));
	 * 
	 * adres=new Adres(); adres.setAdresBir("Colakli Mah. 43B");
	 * adres.setAdresIki("Sok market yani"); adres.setSehir("Antalya");
	 * adres.setIlce("Manavgat"); adres.setUlke("Turkiye");
	 * adres.setPostaKodu("07605"); adres.setFatura(true);
	 * adres.setKullaniciId(kullanici.getId());
	 * 
	 * assertEquals("Adres eklerken hata oldu",true,kullaniciDAO.adresEkle(adres)
	 * );
	 * 
	 * if(kullanici.getRole().equals("KULLANICI")){ sepet=new Sepet();
	 * sepet.setKullanici(kullanici);
	 * assertEquals("Sepet eklerken hata oldu",true
	 * ,kullaniciDAO.sepetEkle(sepet));
	 * 
	 * 
	 * adres=new Adres(); adres.setAdresBir("Colakli Mah. 43B");
	 * adres.setAdresIki("Sok market yani"); adres.setSehir("Antalya");
	 * adres.setIlce("Manavgat"); adres.setUlke("Turkiye");
	 * adres.setPostaKodu("07605"); adres.setKargo(true);
	 * adres.setKullaniciId(kullanici.getId());
	 * assertEquals("Adres eklerken hata oldu"
	 * ,true,kullaniciDAO.adresEkle(adres));
	 * 
	 * 
	 * }
	 * 
	 * }
	 */
	/*
	@Test
	public void testEkle() {

		kullanici = new Kullanici();
		kullanici.setAd("Hasan");
		kullanici.setSoyad("Mutlu");
		kullanici.setEmail("hm@gmail.com");
		kullanici.setRole("KULLANICI");
		kullanici.setSifre("123456");
		kullanici.setTelefon("05374942346");

		
		 

		if (kullanici.getRole().equals("KULLANICI")) {
			sepet = new Sepet();
			sepet.setKullanici(kullanici);
			
			kullanici.setSepet(sepet);
			 
 
		}
		
		// kullanici ekle

				assertEquals("Kullanici eklerken hata oldu", true,
						kullaniciDAO.kullaniciEkle(kullanici));


	}*/
	@Test 
	public void testSepetGuncelle(){
		
		kullanici=kullaniciDAO.emaileGoreGetir("hm@gmail.com");
		sepet=kullanici.getSepet();
		sepet.setToplamTutar(5555);
		sepet.setSepettekiler(2);
		assertEquals("Sepet guncelleniren hata olustu", true,kullaniciDAO.sepetGuncelle(sepet));
		
	}

}
