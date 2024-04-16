package com.ashu.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "CRUD Rest Apis for Card in ashu ms setup", description = "CRUD Rest Apis for Card in ashu ms setup", version = "v1", contact = @Contact(name = "Ashu Tiwary", email = "atiwary34@gmail.com"), license = @License(name = "Apache 2.0")), externalDocs = @ExternalDocumentation(description = "Ashu Accounts microservice REST API documentation"))
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
