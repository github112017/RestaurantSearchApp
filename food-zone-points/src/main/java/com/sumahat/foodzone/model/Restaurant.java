package com.sumahat.foodzone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="restaurant_id")
	private Long restaurantId;
	
	@Column(name="restaurant_name")
	private String restaurantName;
	
	@Column(name="restaurant_address")
	private String restaurantAddress;
	
	@Column(name="is_online")
	private String isOnline;
	
	@OneToMany
	@JoinColumn(name="restaurant_id")
	List<Item> items;

	public Restaurant() {
		super();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}



	
	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public Restaurant(Long restaurantId, String restaurantName,
			String restaurantAddress,String isOnline) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.isOnline =  isOnline;
	}
	public Restaurant(String restaurantName,
			String restaurantAddress,String isOnline) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.isOnline =  isOnline;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName="
				+ restaurantName + ", restaurantAddress=" + restaurantAddress
				+ ", isOnline=" + isOnline + "]";
	}
	
	
}
