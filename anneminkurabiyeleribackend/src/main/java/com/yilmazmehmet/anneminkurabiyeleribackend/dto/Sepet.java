package com.yilmazmehmet.anneminkurabiyeleribackend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sepet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	/*------------*/
	@OneToOne
	private Kullanici kullanici;

	public Kullanici getKullanici() {
		return kullanici;
	}
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
	/*------------*/
	private double toplamTutar;
	private int sepettekiler;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Sepet [id=" + id + ", kullanici=" + kullanici
				+ ", toplamTutar=" + toplamTutar + ", sepettekiler="
				+ sepettekiler + "]";
	}
	
	/*
	@Override
	public String toString() {
		return "Sepet [id=" + id 
				+ ", toplamTutar=" + toplamTutar + ", sepettekiler="
				+ sepettekiler + "]";
	}*/
	
}
