package com.ozge.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ozge.domain.Kurs;



@Repository
public class KursDAOImpl implements KursDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public List<Kurs> getKurslar() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kurs> query = session.createQuery("from Kurs",Kurs.class);
		List<Kurs> resultList = query.getResultList();
		return resultList;
	}


	@Override
	public void kursKaydet(Kurs kurs) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(kurs);
	}


	@Override
	public Kurs getKurs(int kursId) {
		Session session = sessionFactory.getCurrentSession();
		Kurs kurs = session.get(Kurs.class, kursId);
		
		return kurs;
	}


	@Override
	public void kursSil(int kursId) {
		Session session = sessionFactory.getCurrentSession();
		Kurs kurs = session.get(Kurs.class, kursId);
		session.delete(kurs);
	}

}
