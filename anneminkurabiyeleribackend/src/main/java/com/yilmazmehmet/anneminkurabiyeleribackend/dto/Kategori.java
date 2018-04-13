package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kategori") 
public class Kategori {
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public String getResimUrl() {
		return resimUrl;
	}
	public void setResimUrl(String resimUrl) {
		this.resimUrl = resimUrl;
	}
	public boolean isAktif() {
		return aktif;
	}
	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}
	
	@Override
	public String toString() {
		return "Kategori [id=" + id + ", ad=" + ad + ", aciklama=" + aciklama
				+ ", resimUrl=" + resimUrl + ", aktif=" + aktif + "]";
	}
	
	
	/*
	 * Private alanlar
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	



	private String ad;
	private String aciklama;
	private String resimUrl;
	private boolean aktif=true;

}
