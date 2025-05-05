package com.ashu.accounts.service.clients.fallback;

import com.ashu.accounts.dto.LoansDto;
import com.ashu.accounts.service.clients.LoansFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient {

	@Override
	public ResponseEntity<LoansDto> fetchLoanDetails(String correlationId, String mobileNumber) {
		return null;
	}
}