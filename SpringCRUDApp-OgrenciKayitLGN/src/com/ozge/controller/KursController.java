package com.ozge.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.ozge.domain.Kurs;

import com.ozge.service.KursServisi;

@Controller
@RequestMapping("/kurs")
public class KursController {


	@Autowired
	KursServisi kursServisi;

	@GetMapping("/list")
	public String kursListele(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}
		
		List<Kurs> kursList = kursServisi.getKurslar();
		model.addAttribute("kurslar", kursList);

		return "kurs-list";
	}

	@GetMapping("/kurs-ekle")
	public String kursEkle(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}
		
		Kurs kurs = new Kurs();
		model.addAttribute("kurs", kurs);

		return "kurs-form";
	}

	@PostMapping("/kurs-kaydet")
	public String kursKaydet(@ModelAttribute Kurs kurs) {
		kursServisi.kursKaydet(kurs);

		return "redirect:/kurs/list";
	}

	@GetMapping("/kurs-guncelle")
	public String kursGuncelle(@RequestParam("kursId") int kursId, Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}
		
		Kurs kurs = kursServisi.getKurs(kursId);
		model.addAttribute("kurs", kurs);

		return "kurs-form";
	}

	@GetMapping("/kurs-sil")
	public String kursSil(@RequestParam("kursId") int kursId, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}
		kursServisi.kursSil(kursId);

		return "redirect:/kurs/list";
	}
	@RequestMapping("/endsession")
	public String nextHandlingMethod2(SessionStatus status, HttpSession oturum) {
		//if(oturum.getAttribute("oturumIsim") != null) {
		status.setComplete();
		oturum.invalidate();
	//	}
		// System.out.println(oturum.getAttribute("oturum-email"));
		return "redirect:/user/login";
	}
}
