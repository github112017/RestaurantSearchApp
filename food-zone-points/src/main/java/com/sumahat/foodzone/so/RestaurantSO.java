package com.sumahat.foodzone.so;


public class RestaurantSO {
	
	
	private String restaurantName;
	
	private String restaurantAddress;
	
	private boolean isOnline;
	
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

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public RestaurantSO(String restaurantName, String restaurantAddress,
			boolean isOnline) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.isOnline = isOnline;
	}

	public RestaurantSO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
}
