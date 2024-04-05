package com.ashu.accounts.dto;

import lombok.Data;

@Data
public class AccountsDto {
	private Long accountNumber;

	private String name;

	private String email;

	private String mobileNumber;

	private String branchAddress;
}
