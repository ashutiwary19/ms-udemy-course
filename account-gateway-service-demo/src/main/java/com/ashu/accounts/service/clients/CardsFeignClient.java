package com.ashu.accounts.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashu.accounts.dto.CardsDto;

@FeignClient("cards")
public interface CardsFeignClient {

	@GetMapping(value = "/api/fetch", consumes = "application/json")
	public ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader("bank-correlation-id") String correlationId,
			@RequestParam String mobileNumber);
}
