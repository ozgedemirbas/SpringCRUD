package com.ozge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KURS")
public class Kurs {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "kurs_seq", sequenceName = "SEQ_KURS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_seq")
	private Integer id;
	
	@Column(name = "kurs_adi")
	private String kursAdi;
	
	@Column(name = "saat")
	private int saat;
	
	
	public Kurs() {
		super();
	}

	public Kurs(String kursAdi, int saat) {
		super();
		this.kursAdi = kursAdi;
		this.saat = saat;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKursAdi() {
		return kursAdi;
	}

	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		this.saat = saat;
	}

	@Override
	public String toString() {
		return "Kurs [id=" + id + ", kursAdi=" + kursAdi + ", saat=" + saat + "]";
	}

	

}
