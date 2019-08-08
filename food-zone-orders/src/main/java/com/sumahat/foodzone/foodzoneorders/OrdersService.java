package com.sumahat.foodzone.foodzoneorders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumahat.foodzone.so.OrderSO;
import com.sumahat.foodzone.svc.OrderSvc;

@RestController
@RequestMapping("/orders")
public class OrdersService {
    
	private static Logger log = LoggerFactory.getLogger(OrdersService.class);
	
	@Autowired
    OrderSvc orderSvc;
	
	@RequestMapping("/msg")
    String getMsg() {
        return "ORDERS";
    }
	
	@GetMapping
    public String ping(){
		return "Hello from  Orders";
	}
	@PostMapping
	public Long saveOrders(@RequestBody OrderSO orderSO)
	{   log.info("Inside save order service");
		return orderSvc.saveOrder(orderSO);
	}
	
}

