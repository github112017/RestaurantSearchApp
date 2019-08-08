package com.sumahat.foodzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumahat.foodzone.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
