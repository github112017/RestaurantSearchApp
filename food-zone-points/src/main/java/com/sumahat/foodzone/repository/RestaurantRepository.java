package com.sumahat.foodzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sumahat.foodzone.model.Restaurant;
import com.sumahat.foodzone.model.RestaurantName;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	
	@Query("SELECT new com.sumahat.foodzone.model.Restaurant(restaurantId, restaurantName,restaurantAddress,isOnline) FROM Restaurant")
	List<Restaurant> getRestaurant();
	
	// getRestaurantByIsOnline is written as "getEntityByColumn" 
	List<RestaurantName> getRestaurantByIsOnline(String isOnline);
	
}
