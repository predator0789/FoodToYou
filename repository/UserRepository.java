package org.food.repository;


import org.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
	public User findByemail(String email);
}

