package org.food.service;

import java.util.List;
import java.util.Optional;

import org.food.model.FoodCart;
import org.food.model.Item;
import org.food.repository.FoodCartRepository;
import org.food.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IFoodCartServiceImpl implements IFoodCartService{
	
	@Autowired
	private FoodCartRepository FoodCartRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public IFoodCartServiceImpl(FoodCartRepository foodCartRepository,ItemRepository itemRepository) {
		super();
		this.FoodCartRepository=foodCartRepository;
		this.itemRepository = itemRepository;
	}
	
	@Override
	public FoodCart addItemToCart(FoodCart cart) {
		// TODO Auto-generated method stub
		return FoodCartRepository.save(cart);
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Item item) {
		// TODO Auto-generated method stub
		List<Item> itemList=cart.getItemList();
		itemList.remove(item);
		cart.setItemList(itemList);
		return cart;
	}

	@Override
	public FoodCart ClearCart(FoodCart cart) {
		FoodCartRepository.delete(cart);
		return cart;
	}

	@Override
	public FoodCart findCartById(Long cartId) {
		Optional<FoodCart> opt=FoodCartRepository.findById(cartId);
		if(opt.isPresent())
			return opt.get();
		else
		return null;
	}

}
