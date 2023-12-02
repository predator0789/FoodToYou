package org.food.service;

import java.util.List;
import java.util.Optional;

import org.food.model.Item;
import org.food.model.Restaurant;
import org.food.repository.CategoryRepository;
import org.food.repository.ItemRepository;
import org.food.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item addItem(Item item) {
		restaurantRepository.save(item.getRestaurant());
		categoryRepository.save(item.getCategory());
		return itemRepository.save(item);
	}

	@Override
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item removeItem(Item item) {
		itemRepository.delete(item);
		return item;
	}
	
	@Override
	public List<Item> viewAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public List<Item> viewAllItems(Restaurant res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findItemById(Integer itemId) {
		Optional<Item> opt=itemRepository.findById(itemId);
		if(opt.isPresent())
			return opt.get();
		else
			return null;

	}

}
