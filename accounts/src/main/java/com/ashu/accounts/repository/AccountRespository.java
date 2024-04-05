package com.ashu.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.accounts.models.Accounts;

@Repository
public interface AccountRespository extends JpaRepository<Accounts, Long> {

}
