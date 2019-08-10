package com.vedantu.ordersmicroservice.Controllers;

import com.vedantu.ordersmicroservice.Entities.Account;
import com.vedantu.ordersmicroservice.Entities.Order;
import com.vedantu.ordersmicroservice.Entities.OrderInventory;
import com.vedantu.ordersmicroservice.Services.AccountService;
import com.vedantu.ordersmicroservice.Services.InventoryService;
import com.vedantu.ordersmicroservice.Services.OrderService;
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

    @Autowired
    private OrderService orderService;

    @Autowired
    private InventoryService inventoryService;

    /**
     * API to create order for a user
     *
     * @param accountId accountId to identify the user
     * TODO : accountID can be taken from currentUser after implementing concepts like Spring Security
     * @param newOrder {@link Order} order created by User
     * @return Order - containing All items which are available in stock (Note:can be all items or few items based on availability)
     *          Unauthorized - if user is not found in db (TODO : this can be handled by spring security session check/authenicated user)
     */
    @PostMapping("{accountId}/placeOrder")
    private ResponseEntity<?> createOrder(
            @PathVariable String accountId,
            @RequestBody Order newOrder) {

        Account account = accountService.getAccountById(accountId);
        Account accountWithNewOrder = null;
        if(account != null) {
            //Items in Stock
            List<OrderInventory> availableItemsInOrder = orderService.getOrderItemsAvailableInStock(newOrder);

            if(availableItemsInOrder.size() == 0) {
                //if nothing is in stock
                String msg = "All Items in your stock are not available, Out of Stock";
                return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST); // In a actual scenario this is not a BAD_REQUEST
            }
            
            //Order Placed
            newOrder.setItems(availableItemsInOrder);
            account.setCurrentOrder(newOrder);
            accountWithNewOrder = accountService.updateAccount(account);

            //update stock
            inventoryService.updateInventory(availableItemsInOrder);

            //return only items which are placed (which are in stock and order created)
            return new ResponseEntity<>(accountWithNewOrder.getCurrentOrder(), HttpStatus.OK);
        } else {
            //if user is not found with id
            String msg = "User not found with this ID";
            return new ResponseEntity<>(msg , HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/createAccount")
    private ResponseEntity<?> createAccount(@RequestBody Account newAccount) {

        Account savedAccount = accountService.createAccount(newAccount);
        System.out.print(savedAccount);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }
}
