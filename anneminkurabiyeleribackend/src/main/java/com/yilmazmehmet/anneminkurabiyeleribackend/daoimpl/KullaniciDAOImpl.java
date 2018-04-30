package com.yilmazmehmet.anneminkurabiyeleribackend.daoimpl;

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
	public boolean sepetEkle(Sepet sepet) {
		try {
			sessionFactory.getCurrentSession().persist(sepet);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
