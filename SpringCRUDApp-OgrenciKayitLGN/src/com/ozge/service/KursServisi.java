package com.ozge.service;

import java.util.List;

import com.ozge.domain.Kurs;

public interface KursServisi {

	public List<Kurs> getKurslar();

	public void kursKaydet(Kurs kurs);

	public Kurs getKurs(int kursId);

	public void kursSil(int kursId);






	

	

}
