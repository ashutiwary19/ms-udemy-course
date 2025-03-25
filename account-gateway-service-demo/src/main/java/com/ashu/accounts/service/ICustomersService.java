package com.ashu.accounts.service;

import com.ashu.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {
	CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
