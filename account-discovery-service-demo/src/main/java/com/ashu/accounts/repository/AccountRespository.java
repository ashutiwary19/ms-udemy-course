package com.ashu.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.ashu.accounts.models.Accounts;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRespository extends JpaRepository<Accounts, Long> {
	Optional<Accounts> findByCustomerId(Long customerId);

	@Transactional
	@Modifying
	void deleteByCustomerId(Long customerId);
}
