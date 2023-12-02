package org.food.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("loginToken")
@Scope("session")
public class LoginToken {
	
	private String adminName;
	private String adminPassword;
	
	public LoginToken() {
	}

	public LoginToken(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	@Override
	public String toString() {
		return "LoginToken [adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
	

}
