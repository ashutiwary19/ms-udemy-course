package com.ashu.accounts.functions;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ashu.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@AllArgsConstructor
public class AccountsFunction {

	private final IAccountsService accountsService;

	@Bean
	public Consumer<Long> updateCommunication() {
		return accountNumber -> {
			log.info("Updating communication status for accountNumner : " + accountNumber.toString());
			accountsService.updateCommunicationStatus(accountNumber);
		};
	}

}
