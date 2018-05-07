package com.yilmazmehmet.anneminkurabiyeleribackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.SepetAlaniDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.SepetAlani;

@Repository("sepetAlaniDAO")
@Transactional
public class SepetAlaniDAOImpl implements SepetAlaniDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SepetAlani get(int id) {
		return sessionFactory.getCurrentSession().get(SepetAlani.class, id);
		
	}

	@Override
	public boolean ekle(SepetAlani sepetAlani) {
		try {
			sessionFactory.getCurrentSession().persist(sepetAlani);
			return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
	}

	@Override
	public boolean guncelle(SepetAlani sepetAlani) {
		try {
			sessionFactory.getCurrentSession().update(sepetAlani);
			return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
	}

	@Override
	public boolean sil(SepetAlani sepetAlani) {
		try {
			sessionFactory.getCurrentSession().delete(sepetAlani);
			return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
	}

	@Override
	public List<SepetAlani> listele(int sepetId) {
		String query="FROM SepetAlani WHERE sepetId = :sepetId";
		return sessionFactory.getCurrentSession()
				.createQuery(query,SepetAlani.class)
				.setParameter("sepetId", sepetId)
				.getResultList();
	}

	@Override
	public List<SepetAlani> uygunOlanlariListele(int sepetId) {
		String query="From SepetAlani WHERE sepetId= :sepetId AND mevcutMu =: mevcutMu";
		return sessionFactory.getCurrentSession()
				.createQuery(query,SepetAlani.class)
				.setParameter("sepetId", sepetId)
				.setParameter("mevcutMu", true)
				.getResultList();
	
	}

	@Override
	public SepetAlani sepetVeUruneGoregetir(int sepetId, int urunId) {
		String query="From SepetAlani WHERE sepetId=:sepetId AND urun.id =: urunId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(query,SepetAlani.class)
					.setParameter("sepetId", sepetId)
					.setParameter("urunId", urunId)
					.getSingleResult();
		} catch (Exception e) {
			return null;
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


}
