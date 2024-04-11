package com.ashu.accounts.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="customer_id")
	private Long CustomerId;

	private String name;

	private String email;

	private String mobileNumber;
}
