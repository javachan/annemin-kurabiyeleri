package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="kullanici_detay")
public class Kullanici implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Lutfen Ad Giriniz !")
	private String ad;
	
	@NotBlank(message="Lutfen Soyad Giriniz !")
	private String soyad;
	
	@NotBlank(message="Lutfen Email Giriniz !")
	private String email;
	
	@NotBlank(message="Lutfen Telefon Giriniz !")
	private String telefon;
	
	
	private String role;
	
	@NotBlank(message="Lutfen Sifre Giriniz !")
	private String sifre;
	private boolean aktifmi=true;
	
	
	
	// sifre onaylama alani
	@Transient
	private String sifreOnayla;
	
	
	
	public String getSifreOnayla() {
		return sifreOnayla;
	}
	public void setSifreOnayla(String sifreOnayla) {
		this.sifreOnayla = sifreOnayla;
	}
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
