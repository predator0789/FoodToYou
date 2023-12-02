package org.food.controller;

import java.util.List;


import org.food.model.FoodCart;
import org.food.model.Item;
import org.food.model.OrderDetails;
import org.food.model.Restaurant;
import org.food.model.User;
import org.food.service.IFoodCartService;
import org.food.service.IOrderService;
import org.food.service.IOrderServiceImpl;
import org.food.service.ItemService;
import org.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/foodCart")
@SessionAttributes("userId")
public class FoodCartController {
	
	@Autowired
	private IFoodCartService FoodCartservice;
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IOrderServiceImpl IOrderService;
	
	private OrderDetails orderDetails=new OrderDetails();
	
	@GetMapping("/addItemToCart")
	public String addItemToCart(@RequestParam("itemid")Integer itemid,Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		Item item=itemService.findItemById(itemid);
		Restaurant restro=item.getRestaurant();
		model.addAttribute("restaurant", restro);
		cart.getItemList().add(item);
		FoodCartservice.addItemToCart(cart);
		model.addAttribute("cart",cart);
		return "foodCart/addItemToCart";
	}
	
	@GetMapping("/viewCart")
	public String viewCartItems(@RequestParam("cartid")Long cartId,Model model) {
		FoodCart cart=FoodCartservice.findCartById(cartId);
		List<Item> itemList=cart.getItemList();
		Restaurant res=null;
		for(Item item:itemList)
		{
			res=item.getRestaurant();
		}
		model.addAttribute("restaurant", res);
		orderDetails.setCart(cart);
		model.addAttribute("orderDetails", orderDetails);
		IOrderService.addOrder(orderDetails);
		for(Item item:itemList) {
			item.setQuantity(1);
		}
		model.addAttribute("items",itemList);
		return "foodCart/viewCart";
	}
	
	@GetMapping("/viewCarti")
	public String viewCartItemsi(@RequestParam("cartid")Long cartId,Model model) {
		FoodCart cart=FoodCartservice.findCartById(cartId);
		List<Item> itemList=cart.getItemList();
		Restaurant res=null;
		for(Item item:itemList)
		{
			res=item.getRestaurant();
		}
		model.addAttribute("restaurant", res);
		orderDetails.setCart(cart);
		model.addAttribute("orderDetails", orderDetails);
		IOrderService.addOrder(orderDetails);
		for(Item item:itemList) {
			item.setQuantity(1);
		}
		model.addAttribute("items",itemList);
		return "foodCart/viewCarti";
	}
	
	
	@GetMapping("/orderDetails")
	public String orderDetails(@RequestParam("orderid")Integer orderId,Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		model.addAttribute(cart);
		OrderDetails orderDetails=IOrderService.findOrderById(orderId);
		orderDetails.setCart(cart);
		List<Item> itemList=cart.getItemList();
		model.addAttribute("items",itemList);
		Double total=0.0;
		for(Item item:itemList) {
			item.setQuantity(1);
			total=total+(item.getCost()*item.getQuantity());
		}
		orderDetails.setTotalAmount(total);
		model.addAttribute("orderDetails",orderDetails);
		IOrderService.addOrder(orderDetails);
		return "foodCart/orderDetails";
	}
	
	@GetMapping("/orderPlaced")
	public String orderPlaced(Model model) {
		return "foodCart/orderPlaced";
	}
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("itemid")Integer itemId,Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		Item item=itemService.findItemById(itemId);
		FoodCart cartNew=FoodCartservice.removeItem(cart, item);
		if(cartNew.getItemList()==null)
			return "foodCart/";
		FoodCartservice.addItemToCart(cartNew);
			model.addAttribute("cart", cartNew);
		return "foodCart/deleteItem";
	}
	
	
	@GetMapping("/viewAdminCart")
	public String viewCartItemsAdmin(@RequestParam("cartid")Long cartId,Model model) {
		FoodCart cart=FoodCartservice.findCartById(cartId);
		List<Item> itemList=cart.getItemList();
		orderDetails.setCart(cart);
		model.addAttribute("orderDetails", orderDetails);
		IOrderService.addOrder(orderDetails);
		model.addAttribute("items",itemList);
		return "foodCart/viewAdminCart";
	}
	
	@GetMapping("/deletecart")
	public String deleteCart(@RequestParam("cartid")Long cartId,Model model) {
		FoodCart cart=FoodCartservice.findCartById(cartId);
		List<Item> itemList=cart.getItemList();
		itemList.removeAll(itemList);
		cart.setItemList(itemList);
		FoodCartservice.addItemToCart(cart);
		return "foodCart/logout";
}
}
