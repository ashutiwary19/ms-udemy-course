package com.ashu.accounts.service;

import com.ashu.accounts.dto.CustomerDto;

public interface IAccountsService {
	/**
	 * @param customerDto - CustomerDTO Object
	 */
	void createAccount(CustomerDto customerDto);

	CustomerDto fetchAccount(String mobileNumber);

	boolean updateAccount(CustomerDto customerDto);
	
	boolean deleteAccount(String mobileNumber);
	
	boolean updateCommunicationStatus(Long accountNumber);
}
