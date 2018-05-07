package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import java.util.List;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Adres;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;
 
public interface KullaniciDAO {

	boolean kullaniciEkle(Kullanici kullanici);
	Kullanici emaileGoreGetir(String email);
	
	boolean adresEkle(Adres adres);
	//alternatif
	Adres faturaAdresiGetir(int kullaniciId);
	List<Adres> kargoAdresleriniListele(int kullaniciId);
	
	Adres faturaAdresiGetir(Kullanici kullanici);
	List<Adres> kargoAdresleriniListele(Kullanici kullanici);
	
	

	
}
