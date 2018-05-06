package com.yilmazmehmet.anneminkurabiyeleri.model;

import java.io.Serializable;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;

public class KullaniciModel  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private int id;
	private String adSoyad;
	private String role;
	private String email;
	private Sepet sepet;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Sepet getSepet() {
		return sepet;
	}
	public void setSepet(Sepet sepet) {
		this.sepet = sepet;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "KullaniciModel [id=" + id + ", adSoyad=" + adSoyad + ", role="
				+ role + ", sepet=" + sepet + "]";
	}
	

}
