package org.food.controller;

import java.util.ArrayList;
import java.util.List;

import org.food.model.Category;
import org.food.model.Item;
import org.food.model.Restaurant;
import org.food.service.CategoryService;
import org.food.service.ItemService;
import org.food.service.RestaurantService;
import org.food.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/additem")
	public String addItem(@RequestParam("restaurantId") Integer restaurantId,@RequestParam("categoryId") Integer categoryId,Model model) {
		Item item=new Item();
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		item.setRestaurant(restaurant);
		Category category=categoryService.findCategoryById(categoryId);
		item.setCategory(category);
		model.addAttribute(item);
		return "item/additem";
	}
	
	@PostMapping("/additem")
	public String processAddItem(@ModelAttribute("item")Item item,Model model) {
		if(itemService.addItem(item)==null)
			return "item/addfailed";
		else {
			model.addAttribute(item);
			return "item/addsuccess";
		}
	}
	
	@GetMapping("/modifyitem")
	public String modifyItem(Model model) {
		List<Item> items=itemService.viewAllItems();
		model.addAttribute("items", items);
		return "item/modifyitem";
	}
	
	@GetMapping("/fetchitem")
	public String fetchItem(@RequestParam("itemid") Integer itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/modifyfound";
	}
	
	@PostMapping("/modifyitemprocess")
	public String processModifyItem(@ModelAttribute("item")Item item,Model model) {
		if(itemService.updateItem(item)==null)
			return "item/modifyfailed";
		else
			return "item/modifysuccess";
	}
	
	@GetMapping("/viewitemmodify")
	public String viewItemModify(@RequestParam("itemid") Integer itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/viewitemmodify";
	}
	
	@GetMapping("/deleteitem")
	public String deleteCategory(Model model) {
		List<Item> items=itemService.viewAllItems();
		model.addAttribute("items", items);
		return "item/deleteitem";
	}
	
	@GetMapping("/fetchdeleteitem")
	public String fetchdeleteItem(@RequestParam("itemid") Integer itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/deletefound";
	}
	
	@PostMapping("/deleteitemprocess")
	public String processDeleteItem(@ModelAttribute("item")Item item,Model model) {
		if(itemService.removeItem(item)==null)
			return "item/deletefailed";
		else
			return "item/deletesuccess";
	}
	
	@GetMapping("/viewitemdelete")
	public String viewItemDelete(@RequestParam("itemid") Integer itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/viewitemdelete";
	}

	@GetMapping("/listitems")
	public String listItemsR(@RequestParam("restaurantId") Integer restaurantId,Model model) {
		List<Item> items=itemService.viewAllItems();
		
		List<Item> itemres=new ArrayList<>();
		for(Item item:items)
		{
			Restaurant r=item.getRestaurant();
			if(r.getRestaurantId()==restaurantId)
				itemres.add(item);
		}
		
		model.addAttribute("items", itemres);
		return "item/listitems";
	}
	
	@GetMapping("/listitemsUser")
	public String listItemsRForUser(@RequestParam("restaurantId") Integer restaurantId,Model model) {
		List<Item> items=itemService.viewAllItems();
		
		List<Item> itemres=new ArrayList<>();
		for(Item item:items)
		{
			Restaurant r=item.getRestaurant();
			if(r.getRestaurantId()==restaurantId)
				itemres.add(item);
		}
		
		model.addAttribute("items", itemres);
		return "item/listitemsUser";
	}
	
	@GetMapping("/listitemsUserNotLogged")
	public String listItemsRForUserNotLogged(@RequestParam("restaurantId") Integer restaurantId,Model model) {
		List<Item> items=itemService.viewAllItems();
		
		List<Item> itemres=new ArrayList<>();
		for(Item item:items)
		{
			Restaurant r=item.getRestaurant();
			if(r.getRestaurantId()==restaurantId)
				itemres.add(item);
		}
		
		model.addAttribute("items", itemres);
		return "item/listitemsUserNotLogged";
	}
	
	@GetMapping("/viewitem")
	public String viewItem(@RequestParam("itemid") Integer itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/viewitem";
	}
	
	@GetMapping("/listitem")
	public String listItems(@RequestParam("categoryId") Integer categoryId,Model model) {
		List<Item> items=itemService.viewAllItems();
		
		List<Item> itemcat=new ArrayList<>();
		for(Item item:items)
		{
			Category c=item.getCategory();
			if(c.getCategoryId()==categoryId)
				itemcat.add(item);
		}
		
		model.addAttribute("items", itemcat);
		return "item/listitem";
	}
	
	@GetMapping("/listitemCUser")
	public String listItemsCForUser(@RequestParam("categoryId") Integer categoryId,Model model) {
		List<Item> items=itemService.viewAllItems();
		
		List<Item> itemcat=new ArrayList<>();
		for(Item item:items)
		{
			Category c=item.getCategory();
			if(c.getCategoryId()==categoryId)
				itemcat.add(item);
		}
		
		model.addAttribute("items", itemcat);
		return "item/listitemCUser";
	}
	
	
	
	

}
