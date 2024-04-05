package com.ashu.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.accounts.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
