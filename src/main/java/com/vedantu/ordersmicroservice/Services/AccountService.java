package com.vedantu.ordersmicroservice.Services;

import com.vedantu.ordersmicroservice.Entities.Account;
import com.vedantu.ordersmicroservice.Entities.Order;
import com.vedantu.ordersmicroservice.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author durgaprasad.kusuma
 */

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account newAccount) {

        return accountRepository.save(newAccount);
    }

    public Account updateAccount(Account updatedAccount) {
        return accountRepository.save(updatedAccount);
    }

    public Account getAccountById(String accountId) {

        return accountRepository.findById(accountId)
                                .orElse(null);
        //TODO
        //can be handled in a better way using excpetions if account is not found.
    }
}
