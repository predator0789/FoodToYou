package org.food.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="foodCart")
@Scope("prototype")
public class FoodCart {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long cartId;

		@ManyToMany
		@OnDelete(action=OnDeleteAction.CASCADE)
		private List<Item> itemList=new ArrayList<>();
		
		
		public FoodCart() {
			super();
		}
		

		public FoodCart(Long cartId, List<Item> itemList) {
			super();
			this.cartId = cartId;
			
			this.itemList = itemList;
		}


		public Long getCartId() {
			return cartId;
		}

		public void setCartId(Long cartId) {
			this.cartId = cartId;
		}

		

		public List<Item> getItemList() {
			return itemList;
		}

		public void setItemList(List<Item> itemList) {
			this.itemList = itemList;
		}

}
