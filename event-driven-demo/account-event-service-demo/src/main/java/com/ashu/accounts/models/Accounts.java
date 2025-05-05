package com.ashu.accounts.models;

import jakarta.persistence.Column;
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

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "account_number")
	@Id
	private Long accountNumber;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "communication_sw")
	private Boolean communicationSw;
}
