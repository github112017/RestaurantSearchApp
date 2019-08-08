package com.sumahat.foodzone.foodzonepoints;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sumahat.foodzone.model.Restaurant;
import com.sumahat.foodzone.model.RestaurantName;
import com.sumahat.foodzone.so.ItemSO;
import com.sumahat.foodzone.so.RestaurantSO;
import com.sumahat.foodzone.svc.FoodZonePointsSvc;

@RefreshScope
@RestController
@RequestMapping("/restaurants")
public class FoodZonePointService {
	private static final Logger log = LoggerFactory.getLogger(FoodZonePointService.class);
	
	@Autowired
	FoodZonePointsSvc foodZonePointSvc;
	
	@Value("${points-message}")
	private String message;
	
	@RequestMapping("/msg")
    String getMsg() {
        return this.message;
    }
	
	@RequestMapping(value= "/employee/all", method= RequestMethod.GET)
	public String ping(){
			return "OK";
	}
	
	@GetMapping("/{restaurantId}")
	public RestaurantSO getRestaurant(@PathVariable("restaurantId") Long restaurantId) {
		log.debug("from getRestaurant");
		RestaurantSO rso = foodZonePointSvc.getRestaurantById(restaurantId);
		return rso;
	}
	
	@GetMapping("/all")
	public List<RestaurantSO> getAll() {
		log.debug("from getAll");
		List<Restaurant> list = foodZonePointSvc.getRestaurants();
		List<RestaurantSO> rso = list
				.stream()
				.map(restro -> {
					return new RestaurantSO(restro.getRestaurantName(), restro
							.getRestaurantAddress(), restro.getIsOnline()
							.equalsIgnoreCase("Y") ? true : false);

				}).collect(Collectors.toList());
		return rso;
	}
    @GetMapping("/all/online")
  	public List<RestaurantName> get(){
  		return foodZonePointSvc.getOnlineRestaurants();
  	}
    @PostMapping("/save")
   	public void save(@RequestBody RestaurantSO rso){
   		log.debug("inside save Restaurant");
    	foodZonePointSvc.saveRestaurant(rso.getRestaurantName(), rso.getRestaurantAddress(), rso.isOnline());
   	}
    
    
    @PostMapping("/{restaurantId}/item/save/")
   	public Long save(@PathVariable("restaurantId") Long restaurantId,@RequestBody ItemSO item){
   		log.debug("inside save item");
    	return foodZonePointSvc.saveItem(item.getStyle(), item.getType(), item.getName(), item.getCost(), restaurantId, item.getServings());
   	}

    
    @GetMapping("/{restaurantId}/item/")
   	public List<ItemSO> getAllItems(@PathVariable("restaurantId") Long restaurantId){
   		log.debug("inside getAll items");
    	return foodZonePointSvc.getItems(restaurantId);
   	}
}
