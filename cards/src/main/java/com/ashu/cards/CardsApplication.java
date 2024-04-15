package com.ashu.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CRUD Rest Apis for Card in ashu ms setup", description = "CRUD Rest Apis for Card in ashu ms setup")
@SpringBootApplication
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
