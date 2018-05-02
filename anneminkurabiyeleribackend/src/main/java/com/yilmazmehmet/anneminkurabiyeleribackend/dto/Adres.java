package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adres {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/*----*/
	@ManyToOne
	private Kullanici kullanici;
	public Kullanici getKullanici() {
		return kullanici;
	}
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	private String adresBir;
	private String adresIki;
	private String sehir;
	private String ilce;
	private String ulke;
	private String postaKodu;
	private boolean kargo;
	private boolean fatura;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	public String getAdresBir() {
		return adresBir;
	}
	public void setAdresBir(String adresBir) {
		this.adresBir = adresBir;
	}
	public String getAdresIki() {
		return adresIki;
	}
	public void setAdresIki(String adresIki) {
		this.adresIki = adresIki;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public String getIlce() {
		return ilce;
	}
	public void setIlce(String ilce) {
		this.ilce = ilce;
	}
	public String getUlke() {
		return ulke;
	}
	public void setUlke(String ulke) {
		this.ulke = ulke;
	}
	public String getPostaKodu() {
		return postaKodu;
	}
	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
	public boolean isKargo() {
		return kargo;
	}
	public void setKargo(boolean kargo) {
		this.kargo = kargo;
	}
	public boolean isFatura() {
		return fatura;
	}
	public void setFatura(boolean fatura) {
		this.fatura = fatura;
	}
	@Override
	public String toString() {
		return "Adres [id=" + id +  ", adresBir=" + adresBir + ", adresIki=" + adresIki
				+ ", sehir=" + sehir + ", ilce=" + ilce + ", ulke=" + ulke
				+ ", postaKodu=" + postaKodu + ", kargo=" + kargo + ", fatura="
				+ fatura + "]";
	}
	 

}
