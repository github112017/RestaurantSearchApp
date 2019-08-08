package com.sumahat.foodzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumahat.foodzone.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
