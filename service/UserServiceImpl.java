package org.food.service;

import java.util.List;
import java.util.Optional;

import org.food.model.User;
import org.food.repository.AddressUserRepository;
import org.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private AddressUserRepository addressUserRepository;

		@Override
		public User addUser(User user) {
			addressUserRepository.save(user.getAddressUser());
			return userRepository.save(user);
		}

		@Override
		public User getUserById(Long userId) {
			Optional<User> opt=userRepository.findById(userId);
			if(opt.isPresent())
				return opt.get();
			else
			return null;
		}

		@Override
		public List<User> viewAll() {
			// TODO Auto-generated method stub
			return userRepository.findAll();
		}

		}
