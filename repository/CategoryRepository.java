package org.food.repository;

import java.util.List;

import org.food.model.Category;
import org.food.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	
	public List<Category> findByRestaurant(Restaurant restaurant);

}
