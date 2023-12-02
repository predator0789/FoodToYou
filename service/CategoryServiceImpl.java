package org.food.service;

import java.util.List;
import java.util.Optional;

import org.food.model.Category;
import org.food.model.Restaurant;
import org.food.repository.CategoryRepository;
import org.food.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category addCategory(Category category) {
		restaurantRepository.save(category.getRestaurant());
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category findCategoryById(Integer categoryId) {
		Optional<Category> opt=categoryRepository.findById(categoryId);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@Override
	public Category removeCategory(Category category) {
		categoryRepository.delete(category);
		return category;
	}

	@Override
	public List<Category> viewAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> findByRestaurant(Restaurant restaurant) {
		return categoryRepository.findAll();
	}
	

}
