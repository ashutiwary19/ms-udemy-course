package com.ashu.accounts.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AuditedEntity {
	
	//These anotations tells spring jpa to generate the id automatically
	// and the native type tells to generate the id in the native type of the database
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", type = IdentifierGenerator.class)
	private Long CustomerId;

	private String name;

	private String email;

	private String mobileNumber;
}
