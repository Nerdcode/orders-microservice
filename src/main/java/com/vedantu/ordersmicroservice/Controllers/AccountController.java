package com.vedantu.ordersmicroservice.Controllers;

import com.vedantu.ordersmicroservice.Entities.Account;
import com.vedantu.ordersmicroservice.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * @author durgaprasad.kusuma
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * API to create new Account
     *
     * @param newAccount
     * @return account after creation
     */
    @PostMapping("/create")
    private ResponseEntity<?> createAccount(@RequestBody Account newAccount) {

        if(newAccount.getUsername() != null)  {//&& newAccount.getAccountEmail()!=null && newAccount.getAccountPhone() != null)
            Account savedAccount = accountService.createAccount(newAccount);
            return new ResponseEntity<>(savedAccount, HttpStatus.OK);
        } else {
            String msg = "Username must not be null";
            return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * API to get Deatails
     *
     * @param accountId
     * @return
     */
    @GetMapping("/details/{accountId}")
    private  ResponseEntity<?> getAccountDetails(@PathVariable String accountId) {

        Account account = accountService.getAccountById(accountId);
        if(account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            //if user is not found with id
            String msg = "User not found with this ID";
            return new ResponseEntity<>(msg , HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/delete/{accountId}")
    private  ResponseEntity<?> deleteAccount(@PathVariable String accountId)  {
        //TODO : need to be implemeneted
        String msg = "Not Implemented, Oops you can't delete";
        return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    private ResponseEntity<?> updateAccount(@RequestBody Account newAccount) {

        //TODO : need to be implemeneted
        String msg = "Not Implemented, You can't update";
        return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
    }
}
