package org.food.service;

import java.util.Optional;

import org.food.dto.LoginToken;
import org.food.model.Admin;
import org.food.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin checkLogin(LoginToken loginToken) {
		Optional<Admin> adminOpt = adminRepository.findByAdminNameAndAdminPassword(loginToken.getAdminName(), loginToken.getAdminPassword());
		if(adminOpt.isPresent())
			return adminOpt.get();
		else
			return null;
	}
	
	public Admin getAdminByAdminId(Integer adminId) {
		Optional<Admin> adminOpt = adminRepository.findById(adminId);
		if(adminOpt.isPresent())
			return adminOpt.get();
		else
			return null;
	}


}
