package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="kullanici_detay")
public class Kullanici {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String ad;
	private String soyad;
	private String email;
	private String telefon;
	private String role;
	private String sifre;
	private boolean aktifmi=true;
	
	@OneToOne(mappedBy="kullanici",cascade=CascadeType.ALL)
	private Sepet sepet;
	
	public Sepet getSepet() {
		return sepet;
	}
	public void setSepet(Sepet sepet) {
		this.sepet = sepet;
	}
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
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public boolean isAktifmi() {
		return aktifmi;
	}
	public void setAktifmi(boolean aktifmi) {
		this.aktifmi = aktifmi;
	}
	@Override
	public String toString() {
		return "Kullanici [id=" + id + ", ad=" + ad + ", soyad=" + soyad
				+ ", email=" + email + ", telefon=" + telefon + ", role="
				+ role + ", sifre=" + sifre + ", aktifmi=" + aktifmi + "]";
	}
	

}
