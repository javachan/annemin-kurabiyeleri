package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sepet_alani")
public class SepetAlani implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@OneToOne
	private Urun urun;
	
	@Column(name="sepet_id")
	private int sepetId;
	
	@Column(name="urun_sayisi")
	private int urunSayisi;
	
	private double toplam;
	
	@Column(name="satis_fiyati")
	private double satisFiyati;
	
	@Column(name="mevcut_mu")
	private boolean mevcutMu=true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Urun getUrun() {
		return urun;
	}

	public void setUrun(Urun urun) {
		this.urun = urun;
	}

	public int getSepetId() {
		return sepetId;
	}

	public void setSepetId(int sepetId) {
		this.sepetId = sepetId;
	}

	public int getUrunSayisi() {
		return urunSayisi;
	}

	public void setUrunSayisi(int urunSayisi) {
		this.urunSayisi = urunSayisi;
	}

	public double getToplam() {
		return toplam;
	}

	public void setToplam(double toplam) {
		this.toplam = toplam;
	}

	public double getSatisFiyati() {
		return satisFiyati;
	}

	public void setSatisFiyati(double satisFiyati) {
		this.satisFiyati = satisFiyati;
	}

	public boolean isMevcutMu() {
		return mevcutMu;
	}

	public void setMevcutMu(boolean mevcutMu) {
		this.mevcutMu = mevcutMu;
	}

	@Override
	public String toString() {
		return "SepetAlani [id=" + id + ", urun=" + urun + ", sepetId="
				+ sepetId + ", urunSayisi=" + urunSayisi + ", toplam=" + toplam
				+ ", satisFiyati=" + satisFiyati + ", mevcutMu=" + mevcutMu
				+ "]";
	}

}
