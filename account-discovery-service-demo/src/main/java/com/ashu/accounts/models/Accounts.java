package com.ashu.accounts.models;

import jakarta.persistence.Entity;
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
public class Accounts extends AuditedEntity {

	// These annotations tells spring jpa to generate the id automatically
	// and the native type tells to generate the id in the native type of the
	// database
	@Id
	private Long accountNumber;

	private Long customerId;

	private String name;

	private String email;

	private String mobileNumber;

	private String branchAddress;
	
	private String accountType;
}
