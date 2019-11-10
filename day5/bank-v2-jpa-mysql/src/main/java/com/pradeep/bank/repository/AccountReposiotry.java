package com.pradeep.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.bank.model.Account;

@Repository
public interface AccountReposiotry extends JpaRepository<Account, Integer>{

}
