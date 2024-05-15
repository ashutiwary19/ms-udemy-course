package com.ashu.cards.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "cards")
public class CardsContactInfoDto {
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;
}
