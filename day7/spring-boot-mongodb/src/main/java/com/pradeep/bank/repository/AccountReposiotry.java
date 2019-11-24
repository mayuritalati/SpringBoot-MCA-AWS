package com.pradeep.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.bank.model.Account;

@Repository
public interface AccountReposiotry extends MongoRepository<Account, Integer>{

}
