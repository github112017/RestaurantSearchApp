package com.sumahat.foodzone.svc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.sumahat.foodzone.model.ItemOrder;
import com.sumahat.foodzone.model.Order;
import com.sumahat.foodzone.model.User;
import com.sumahat.foodzone.repository.OrderRepository;
import com.sumahat.foodzone.repository.UserRepository;
import com.sumahat.foodzone.so.ItemSO;
import com.sumahat.foodzone.so.OrderSO;
import com.sumahat.foodzone.so.UserSO;

@Service
public class OrderSvcImpl implements OrderSvc {

	private static Logger log = LoggerFactory.getLogger(OrderSvcImpl.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	@Autowired  
	KafkaAdmin kafka;
	    
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	@Override
	public Long saveUser(UserSO userSO) {
		
	log.debug("Inside save user");
	User user = new User();
	user.setName(userSO.getFirstName()+" "+userSO.getLastName());
	user.setEmail(userSO.getEmail());
	user.setMobile(userSO.getMobile());
	user.setAddress(userSO.getAddress());
	user.setCity(userSO.getCity());
	user.setPincode(userSO.getPincode());
	User savedUser = userRepo.save(user);
	log.info("User saved with userId :"+savedUser.getUserId());
	return savedUser.getUserId();
	}

	@Override
	@Transactional
	public Long saveOrder(OrderSO orderSO) {

		User user = userRepo.findById(orderSO.getUserId()).orElse(null);
		if (user != null) {
			// validate restaurant and items
			Map<String, Long> uri = new HashMap();
			uri.put("restaurantId", orderSO.getRestaurantId());
			ResponseEntity<ItemSO[]> response = restTemplate()
					.getForEntity(
							"http://localhost:8082/fp/restaurants/{restaurantId}/item/",
							ItemSO[].class, uri);

			ItemSO[] so = response.getBody();
			List<ItemSO> list = new ArrayList<ItemSO>();

			for(ItemSO it:so){
				list.add(it);
			}

			Order validOrder = new Order();
			List<ItemOrder> filteredItemSO = list
					.stream()
					.filter(item -> orderSO.getItemId().contains(
							item.getItemId())).map(itemSO -> {
						ItemOrder item = new ItemOrder();
						item.setItemId(itemSO.getItemId());
						item.setOrder(validOrder);
						return item;
					}).collect(Collectors.toList());

			validOrder.setOrderStatus("New");
			validOrder.setPaymentStatus("Paid");
			validOrder.setRestaurantId(orderSO.getRestaurantId());
		    validOrder.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			validOrder.setUser(user);
			
			validOrder.setItems(filteredItemSO);
			Long orderId =  orderRepo.save(validOrder).getOrderId();
			//putting on Kafka topic for delivery App to see new Order
		
			kafkaTemplate.send("thetechcheck",orderSO);
			

	        Message<OrderSO> message = MessageBuilder
	                .withPayload(orderSO)
	                .setHeader(KafkaHeaders.TOPIC, "thetechcheck")
	                .build();
	        
	        kafkaTemplate.send(message);
			return orderId;
		}
		return 0l;

	}
	
	
}
