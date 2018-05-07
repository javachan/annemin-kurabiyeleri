package com.yilmazmehmet.anneminkurabiyeleribackend.dao;

import java.util.List;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.SepetAlani;

public interface SepetAlaniDAO {
	
	public SepetAlani get(int id);
	public boolean ekle(SepetAlani sepetAlani);
	public boolean guncelle(SepetAlani sepetAlani);
	public boolean sil(SepetAlani sepetAlani);
	public List<SepetAlani> listele(int sepetId);
	
	public List<SepetAlani> uygunOlanlariListele(int sepetId);
	public SepetAlani sepetVeUruneGoregetir(int sepetId,int urunId);
	
	
	
	boolean sepetGuncelle(Sepet sepet);
}
