package com.sumahat.foodzone.svc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sumahat.foodzone.model.Item;
import com.sumahat.foodzone.model.Restaurant;
import com.sumahat.foodzone.model.RestaurantName;
import com.sumahat.foodzone.repository.ItemRepository;
import com.sumahat.foodzone.repository.RestaurantRepository;
import com.sumahat.foodzone.so.ItemSO;
import com.sumahat.foodzone.so.RestaurantSO;

@Service
public class FoodZonePointsSvcImpl implements FoodZonePointsSvc {

	private static final Logger log = LoggerFactory.getLogger(FoodZonePointsSvcImpl.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired(required=false)
	RestaurantRepository restaurantRepo;
    
	@Autowired(required=false)
	ItemRepository itemRepo;
    
	@Override
	public List<Restaurant> getRestaurants() {
	   log.debug("Inside getRestaurants");
		return restaurantRepo.findAll();
	}


	@Override
	public List<Restaurant> getAllRestaurants() {
		
		return restaurantRepo.getRestaurant();
	}
    
	@Override
	public List<RestaurantName> getOnlineRestaurants() {
		
		return restaurantRepo.getRestaurantByIsOnline("Y");
	}


	@Override
	public Long saveRestaurant(String restaurantName, String restaurantAddress, boolean online) {
		log.debug("Inside save");
		Restaurant res = new Restaurant(restaurantName, restaurantAddress, online?"Y":"N");
		log.info("Save Restaurant :"+res);
		Restaurant res1= restaurantRepo.save(res);
		return res1.getRestaurantId();
	}


	@Override
	@Transactional
	public Long saveItem(String style, String type, String name, BigDecimal cost, Long restaurantId, Integer servings) {
		log.debug("Inside saveItem");
		Restaurant rs = restaurantRepo.findById(restaurantId).orElse(null);
		log.debug("Item to save for Restaurant ID:"+rs.getRestaurantId());
		Item itm = new Item(style, type, name,cost,rs, servings);
		Item itm2= itemRepo.save(itm);
		return itm2.getId();
	}


	@Override
	public RestaurantSO getRestaurantById(Long restaurantId) {
		
		Restaurant rs = restaurantRepo.findById(restaurantId).orElse(null);
		RestaurantSO rso = new RestaurantSO();
		rso.setRestaurantName(rs.getRestaurantName());
		rso.setRestaurantAddress(rs.getRestaurantAddress());
		rso.setOnline(rs.getIsOnline().equalsIgnoreCase("Y")?true:false);
		return rso;
	}
	@Override
	public List<ItemSO> getItems(Long restaurantId){
	
		Restaurant rs = restaurantRepo.findById(restaurantId).orElse(null);
		RestaurantSO rso = new RestaurantSO();
		List<ItemSO> list =  new ArrayList<ItemSO>();
		if(rs!=null)
		{
			 list = rs.getItems().stream().map(item->{
				 
				 ItemSO itm= new ItemSO();
				 
				 itm.setItemId(item.getId());
				 itm.setName(item.getName());
				 itm.setStyle(item.getStyle());
				 itm.setType(item.getType());
				 itm.setServings(item.getServings());
				 itm.setCost(item.getCost());
			    return itm;	 
			 }).collect(Collectors.toList());
		}
		return list;
	}
}
