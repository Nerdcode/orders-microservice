package com.vedantu.ordersmicroservice.Repositories;

import com.vedantu.ordersmicroservice.Entities.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

}
