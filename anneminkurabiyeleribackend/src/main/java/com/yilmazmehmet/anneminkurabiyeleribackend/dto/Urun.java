package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Urun {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String kod;
	private String ad;
	private String marka;
	@JsonIgnore
	private String aciklama;
	private double fiyat;
	private int miktar;
	@JsonIgnore
	private boolean aktifMi;
	@Column(name="kategori_id")
	@JsonIgnore
	private int kategoriId;
	@Column(name="satici_id")
	@JsonIgnore
	private int saticiId;
	private int satinAlma;
	private int goruntulenme;
	
	public Urun(){
		
		this.kod="AK"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	public int getMiktar() {
		return miktar;
	}
	public void setMiktar(int miktar) {
		this.miktar = miktar;
	}
	public boolean isAktifMi() {
		return aktifMi;
	}
	public void setAktifMi(boolean aktifMi) {
		this.aktifMi = aktifMi;
	}
	public int getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}
	public int getSaticiId() {
		return saticiId;
	}
	public void setSaticiId(int saticiId) {
		this.saticiId = saticiId;
	}
	public int getSatinAlma() {
		return satinAlma;
	}
	public void setSatinAlma(int satinAlma) {
		this.satinAlma = satinAlma;
	}
	public int getGoruntulenme() {
		return goruntulenme;
	}
	public void setGoruntulenme(int goruntulenme) {
		this.goruntulenme = goruntulenme;
	}
	@Override
	public String toString() {
		return "Urun [id=" + id + ", kod=" + kod + ", ad=" + ad + ", marka="
				+ marka + ", aciklama=" + aciklama + ", fiyat=" + fiyat
				+ ", miktar=" + miktar + ", aktifMi=" + aktifMi
				+ ", kategoriId=" + kategoriId + ", saticiId=" + saticiId
				+ ", satinAlma=" + satinAlma + ", goruntulenme=" + goruntulenme
				+ "]";
	}
	
	

}
