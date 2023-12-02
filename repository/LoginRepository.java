package org.food.repository;


import org.food.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer>{
	 public Login findByEmail(String email);

}
