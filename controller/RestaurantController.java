package org.food.controller;

import java.util.ArrayList;
import java.util.List;

import org.food.model.Address;
import org.food.model.Category;
import org.food.model.FoodCart;
import org.food.model.Item;
import org.food.model.Restaurant;
import org.food.model.User;
import org.food.repository.AddressRepository;
import org.food.repository.CategoryRepository;
import org.food.repository.ItemRepository;
import org.food.service.RestaurantService;
import org.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/restaurant")
@SessionAttributes("userId")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserService userService;


	
	@GetMapping("/addrestaurant")
	public String addRestaurant(Model model) {
		Restaurant restaurant=new Restaurant();
		restaurant.setLocation(new Address());
		model.addAttribute("restaurant",restaurant);
		return "restaurant/addrestaurant";
	}
	
	@PostMapping("/addrestaurant")
	public String processAddRestaurant(@ModelAttribute("restaurant")Restaurant restaurant) {
		if(restaurantService.addRestaurant(restaurant)==null)
			return "restaurant/addfailed";
		else
			return "restaurant/addsuccess";
	}
	
	@GetMapping("/modifyrestaurant")
	public String modifyRestaurant(Model model) {
		List<Restaurant> restaurants=restaurantService.viewAllRestaurant();
		model.addAttribute("restaurants",restaurants);
		return "restaurant/modifyrestaurant";
	}
	
	@GetMapping("/fetchrestaurant")
	public String fetchRestaurant(@RequestParam("restaurantid") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		model.addAttribute("restaurant",restaurant);
		return "restaurant/modifyfound";
		
	}
	
	@PostMapping("/modifyrestaurantprocess")
	public String processModifyRestaurant(@ModelAttribute("restaurant")Restaurant restaurant) {
		Address address=restaurant.getLocation();
		address.setAddress(restaurant.getLocation().getAddress());
		address.setCity(restaurant.getLocation().getCity());
		address.setPincode(restaurant.getLocation().getPincode());
		addressRepository.save(address);

		if(restaurantService.updateRestaurant(restaurant)==null)
			return "restaurant/modifyfailed";
		else
		{
			return "restaurant/modifysuccess";
		}
	}
	
	@GetMapping("/viewrestaurantmodify")
	public String viewRestaurantModify(@RequestParam("restaurantid") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/viewrestaurantmodify";
	}
	
	
	@GetMapping("/deleterestaurant")
	public String deleteRestaurant(Model model) {
		List<Restaurant> restaurants=restaurantService.viewAllRestaurant();
		model.addAttribute("restaurants",restaurants);
		return "restaurant/deleterestaurant";
	}
	
	@GetMapping("/fetchfordeleterestaurant")
	public String fetchfordeleteRestaurant(@RequestParam("restaurantid") Integer restaurantId,Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		model.addAttribute("restaurant",restaurant);
		return "restaurant/deletefound";
		
	}
	
	@PostMapping("/deleterestaurantprocess")
	public String processDeleteRestaurant(@ModelAttribute("restaurant")Restaurant restaurant) {
		Address address=restaurant.getLocation();
		addressRepository.delete(address);
		List<Item> items=itemRepository.findAll();
		for(Item item:items) {
			Restaurant r=item.getRestaurant();
			if(r.getRestaurantId()==restaurant.getRestaurantId())
				itemRepository.delete(item);
		}
		List<Category> cats=categoryRepository.findAll();
		for(Category cat:cats) {
			Restaurant r=cat.getRestaurant();
			if(r.getRestaurantId()==restaurant.getRestaurantId())
				categoryRepository.delete(cat);
		}
		if(restaurantService.removeRestaurant(restaurant)==null)
			return "restaurant/deletefailed";
		else {
			return "restaurant/deletesuccess";
		}
			
	}
	
	@GetMapping("/viewrestaurantdelete")
	public String viewRestaurantDelete(@RequestParam("restaurantid") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/viewrestaurantdelete";
	}
	
	@GetMapping("/listrestaurant")
	public String listRestaurants(Model model) {
		List<Restaurant> restaurants=restaurantService.viewAllRestaurant();
		model.addAttribute("restaurants", restaurants);
		return "restaurant/listrestaurant";
	}
	
	@GetMapping("/viewrestaurant")
	public String viewRestaurant(@RequestParam("restaurantid") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/viewrestaurant";
	}
	
	@GetMapping("/listrestaurantUser")
	public String listRestaurantsForUser(Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		model.addAttribute("cart", cart);
		List<Restaurant> restaurants=restaurantService.viewAllRestaurant();
		model.addAttribute("restaurants", restaurants);
		return "customerlogged";
	}
	
	@GetMapping("/viewrestaurantUser")
	public String viewRestaurantForUser(@RequestParam("restaurantid") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/viewrestaurantUser";
	}
	
	@GetMapping("/viewrestaurantUserNotLogged")
	public String viewRestaurantForUserNotLogged(@RequestParam("restaurantid") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/viewrestaurantUserNotLogged";
	}

}
