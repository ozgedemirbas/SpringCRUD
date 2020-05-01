package com.ozge.service;

import java.util.List;

import com.ozge.domain.Ogrenci;

public interface OgrenciServisi {

public List<Ogrenci> getOgrenciler();
	
	public void saveOgrenci(Ogrenci ogr);

	public Ogrenci getOgrenci(int ogrId);

	public void deleteOgrenci(int ogrId);
	
	
	
	
	
	
}
