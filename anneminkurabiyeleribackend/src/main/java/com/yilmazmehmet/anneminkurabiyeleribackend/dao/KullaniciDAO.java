package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Adres;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;

public interface KullaniciDAO {

	boolean kullaniciEkle(Kullanici kullanici);
	Kullanici emaileGoreGetir(String email);
	
	boolean adresEkle(Adres adres);
	
	boolean sepetGuncelle(Sepet sepet);
	
}
