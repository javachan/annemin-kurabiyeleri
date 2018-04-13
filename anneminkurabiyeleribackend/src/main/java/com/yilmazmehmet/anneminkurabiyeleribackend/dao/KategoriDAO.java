package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import java.util.List;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;



public interface KategoriDAO {
	boolean ekle(Kategori kategori);
	List<Kategori> listele();
	Kategori get(int id);
	
}
