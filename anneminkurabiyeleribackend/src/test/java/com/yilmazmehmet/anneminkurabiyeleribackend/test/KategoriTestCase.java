package com.yilmazmehmet.anneminkurabiyeleribackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KategoriDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;

public class KategoriTestCase {
	private static AnnotationConfigApplicationContext context;

	private static KategoriDAO kategoriDAO;

	private static Kategori kategori;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.yilmazmehmet.anneminkurabiyeleribackend");
		context.refresh();
		kategoriDAO = (KategoriDAO) context.getBean("kategoriDAO");
	}

	/*
	 * @Test public void testKategoriEkle(){ kategori=new Kategori();
	 * 
	 * kategori.setAd("Makaron"); kategori.setAciklama("Makaron Açıklama");
	 * kategori.setResimUrl("KAT_3.png");
	 * assertEquals("Successfully added a category inside the table!"
	 * ,true,kategoriDAO.ekle(kategori)); }
	 */

	/*
	 * @Test public void testKategoriGetir(){
	 * 
	 * kategori=kategoriDAO.get(3);
	 * assertEquals("idsi verilen kategori başarılı şekilde getirildi"
	 * ,"Makaron",kategori.getAd());
	 * 
	 * }
	 */
	/*
	 * @Test public void testKategoriGuncelle() {
	 * 
	 * kategori = kategoriDAO.get(3);
	 * kategori.setAciklama("Makaron yeni aciklama"); assertEquals(
	 * "idsi verilen kategorinin aciklamasi başarılı şekilde guncellendi", true,
	 * kategoriDAO.guncelle(kategori));
	 * 
	 * }
	 */
/*
	@Test
	public void testKategoriSil() {

		kategori = kategoriDAO.get(4);
		
		assertEquals(
				"idsi verilen kategorinin aciklamasi başarılı şekilde silindi",
				true, kategoriDAO.sil(kategori));

	}*/
	/*
	@Test
	public void testKategoriListele() {

		
		
		assertEquals(
				"Kategoriler başarılı şekilde getirildi",3, kategoriDAO.listele().size());

	}*/
	
	@Test
	public void testCRUDKategori(){
		
		
		
	}
}
