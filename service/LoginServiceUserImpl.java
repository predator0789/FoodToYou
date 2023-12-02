package org.food.service;


import org.food.model.User;
import org.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceUserImpl implements LoginServiceUser{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private User user;
	

	@Override
	public User validateLogin(String email, String password) {
		user=userRepository.findByemail(email);
		if(user==null)
		return null;
		else {
			if(!user.getPassword().equals(password))
				return null;
			else 
				return user;
		}
	}


}
