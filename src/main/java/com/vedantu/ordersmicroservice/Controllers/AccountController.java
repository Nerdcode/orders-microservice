package com.vedantu.ordersmicroservice.Controllers;

import com.vedantu.ordersmicroservice.Entities.Account;
import com.vedantu.ordersmicroservice.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/placeOrder")
    private ResponseEntity<?> createOrder(@RequestBody String newOrder) {

        return new ResponseEntity<>(new String("Hi"), HttpStatus.OK);
    }

    @PostMapping("/createAccount")
    private ResponseEntity<?> createAccount(@RequestBody Account newAccount) {
        Account savedAccount = accountService.createAccount(newAccount);
        System.out.print(savedAccount);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }
}
