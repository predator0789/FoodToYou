package org.food.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@Component
@Scope("prototype")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer itemId;
	private String itemName;
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Restaurant restaurant;
	private int quantity;
	private double cost;
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Category category;
	
	public Item() {
	}
	
	public Item(String itemName, Restaurant restaurant, int quantity, double cost, Category category) {
		super();
		this.itemName = itemName;
		this.restaurant = restaurant;
		this.quantity = quantity;
		this.cost = cost;
		this.category = category;
	}

		public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", restaurant=" + restaurant + ", quantity="
				+ quantity + ", cost=" + cost + ", category=" + category + "]";
	}
	
}
