package com.yilmazmehmet.anneminkurabiyeleri.model;

import java.io.Serializable;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Adres;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;

public class KayitModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Kullanici kullanici;
	private Adres fatura;
	public Kullanici getKullanici() {
		return kullanici;
	}
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	public Adres getFatura() {
		return fatura;
	}
	public void setFatura(Adres fatura) {
		this.fatura = fatura;
	}
	 

}
