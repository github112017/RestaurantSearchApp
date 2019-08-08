package com.sumahat.foodzone.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.sumahat.foodzone.repository")
@EntityScan("com.sumahat.foodzone.model")
@ComponentScan("com.sumahat.foodzone")
public class FoodZoneDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodZoneDeliveryApplication.class, args);
	}

}
