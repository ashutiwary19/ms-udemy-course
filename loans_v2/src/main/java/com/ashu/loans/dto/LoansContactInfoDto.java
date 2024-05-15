package com.ashu.loans.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "cards")
public class LoansContactInfoDto {
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;
}
