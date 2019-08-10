package com.vedantu.ordersmicroservice.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    private ResponseEntity<?> getAllInventory(){
        return new ResponseEntity<>(new String("Hi"), HttpStatus.OK);
    }
}
