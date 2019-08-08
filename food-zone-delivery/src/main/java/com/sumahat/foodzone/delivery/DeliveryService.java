package com.sumahat.foodzone.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumahat.foodzone.svc.DeliverySvc;

@RestController
@RequestMapping("/delivery")
public class DeliveryService {

	@Autowired
	DeliverySvc deliverSvc;
	
	@GetMapping("/ping")
	public String ping()
	{
		return "Hello from Delivery Service";
	}
}
