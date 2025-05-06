package com.ashu.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.ashu.accounts.constants.AccountsConstants;
import com.ashu.accounts.dto.AccountsDto;
import com.ashu.accounts.dto.AccountsMsgDto;
import com.ashu.accounts.dto.CustomerDto;
import com.ashu.accounts.exception.CustomerAlreadyExistsException;
import com.ashu.accounts.exception.ResourceNotFoundException;
import com.ashu.accounts.mapper.AccountsMapper;
import com.ashu.accounts.mapper.CustomerMapper;
import com.ashu.accounts.models.Accounts;
import com.ashu.accounts.models.Customer;
import com.ashu.accounts.repository.AccountRespository;
import com.ashu.accounts.repository.CustomerRepository;
import com.ashu.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AccountsServiceImpl implements IAccountsService {
	private final AccountRespository accountRespository;
	private CustomerRepository customerRepository;
	private final StreamBridge streamBridge;

	@Override
	public void createAccount(CustomerDto customerDto) {
		Optional<Customer> oldCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if (oldCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer Already Exists");
		}
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("accounts-service");
		Customer savedCustomer = customerRepository.save(customer);
		Accounts account = accountRespository.save(createAccount(savedCustomer));
		sendCommunication(account, savedCustomer);
	}

	private void sendCommunication(Accounts account, Customer customer) {
		AccountsMsgDto accountsMsgDto = new AccountsMsgDto(account.getAccountNumber(), customer.getName(),
				customer.getEmail(), customer.getMobileNumber());

		log.info("Sending communcation request for details: {} ", accountsMsgDto);
		boolean isSuccess = streamBridge.send("sendCommunication-out-0", accountsMsgDto);
		log.info("Sending communcation success status : ", isSuccess);

	}

	private Accounts createAccount(Customer customer) {
		Accounts newAccount = new Accounts();
		long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
		newAccount.setCustomerId(customer.getCustomerId());
		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setAccountType(AccountsConstants.SAVINGS);
		newAccount.setBranchAddress(AccountsConstants.ADDRESS);
		return newAccount;

	}

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

		Accounts account = accountRespository.findByCustomerId(customer.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Account", "mobileNumber", mobileNumber));

		CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));

		return customerDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		boolean isUpdated = false;
		AccountsDto accountsDto = customerDto.getAccountsDto();
		if (accountsDto != null) {
			Accounts accounts = accountRespository.findById(accountsDto.getAccountNumber())
					.orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber",
							accountsDto.getAccountNumber().toString()));
			AccountsMapper.mapToAccounts(accountsDto, accounts);
			accounts = accountRespository.save(accounts);

			Long customerId = accounts.getCustomerId();
			Customer customer = customerRepository.findById(customerId)
					.orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString()));
			CustomerMapper.mapToCustomer(customerDto, customer);
			customerRepository.save(customer);
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
		accountRespository.deleteByCustomerId(customer.getCustomerId());
		customerRepository.deleteById(customer.getCustomerId());
		return true;
	}

	@Override
	public boolean updateCommunicationStatus(Long accountNumber) {
		boolean isUpdated = false;
		if (accountNumber != null) {
			Accounts accounts = accountRespository.findById(accountNumber).orElseThrow(
					() -> new ResourceNotFoundException("Account", "AccountNumber", accountNumber.toString()));

			accounts.setCommunicationSw(true);
			accountRespository.save(accounts);
			isUpdated = true;
		}

		return isUpdated;
	}

}
