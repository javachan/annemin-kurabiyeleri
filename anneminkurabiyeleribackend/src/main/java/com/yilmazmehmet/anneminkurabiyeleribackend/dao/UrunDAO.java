package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import java.util.List;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

public interface UrunDAO {

	Urun get(int urunId);
	List<Urun> listele();
	List<Urun> listeleAnasayfa();
	List<Urun> listeleSlide();
	boolean ekle(Urun urun);
	boolean guncelle(Urun urun);
	boolean sil(Urun urun);
	
	
	List<Urun> aktifUrunleriListele();
	List<Urun> aktifUrunleriKategoriyeGoreListele(int kategoriId);
	List<Urun> sonAktifUrunleriGetir(int sayi);
	
}
