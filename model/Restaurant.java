package org.food.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Component
@Scope("prototype")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer restaurantId;
	private String restaurantName;
	@OneToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Address location;
	private String managerName;
	private String contactNumber;
	
	public Restaurant() {
	}
	
	public Restaurant(String restaurantName, Address location,
			String managerName, String contactNumber) {
		super();
		this.restaurantName = restaurantName;
		this.location = location;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

		@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", location="
				+ location + ", managerName=" + managerName + ", contactNumber="
				+ contactNumber + "]";
	}

}
