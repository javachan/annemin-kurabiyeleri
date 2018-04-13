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
public static void init(){
	
	context=new AnnotationConfigApplicationContext();
	context.scan("com.yilmazmehmet.anneminkurabiyeleribackend");
	context.refresh();
	kategoriDAO=(KategoriDAO)context.getBean("kategoriDAO");
}

@Test
public void testKategoriEkle(){
	kategori=new Kategori();
	
	kategori.setAd("Makaron");
	kategori.setAciklama("Makaron Açıklama");
	kategori.setResimUrl("KAT_3.png");
	assertEquals("Successfully added a category inside the table!",true,kategoriDAO.ekle(kategori));
}
}
