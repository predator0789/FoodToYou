package org.food.service;

import java.util.List;

import org.food.model.Category;
import org.food.model.Restaurant;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Category findCategoryById(Integer categoryId);
	public Category removeCategory(Category category);
	public List<Category> viewAllCategory();
	public List<Category> findByRestaurant(Restaurant restaurant);

}
