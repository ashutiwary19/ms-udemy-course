package com.ant.message.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ASHU
 *
 */
@Data
@AllArgsConstructor
public class AccountsMsgDto {
	private Long accountNumber;
	private String name;
	private String email;
	private String mobileNumber;
}
