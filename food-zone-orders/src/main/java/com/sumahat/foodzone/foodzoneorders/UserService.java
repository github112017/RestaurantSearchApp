package com.sumahat.foodzone.foodzoneorders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumahat.foodzone.so.UserSO;
import com.sumahat.foodzone.svc.OrderSvc;


@RestController
@RequestMapping("/users")
public class UserService {
    
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	OrderSvc foodZoneSvc;
	
	@GetMapping
    public String ping(){
		return "Hello from  Users";
	}
	
	@PostMapping("")
	public Long saveUser(@RequestBody UserSO userSO)
	{   log.info("Inside save user service");
		return foodZoneSvc.saveUser(userSO);
	}
}
