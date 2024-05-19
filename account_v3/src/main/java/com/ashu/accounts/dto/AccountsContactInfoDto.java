package com.ashu.accounts.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "accounts")
public class AccountsContactInfoDto {
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;
}
