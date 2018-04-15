package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import java.util.List;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;



public interface KategoriDAO {
	Kategori get(int id);
	List<Kategori> listele();
	boolean ekle(Kategori kategori);
	boolean guncelle(Kategori kategori);
	boolean sil(Kategori kategori);
	
}
