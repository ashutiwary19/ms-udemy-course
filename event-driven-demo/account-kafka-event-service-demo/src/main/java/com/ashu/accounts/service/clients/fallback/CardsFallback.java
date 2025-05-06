package com.ashu.accounts.service.clients.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ashu.accounts.dto.CardsDto;
import com.ashu.accounts.service.clients.CardsFeignClient;

@Component
public class CardsFallback implements CardsFeignClient {

	@Override
	public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
		return null;
	}
}