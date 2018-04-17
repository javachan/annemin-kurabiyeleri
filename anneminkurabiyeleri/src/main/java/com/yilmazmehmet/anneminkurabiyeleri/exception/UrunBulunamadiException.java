package com.yilmazmehmet.anneminkurabiyeleri.exception;

import java.io.Serializable;

public class UrunBulunamadiException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mesaj;

	public String getMesaj() {
		return mesaj;
	}

	

	public UrunBulunamadiException() {

		this("Urun bulunamadý !");

	}
	
	public UrunBulunamadiException(String mesaj){
		
		this.mesaj=System.currentTimeMillis()+":"+mesaj;
	}
}
