package com.yilmazmehmet.anneminkurabiyeleribackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.UrunDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

public class UrunTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UrunDAO urunDAO;
	private Urun urun;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.yilmazmehmet.anneminkurabiyeleribackend");
		context.refresh();
		urunDAO = (UrunDAO) context.getBean("urunDAO");
	}
/*
	@Test
	public void testCRUDUrun() {

		urun = new Urun();
		urun.setAd("Muzlu Ekler");
		urun.setMarka("Ekler Evi");
		urun.setAciklama("En iyi ekler...");
		urun.setFiyat(25000);
		urun.setAktifMi(true);
		urun.setKategoriId(5);
		urun.setSaticiId(3);
		assertEquals("Urun eklenirken ters giden seyler oldu", true,
				urunDAO.ekle(urun));

		urun = urunDAO.get(4);
		urun.setAd("Cukulotalı Makaron");
		assertEquals("Urun guncellenirken ters giden seyler oldu", true,
				urunDAO.guncelle(urun));
		
		assertEquals("Urun silerken ters giden seyler oldu", true,
				urunDAO.sil(urun));
		
		assertEquals("Urun listelerken ters giden seyler oldu", 7,
				urunDAO.listele().size());
		
		
		

	}
	*/
	@Test 
	public void testAktifUrunler(){
		
		assertEquals("Urun listelerken ters giden seyler oldu", 6,
				urunDAO.aktifUrunleriListele().size());
	}
	
	@Test 
	public void testAktifUrunlerKategoriyeGore(){
		
		assertEquals("Urun listelerken ters giden seyler oldu", 1,
				urunDAO.aktifUrunleriKategoriyeGoreListele(3).size());
	}
	
	@Test 
	public void testSonAktifUrunler(){
		
		assertEquals("Urun listelerken ters giden seyler oldu", 3,
				urunDAO.sonAktifUrunleriGetir(3).size());
	}

}
