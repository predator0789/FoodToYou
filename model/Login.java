package org.food.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Component
@Scope("session")
public class Login {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer loginId;
		private String email;
		private String passWord;

		public Integer getLoginId() {
			return loginId;
		}
		public void setLoginId(Integer loginId) {
			this.loginId = loginId;
		}
		public Login() {
			super();
		}
		public Login(Integer loginId, String email, String passWord) {
			super();
			this.loginId = loginId;
			this.email = email;
			this.passWord = passWord;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		
}
