package com.yilmazmehmet.anneminkurabiyeleribackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KullaniciDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Adres;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;


@Repository("kullaniciDAO")
@Transactional
public class KullaniciDAOImpl implements KullaniciDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean kullaniciEkle(Kullanici kullanici) {
		try {
			sessionFactory.getCurrentSession().persist(kullanici);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean adresEkle(Adres adres) {
		try {
			sessionFactory.getCurrentSession().persist(adres);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean sepetGuncelle(Sepet sepet) {
		try {
			sessionFactory.getCurrentSession().update(sepet);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Kullanici emaileGoreGetir(String email) {
		String selectQuery="FROM Kullanici WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Kullanici.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {
			// e.printStackTrace();
			 return null;
		}
		 
	}

	@Override
	public Adres faturaAdresiGetir(Kullanici kullanici) {
		String selectQuery ="FROM Adres WHERE kullanici=:kullanici AND fatura=:fatura";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Adres.class)
					.setParameter("kullanici", kullanici)
					.setParameter("fatura", true)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Adres> kargoAdresleriniListele(Kullanici kullanici) {
		String selectQuery ="FROM Adres WHERE kullanici=:kullanici AND kargo=:kargo";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Adres.class)
					.setParameter("kullanici", kullanici)
					.setParameter("kargo", true)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Adres faturaAdresiGetir(int kullaniciId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adres> kargoAdresleriniListele(int kullaniciId) {
		// TODO Auto-generated method stub
		return null;
	}

}
