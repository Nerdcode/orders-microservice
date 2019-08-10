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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author durgaprasad.kusuma
 */
@RestController
@RequestMapping("/account/{accountId}") //accountId accountId to identify the user
//TODO : accountID can be taken from currentUser after implementing concepts like Spring Security

public class OrderController {

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
    @PostMapping("/placeOrder")
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
            newOrder.setOrderDate(LocalDateTime.now());

            if(!(account.getCurrentOrders() == null)) {
                account.getCurrentOrders().add(newOrder);
            } else {
                List<Order> orders = new ArrayList<>();
                orders.add(newOrder);
                account.setCurrentOrders(orders);
            }
            accountWithNewOrder = accountService.updateAccount(account);

            //update stock
            inventoryService.updateInventory(availableItemsInOrder);

            //return only items which are placed (which are in stock and order created)
            //TODO can also send items which are not Ordered bcz of out of stock
            return new ResponseEntity<>(accountWithNewOrder.getCurrentOrders(), HttpStatus.OK);
        } else {
            //if user is not found with id
            String msg = "User not found with this ID";
            return new ResponseEntity<>(msg , HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     *
     * API to get all current orders with are not delievered yet
     *
     * @param accountId
     * @return List<Order> list of all Orders
     */
    @GetMapping("/orderDetails")
    private ResponseEntity<?> getCurrentOrderDetails(@PathVariable String accountId) {

        List<Order> currentOrders = orderService.getcurrentOrder(accountId);

        if(currentOrders != null && currentOrders.size() > 0) {
            return new ResponseEntity<>(currentOrders, HttpStatus.OK);
        } else {
            //if user is not found with id
            String msg = "No current Orders for this Account / User not found with this ID";
            return new ResponseEntity<>(msg , HttpStatus.OK);
        }
    }

    /**
     * API to cancel order(one item in order)
     *
     * @param accountId
     * @param itemId
     * @return
     */
    @DeleteMapping("/cancelOrder")
    private ResponseEntity<?> cancelOrder(@PathVariable String accountId, @RequestParam String itemId) {

        //TODO : need to be implemeneted
        //user can cancel any single item from his current orders
        String msg = "Not Implemented";
        return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);

    }

    /**
     * API to change status of delivered item in order and store orderhistory
     *
     * @param accountId
     * @param itemId
     * @return
     */
    @PutMapping("/orderDelievered/{itemId}")
    private ResponseEntity<?> itemDelievered(@PathVariable String accountId, @PathVariable String itemId) {
        //TODO : need to be implemeneted
        //once a item is delivered, status changes of isDelievered to true
        //moves from current orders to OrderHistory
        String msg = "Not Implemented";
        return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
    }
}
