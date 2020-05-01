package com.ozge.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.ozge.domain.User;
import com.ozge.domain.UserLogin;
import com.ozge.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		UserLogin userLogin = new UserLogin();
		model.addAttribute("userLogin", userLogin);
		return "login";
	}


	@PostMapping("/login-success")
	public String loginSuccess(@Valid @ModelAttribute UserLogin userLogin,BindingResult bindingResult,ModelMap modelMap,HttpSession oturum) {
		
		if(bindingResult.hasErrors()) {
			return "login";
		}
		
		User user = getUserservice().validateUserLogin(userLogin.getEmail(), userLogin.getPassword());
		
		if (user != null) {
			oturum.setAttribute("oturum", user.getName());
			
			return "welcome";
		} else {
			modelMap.put("error", "Invalid Account");
			return "login";
		}
		
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
