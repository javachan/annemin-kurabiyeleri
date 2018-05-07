package com.yilmazmehmet.anneminkurabiyeleribackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.UrunDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

@Repository("urunDAO")
@Transactional
public class UrunDAOImpl implements UrunDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// tek ürün
	@Override
	public Urun get(int urunId) {
		try {

			return sessionFactory.getCurrentSession().get(Urun.class,
					Integer.valueOf(urunId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Urun> listele() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Urun", Urun.class).getResultList();
	}

	// urun ekleme
	@Override
	public boolean ekle(Urun urun) {
		try {
			sessionFactory.getCurrentSession().persist(urun);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean guncelle(Urun urun) {
		try {
			sessionFactory.getCurrentSession().update(urun);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean sil(Urun urun) {
		try {
			urun.setAktifMi(false);
			return this.guncelle(urun);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Urun> aktifUrunleriListele() {
		String query = "FROM Urun WHERE aktifMi=:aktifMi";

		return sessionFactory.getCurrentSession()
				.createQuery(query, Urun.class).setParameter("aktifMi", true)
				.getResultList();
	}

	@Override
	public List<Urun> aktifUrunleriKategoriyeGoreListele(int kategoriId) {
		String query = "FROM Urun WHERE aktifMi=:aktifMi AND kategoriId = :kategoriId";

		return sessionFactory.getCurrentSession()
				.createQuery(query, Urun.class).setParameter("aktifMi", true)
				.setParameter("kategoriId", kategoriId).getResultList();

	}

	@Override
	public List<Urun> sonAktifUrunleriGetir(int sayi) {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Urun WHERE aktifMi = :aktifMi ORDER BY id",
						Urun.class).setParameter("aktifMi", true)
				.setFirstResult(0).setMaxResults(sayi).getResultList();
	}

	@Override
	public List<Urun> listeleAnasayfa() {
		
		String anasayfa="FROM Urun WHERE aktifMi=:aktifMi";
		Query query = sessionFactory.getCurrentSession().createQuery(anasayfa);
		query.setFirstResult(0);
		query.setMaxResults(9);
		query.setParameter("aktifMi", true);
		
		return query.getResultList();
		
		
		
		 
	}

	@Override
	public List<Urun> listeleSlide() {
		String anasayfa="FROM Urun WHERE aktifMi=:aktifMi";
		Query query = sessionFactory.getCurrentSession().createQuery(anasayfa);
		query.setFirstResult(0);
		query.setMaxResults(3);
		query.setParameter("aktifMi", true);
		
		return query.getResultList();
	}

}
