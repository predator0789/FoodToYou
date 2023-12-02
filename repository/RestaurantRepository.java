package org.food.repository;


import java.util.List;

import org.food.model.Item;
import org.food.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{

//	public Restaurant saveAll(List<Item> itemList);
	
}
