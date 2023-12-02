package org.food.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="users")
public class User {		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long userId;
		
		@Column(nullable=false,unique=true,length=45)
		private String email;
		@Column(nullable=false,unique=true,length=65)
		private String firstName;
		@Column(nullable=false,unique=true,length=65)
		private String lastName;
		@Column(nullable=false,unique=true,length=45)
		private String password;
		
		private Integer age;
		private String gender;
		private String mobileNumber;
		
		@OneToOne
		@OnDelete(action=OnDeleteAction.CASCADE)
		private AddressUser addressUser;
		
		@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
		@OnDelete(action=OnDeleteAction.CASCADE)
		private FoodCart cart=new FoodCart();
		
		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public AddressUser getAddressUser() {
			return addressUser;
		}

		public void setAddressUser(AddressUser addressUser) {
			this.addressUser = addressUser;
		}

		
		public User() {
		}

		public User(Long userId, String email, String firstName, String lastName, String password, Integer age,
				String gender, String mobileNumber, AddressUser addressUser) {
			super();
			this.userId = userId;
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.age = age;
			this.gender = gender;
			this.mobileNumber = mobileNumber;
			this.addressUser = addressUser;
			
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public FoodCart getCart() {
			return cart;
		}
		public void setCart(FoodCart cart) {
			this.cart = cart;
		}

}
