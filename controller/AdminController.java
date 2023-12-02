package org.food.controller;

import java.util.List;

import org.food.model.Restaurant;
import org.food.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpage")
public class AdminController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping
	public String listRestaurants(Model model) {
		List<Restaurant> restaurants=restaurantService.viewAllRestaurant();
		model.addAttribute("restaurants", restaurants);
		return "admin";
	}
	
//	@GetMapping("/viewrestaurant")
//	public String viewRestaurant(@RequestParam("restaurantid") String restaurantId, Model model) {
//		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
//		model.addAttribute("restaurant", restaurant);
//		return "restaurant/viewrestaurant";
//	}
	
	

}
