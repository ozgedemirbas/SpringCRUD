package com.ozge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ozge.dao.KursDAO;
import com.ozge.domain.Kurs;

@Service
public class KursServisiImpl implements KursServisi{
	
	@Autowired
	KursDAO kursDAO;
	
	@Transactional
	@Override
	public List<Kurs> getKurslar() {
		
		return kursDAO.getKurslar();
	}
	
	@Transactional
	@Override
	public void kursKaydet(Kurs kurs) {
		kursDAO.kursKaydet(kurs);
		
	}
	
	@Transactional
	@Override
	public Kurs getKurs(int kursId) {
		
		return kursDAO.getKurs(kursId);
	}
	
	@Transactional
	@Override
	public void kursSil(int kursId) {
		kursDAO.kursSil(kursId);
		
	}

	
	
}
