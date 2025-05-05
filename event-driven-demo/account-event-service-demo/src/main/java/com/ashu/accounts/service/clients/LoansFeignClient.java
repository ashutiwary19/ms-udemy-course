package com.ashu.accounts.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashu.accounts.dto.LoansDto;
import com.ashu.accounts.service.clients.fallback.LoansFallback;

@FeignClient(name = "loans", fallback = LoansFallback.class)
public interface LoansFeignClient {

	@GetMapping(value = "/api/fetch", consumes = "application/json")
	public ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("bank-correlation-id") String correlationId,
			@RequestParam String mobileNumber);
}
