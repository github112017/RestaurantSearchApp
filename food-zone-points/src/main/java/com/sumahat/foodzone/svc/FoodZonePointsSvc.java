package com.sumahat.foodzone.svc;

import java.math.BigDecimal;
import java.util.List;

import com.sumahat.foodzone.model.Restaurant;
import com.sumahat.foodzone.model.RestaurantName;
import com.sumahat.foodzone.so.ItemSO;
import com.sumahat.foodzone.so.RestaurantSO;



public interface FoodZonePointsSvc {

	List<Restaurant> getRestaurants();

	List<Restaurant> getAllRestaurants();
    
	List<RestaurantName> getOnlineRestaurants();
  
	Long saveRestaurant(String restaurantName, String restaurantAddress, boolean isOnline);

	Long saveItem(String style, String type, String name, BigDecimal cost,Long restaurantId, Integer servings);
    
	RestaurantSO getRestaurantById(Long resId);
   
	List<ItemSO> getItems(Long restaurantId);
	
}
