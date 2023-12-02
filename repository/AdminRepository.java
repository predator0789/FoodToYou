package org.food.repository;

import java.util.Optional;
import org.food.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
	public Optional<Admin> findByAdminNameAndAdminPassword(String adminName,String adminPassword);

}
