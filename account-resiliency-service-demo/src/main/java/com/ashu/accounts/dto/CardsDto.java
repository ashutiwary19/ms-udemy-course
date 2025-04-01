package com.ashu.accounts.dto;

import lombok.Data;

@Data
public class CardsDto {
	private Long cardId;
	private String mobileNumber;
	private String cardNumber;
	private String cardType;
	private Integer totalLimit;
	private Integer amountUsed;
	private Integer availableAmount;
}
