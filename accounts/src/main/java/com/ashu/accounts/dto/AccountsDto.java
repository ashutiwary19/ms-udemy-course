package com.ashu.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
	@NotEmpty(message="AccountNumber cannot be empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	private Long accountNumber;

	private String name;

	private String email;

	private String mobileNumber;

	@NotEmpty(message="BranchAddress cannot be empty")
	private String branchAddress;

	@NotEmpty(message="AccountType cannot be empty")
	private String accountType;
}
