package com.ashu.loans.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.loans.models.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

	public Optional<Loans> findByMobileNumber(String mobileNumber);

	public Optional<Loans> findByLoanNumber(String loanNumber);

}
