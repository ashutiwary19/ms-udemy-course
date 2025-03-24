package com.ashu.accounts.service.impl;

import org.springframework.stereotype.Service;

import com.ashu.accounts.dto.AccountsDto;
import com.ashu.accounts.dto.CustomerDetailsDto;
import com.ashu.accounts.exception.ResourceNotFoundException;
import com.ashu.accounts.mapper.AccountsMapper;
import com.ashu.accounts.mapper.CustomerMapper;
import com.ashu.accounts.models.Accounts;
import com.ashu.accounts.models.Customer;
import com.ashu.accounts.repository.AccountRespository;
import com.ashu.accounts.repository.CustomerRepository;
import com.ashu.accounts.service.ICustomersService;
import com.ashu.accounts.service.clients.CardsFeignClient;
import com.ashu.accounts.service.clients.LoansFeignClient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService implements ICustomersService {
	private AccountRespository accountRespository;
	private CustomerRepository customerRepository;
	private CardsFeignClient cardsClient;
	private LoansFeignClient loansClient;

	@Override
	public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

		Accounts account = accountRespository.findByCustomerId(customer.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Account", "mobileNumber", mobileNumber));

		CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer,
				new CustomerDetailsDto());
		customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
		customerDetailsDto.setLoansDto(loansClient.fetchLoanDetails(mobileNumber).getBody());
		customerDetailsDto.setCardsDto(cardsClient.fetchCardDetails(mobileNumber).getBody());
		return customerDetailsDto;
	}

}
