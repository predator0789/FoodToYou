package org.food.controller;

import java.util.ArrayList;
import java.util.List;

import org.food.model.Category;
import org.food.model.Restaurant;
import org.food.service.CategoryService;
import org.food.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RestaurantService restaurantService;

	
	@GetMapping("/addcategory")
	public String addCategory(@RequestParam("restaurantId") Integer restaurantId,Model model) {
		Category category=new Category();
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		category.setRestaurant(restaurant);
		model.addAttribute(category);
		return "category/addcategory";
	}
	
	@PostMapping("/addcategory")
	public String processAddCategory(@ModelAttribute("category")Category category,Model model) {
		if(categoryService.addCategory(category)==null)
			return "category/addfailed";
		else {
			model.addAttribute(category);
			return "category/addsuccess";

		}
	}
	
	@GetMapping("/modifycategory")
	public String modifyCategory(Model model) {
		List<Category> categorys=categoryService.viewAllCategory();
		model.addAttribute("categorys", categorys);
		return "category/modifycategory";
	}
	
	@GetMapping("/fetchcategory")
	public String fetchCategory(@RequestParam("categoryId") Integer categoryid, Model model) {
		Category category=categoryService.findCategoryById(categoryid);
		model.addAttribute("category", category);
		return "category/modifyfound";
	}
	
	@PostMapping("/modifycategoryprocess")
	public String processModifyCategory(@ModelAttribute("category")Category category,Model model) {
		if(categoryService.updateCategory(category)==null)
			return "category/modifyfailed";
		else
			return "category/modifysuccess";
	}
	
	@GetMapping("/deletecategory")
	public String deleteCategory(Model model) {
		List<Category> category=categoryService.viewAllCategory();
		model.addAttribute("category", category);
		return "category/deletecategory";
	}
	
	@GetMapping("/fetchdeletecategory")
	public String fetchdeleteCategory(@RequestParam("categoryId") Integer categoryId, Model model) {
		Category category=categoryService.findCategoryById(categoryId);
		model.addAttribute("category", category);
		return "category/deletefound";
	}
	
	@PostMapping("/deletecategoryprocess")
	public String processDeleteCategory(@ModelAttribute("category")Category category) {
		if(categoryService.removeCategory(category)==null)
			return "category/deletefailed";
		else
			return "category/deletesuccess";
	}

	@GetMapping("/listcategory")
	public String listCategory(@RequestParam("restaurantId") Integer restaurantId,Model model) {
		List<Category> categorys=categoryService.viewAllCategory();
		List<Category> categorysrest=new ArrayList<>();
		for(Category category:categorys)
		{
			Restaurant r=category.getRestaurant();
			if(r.getRestaurantId()==restaurantId)
				categorysrest.add(category);
		}
		model.addAttribute("categorys", categorysrest);
		return "category/listcategory";
	}
	
	@GetMapping("/listcategoryRUser")
	public String listCategoryRUser(@RequestParam("restaurantId") Integer restaurantId,Model model) {
		List<Category> categorys=categoryService.viewAllCategory();
		List<Category> categorysrest=new ArrayList<>();
		for(Category category:categorys)
		{
			Restaurant r=category.getRestaurant();
			if(r.getRestaurantId()==restaurantId)
				categorysrest.add(category);
		}
		model.addAttribute("categorys", categorysrest);
		return "category/listcategoryRUser";
	}
	
	@GetMapping("/listcategorys")
	public String listCategorys(Model model) {
		List<Category> categorys=categoryService.viewAllCategory();
		model.addAttribute("categorys", categorys);
		return "category/listcategorys";
	}
	
	@GetMapping("/listcategorysUser")
	public String listCategorysUser(Model model) {
		List<Category> categorys=categoryService.viewAllCategory();
		model.addAttribute("categorys", categorys);
		return "category/listcategorysUser";
	}

}
