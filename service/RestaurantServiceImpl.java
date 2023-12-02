package org.food.service;

import java.util.List;
import java.util.Optional;

import org.food.model.Address;
import org.food.model.Item;
import org.food.model.Restaurant;
import org.food.repository.AddressRepository;
import org.food.repository.ItemRepository;
import org.food.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant addRestaurant(Restaurant res) {
		addressRepository.save(res.getLocation());
		return restaurantRepository.save(res);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res) {
		return restaurantRepository.save(res);
	}

	@Override
	public Restaurant removeRestaurant(Restaurant res) {
		restaurantRepository.delete(res);
		return res;
	}

	@Override
	public List<Restaurant> viewAllRestaurant() {
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant findRestaurantById(Integer restaurantId) {
		Optional<Restaurant> opt=restaurantRepository.findById(restaurantId);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

//	@Override
//	public Restaurant addItem(Restaurant res, List<Item> itemList) {
//		itemRepository.saveAll(res.getItemList());
//		return restaurantRepository.saveAll(itemList);
//	}

}
