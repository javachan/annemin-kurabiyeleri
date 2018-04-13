package com.yilmazmehmet.anneminkurabiyeleribackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KategoriDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;

@Repository("kategoriDAO")
public class KategoriDAOImpl implements KategoriDAO {
	private static List<Kategori> kategoriler = new ArrayList<>();
	static{
		
		Kategori kategori=new Kategori();
		kategori.setId(1);
		kategori.setAd("Tuzlu Kurabiye");
		kategori.setAciklama("Tuzlu kurabiye Açıklama");
		kategori.setResimUrl("KAT_1.png");
		
		
		
		kategoriler.add(kategori);
		
		/// ikinci örnek
		
		kategori=new Kategori();
		kategori.setId(2);
		kategori.setAd("Tatli Kurabiye");
		kategori.setAciklama("Tatlı kurabiye Açıklama");
		kategori.setResimUrl("KAT_2.png");
		
		kategoriler.add(kategori);
		
		
		/// üçüncü örnek
		
				kategori=new Kategori();
				kategori.setId(3);
				kategori.setAd("Makaron");
				kategori.setAciklama("Makaron Açıklama");
				kategori.setResimUrl("KAT_3.png");
				
				kategoriler.add(kategori);
	}
	@Override
	public List<Kategori> listele() {
		// TODO Auto-generated method stub
		return kategoriler;
	}
	@Override
	public Kategori get(int id) {
		//enchanced for loop
		
		for(Kategori kategori:kategoriler){
			
			if(kategori.getId()==id) return kategori;
		}
		
		return null;
	}

}
