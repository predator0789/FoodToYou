package org.food.service;

import java.util.List;

import org.food.model.Item;
import org.food.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res);
	public Restaurant findRestaurantById(Integer restaurantId);
	public Restaurant removeRestaurant(Restaurant res);
	//public Restaurant addItem(Restaurant res,List<Item> itemList);
	public List<Restaurant> viewAllRestaurant();
	public List<Restaurant> viewNearByRestaurant(String location);
	public List<Restaurant> viewRestaurantByItemName(String name);



}
