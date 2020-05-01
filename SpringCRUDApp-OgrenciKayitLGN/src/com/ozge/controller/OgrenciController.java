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

import com.ozge.domain.Ogrenci;
import com.ozge.service.OgrenciServisi;


@Controller
@RequestMapping("/ogrenci")
public class OgrenciController {

	@Autowired
	OgrenciServisi ogrenciServisi;
	
	
	@GetMapping("/list") // sayfa geçişleri için
	public String ListOgrenci(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}
		
		List<Ogrenci> ogrList = ogrenciServisi.getOgrenciler();

		model.addAttribute("ogrenciler", ogrList);

		return "ogrenci-list";
	}

	@GetMapping("/ogrenci-ekle")
	public String ogrenciEkle(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}

		Ogrenci ogr = new Ogrenci();
		model.addAttribute("ogrenci", ogr);

		return "ogrenci-form";

	}

	@PostMapping("/ogrenci-kaydet")
	public String ogrenciKaydet(@ModelAttribute("ogrenci") Ogrenci ogr) {
		
		ogrenciServisi.saveOgrenci(ogr);
		//ogrenciDAO.saveOgrenci(ogr);
		return "redirect:/ogrenci/list";
	}
	
	
	
	@GetMapping("/ogrenci-guncelle")
	public String ogrenciGuncelle(@RequestParam("ogrenciId") int ogrId, Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}

		Ogrenci ogr = ogrenciServisi.getOgrenci(ogrId);
		model.addAttribute("ogrenci", ogr);

		return "ogrenci-form";

	}
	

	@GetMapping("/ogrenci-sil")
	public String ogrenciSil(@RequestParam("ogrenciId") int ogrId, Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}

		ogrenciServisi.deleteOgrenci(ogrId);

		return "redirect:/ogrenci/list";

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
