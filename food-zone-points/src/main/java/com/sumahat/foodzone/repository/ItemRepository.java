package com.sumahat.foodzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumahat.foodzone.model.Item;


public interface ItemRepository extends JpaRepository<Item, Long>{

}
