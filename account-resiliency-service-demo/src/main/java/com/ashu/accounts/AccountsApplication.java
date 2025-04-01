package com.ashu.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ashu.accounts.dto.AccountsContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
// Since we have only created the classes inside the main package within a subpackage
// we do not need to specify the following, but if for some reason
// if the package of other classes and this class is different we need to specify 
// these configs
/*
 * @ComponentScans({ @ComponentScan("com.ashu.accounts.controller") })
 * 
 * @EnableJpaRepositories("com.ashu.accounts.repository")
 * 
 * @EntityScan("com.ashu.accounts.model")
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Accounts microservice REST API documentation", description = "Ashu Accounts microservice REST API documentation", version = "v1", contact = @Contact(name = "Ashu Tiwary", email = "atiwary34@gmail.com"), license = @License(name = "Apache 2.0")), externalDocs = @ExternalDocumentation(description = "Ashu Accounts microservice REST API documentation"))
@EnableConfigurationProperties(value = { AccountsContactInfoDto.class })
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
