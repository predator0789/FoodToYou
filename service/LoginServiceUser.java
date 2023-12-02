package org.food.service;

import org.food.model.Login;
import org.food.model.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginServiceUser {
	public User validateLogin(String email,String password);
	  

}
