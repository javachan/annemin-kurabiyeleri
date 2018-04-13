package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import java.util.List;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;



public interface KategoriDAO {
 
	List<Kategori> listele();
	Kategori get(int id);
	
}
