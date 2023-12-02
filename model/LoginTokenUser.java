package org.food.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("loginTokenUser")
@Scope("session")
public class LoginTokenUser { 
		private Integer userId;
		private String userName;
		private String password;
		
		public LoginTokenUser() {
			super();
		}
		public LoginTokenUser(Integer userId, String userName, String password) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.password = password;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
