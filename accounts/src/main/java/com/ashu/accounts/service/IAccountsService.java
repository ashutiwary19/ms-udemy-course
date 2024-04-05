package com.ashu.accounts.service;

import com.ashu.accounts.dto.CustomerDto;

public interface IAccountsService {
	/**
	 * @param customerDto - CustomerDTO Object
	 */
	void createAccount(CustomerDto customerDto);
}
