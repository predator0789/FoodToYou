package org.food.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class OrderDetails {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer orderId;
		private LocalDateTime orderDate;
		
		@OneToOne
		@OnDelete(action=OnDeleteAction.CASCADE)
		private FoodCart cart;
		
		private String orderStatus;
		
		private Double totalAmount;

		public OrderDetails() {
			super();
		}
		
		public OrderDetails(Integer orderId, LocalDateTime orderDate, FoodCart cart, String orderStatus,
				Double totalAmount) {
			super();
			this.orderId = orderId;
			this.orderDate = orderDate;
			this.cart = cart;
			this.orderStatus = orderStatus;
			this.totalAmount = totalAmount;
		}

		public Integer getOrderId() {
			return orderId;
		}
		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}
		public LocalDateTime getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}
		public FoodCart getCart() {
			return cart;
		}
		public void setCart(FoodCart cart) {
			this.cart = cart;
		}
		public String getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}
		public Double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}

}
