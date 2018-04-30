package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Adres;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;

public interface KullaniciDAO {

	boolean kullaniciEkle(Kullanici kullanici);
	
	boolean adresEkle(Adres adres);
	
	boolean sepetEkle(Sepet sepet);
	
}
