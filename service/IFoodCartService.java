package org.food.service;

import org.food.model.FoodCart;
import org.food.model.Item;

public interface IFoodCartService {
	
	public FoodCart addItemToCart(FoodCart cart);
	public FoodCart increaseQuantity(FoodCart cart,Item item,int quantity);
	public FoodCart reduceQuantity(FoodCart cart,Item item,int quantity);
	public FoodCart removeItem(FoodCart cart,Item item);
	public FoodCart ClearCart(FoodCart cart);
	public FoodCart findCartById(Long cartId);


}
