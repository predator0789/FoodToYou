package org.food.controller;

import java.util.List;

import org.food.model.AddressUser;
import org.food.model.Login;
import org.food.model.User;
import org.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {
	
		
		@Autowired
		private UserService userService;
		
		@GetMapping("/addUser")
	    public String addUser(Model model)
	    {
			User user=new User();
			user.setAddressUser(new AddressUser());
			model.addAttribute("user",user);
			return "user/signup" ;
	    }

		@PostMapping("/addUser")
		public String processAddUser(@ModelAttribute("user")User user) {
			userService.addUser(user);
				return "user/signupsuccess";
		}
		@GetMapping("/Login")
		public String login(Model model) {
			Login login=new Login();
			model.addAttribute("login",login);
			return "user/login";
		}
		@GetMapping("/viewUsers")
		public String viewUsers(Model model) {
			List<User> users=userService.viewAll();
			model.addAttribute("users", users);
			return "user/viewUsers";
		}

		
}
