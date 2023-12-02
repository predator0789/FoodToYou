package org.food.repository;

import org.food.model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCartRepository extends JpaRepository<FoodCart,Long>{

}
