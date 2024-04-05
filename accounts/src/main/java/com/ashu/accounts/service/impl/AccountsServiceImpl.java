package com.ashu.accounts.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ashu.accounts.constants.AccountsConstants;
import com.ashu.accounts.dto.CustomerDto;
import com.ashu.accounts.exception.CustomerAlreadyExistsException;
import com.ashu.accounts.mapper.CustomerMapper;
import com.ashu.accounts.models.Accounts;
import com.ashu.accounts.models.Customer;
import com.ashu.accounts.repository.AccountRespository;
import com.ashu.accounts.repository.CustomerRepository;
import com.ashu.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
	private AccountRespository accountRespository;
	private CustomerRepository customerRepository;

	@Override
	public void createAccount(CustomerDto customerDto) {
		Optional<Customer> oldCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if (oldCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer Already Exists");
		}
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Customer savedCustomer = customerRepository.save(customer);
		Accounts newAccount = accountRespository.save(createAccount(savedCustomer));
	}

	private Accounts createAccount(Customer customer) {
		Accounts newAccount = new Accounts();
		newAccount.setCustomerId(customer.getCustomerId());
		newAccount.setAccountNumber(1000000000000L + new Random().nextLong());
		newAccount.setAccountType(AccountsConstants.SAVINGS);
		newAccount.setBranchAddress(AccountsConstants.ADDRESS);
		return newAccount;

	}

}
