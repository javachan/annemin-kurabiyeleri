package com.yilmazmehmet.anneminkurabiyeleribackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KategoriDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kategori;

@Repository("kategoriDAO")
@Transactional
public class KategoriDAOImpl implements KategoriDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Kategori> listele() {
		String aktifKategoriGetir="FROM Kategori WHERE aktif=:aktif";
		Query query = sessionFactory.getCurrentSession().createQuery(aktifKategoriGetir);
		query.setParameter("aktif", true);
		
		return query.getResultList();
	}
	
	/*
	@Override
	public List<Kategori> listele() {
		String aktifKategoriGetir="FROM Kategori WHERE aktif=:aktif";
		Query query = sessionFactory.getCurrentSession().createQuery(aktifKategoriGetir);
		query.setFirstResult(0);
		query.setMaxResults(1);
		query.setParameter("aktif", true);
		
		return query.getResultList();
	}
*/
	// tek kategori getirme
	@Override
	public Kategori get(int id) {

		return sessionFactory.getCurrentSession().get(Kategori.class,
				Integer.valueOf(id));
	}

	@Override
	public boolean ekle(Kategori kategori) {
		try {

			sessionFactory.getCurrentSession().persist(kategori);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	//tek kategoriye güncelleme
	@Override
	public boolean guncelle(Kategori kategori) {
		try {

			sessionFactory.getCurrentSession().update(kategori);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean sil(Kategori kategori) {
		kategori.setAktif(false);
		try {

			sessionFactory.getCurrentSession().update(kategori);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
