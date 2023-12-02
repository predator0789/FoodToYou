package org.food.controller;

import org.food.model.Login;
import org.food.model.User;
import org.food.service.LoginServiceUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/login")
@SessionAttributes("userId")
public class LoginUserController {
			
		@Autowired
		private LoginServiceUserImpl loginServiceUser;
		
		@Autowired
		private User user;
		
		@GetMapping("/customerlogin")
		public String login(Model model)
		{
			Login login=new Login();
			model.addAttribute("login",login);
		    return "login/userlogin";
		}
				
	    @PostMapping("/customerlogin")
	     public String checkLogin(@ModelAttribute("login") Login login,Model model) {
			user=loginServiceUser.validateLogin(login.getEmail(), login.getPassWord());
			if(user==null)
				return "login/userloginFailed";
			else {
				model.addAttribute("userId",user.getUserId());
				return "login/userloginSuccess";
			}
				
	}

}
