package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sepet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int kullaniciId;
	private double toplamTutar;
	private int sepettekiler;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public double getToplamTutar() {
		return toplamTutar;
	}
	public void setToplamTutar(double toplamTutar) {
		this.toplamTutar = toplamTutar;
	}
	public int getSepettekiler() {
		return sepettekiler;
	}
	public void setSepettekiler(int sepettekiler) {
		this.sepettekiler = sepettekiler;
	}
	@Override
	public String toString() {
		return "Sepet [id=" + id + ", kullaniciId=" + kullaniciId
				+ ", toplamTutar=" + toplamTutar + ", sepettekiler="
				+ sepettekiler + "]";
	}
	
}
