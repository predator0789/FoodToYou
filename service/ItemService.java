package org.food.service;

import java.util.List;

import org.food.model.Item;
import org.food.model.Restaurant;

public interface ItemService {
	
	public Item addItem(Item item);
	public Item updateItem(Item item);
	public Item findItemById(Integer ItemId);
	public Item removeItem(Item item);
	public List<Item> viewAllItems();
	//public List<Item> viewAllItems(Category cat);
	public List<Item> viewAllItems(Restaurant res);
	public List<Item> viewAllItemsByName(String name);

}
