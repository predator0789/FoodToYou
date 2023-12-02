package org.food.controller;

import org.food.dto.LoginToken;
import org.food.model.Admin;
import org.food.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/adminlogin")
@SessionAttributes("adminid")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@GetMapping
	public String login(Model model) {
		LoginToken logintoken = new LoginToken();
		model.addAttribute("logintoken", logintoken);
		return "login/login";
	}
	
	@PostMapping
	public String checkLogin(@ModelAttribute("logintoken") LoginToken logintoken,Model model) {
		Admin admin = loginService.checkLogin(logintoken);
		if(admin != null) {
			model.addAttribute("adminid", admin.getAdminId());
			return "login/loginsuccess";
		}else 
			return "login/loginunsuccess";
	}

}
