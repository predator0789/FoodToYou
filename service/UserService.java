package org.food.service;

import java.util.List;

import org.food.model.User;

public interface UserService {
	
	public User addUser(User user);
	 public User getUserById(Long userId);
	 public List<User> viewAll();

}
