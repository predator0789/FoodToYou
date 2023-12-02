package org.food.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
@Scope("prototype")
public class Address {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer addressId;
		private String address;
		private String city;
		private String state;
		private String country;
		private String pincode;

		public Address() {
		}
		
		public Address(String address, String city, String state, String country,
				String pincode) {
			super();
			this.address = address;
			this.city = city;
			this.state = state;
			this.country = country;
			this.pincode = pincode;
		}

		public Integer getAddressId() {
			return addressId;
		}
		public void setAddressId(Integer addressId) {
			this.addressId = addressId;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		@Override
		public String toString() {
			return address + "," + city + "," + pincode+".";
		}
		
		


}
