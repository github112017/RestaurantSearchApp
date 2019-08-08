package com.sumahat.foodzone.svc;

import com.sumahat.foodzone.so.OrderSO;
import com.sumahat.foodzone.so.UserSO;

public interface OrderSvc {
	
	
	public Long saveUser(UserSO userSO);
	
	public Long saveOrder(OrderSO orderSO);
	
	

}
