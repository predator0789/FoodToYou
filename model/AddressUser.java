package org.food.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Scope("prototype")

public class AddressUser {		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer addressId;
		private String buildingName;
		private String streetNo;
		private String city;
		private String state;
		private String country;
		private String pincode;

		public AddressUser() {
			super();
		}
		
		public AddressUser(String buildingName, String streetNo, String city, String state, String country,
				String pincode) {
			super();
			
			this.buildingName = buildingName;
			this.streetNo = streetNo;
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
		public String getBuildingName() {
			return buildingName;
		}
		public void setBuildingName(String buildingName) {
			this.buildingName = buildingName;
		}
		public String getStreetNo() {
			return streetNo;
		}
		public void setStreetNo(String streetNo) {
			this.streetNo = streetNo;
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
	
}
