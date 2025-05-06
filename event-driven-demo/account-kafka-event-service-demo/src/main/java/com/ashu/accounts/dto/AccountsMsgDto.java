package com.ashu.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsMsgDto {
	private Long accountNumber;
	private String name;
	private String email;
	private String mobileNumber;
}
