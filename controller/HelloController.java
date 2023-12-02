package org.food.controller;

import java.util.List;

import org.food.model.Restaurant;
import org.food.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@Autowired
	private RestaurantService restaurantService;

	
	@RequestMapping("/") 
    public String home(Model model){
		List<Restaurant> restaurants=restaurantService.viewAllRestaurant();
		model.addAttribute("restaurants", restaurants);
        return "customer"; 
    }  

}
