package com.vedantu.ordersmicroservice.Services;

import com.vedantu.ordersmicroservice.Entities.Account;
import com.vedantu.ordersmicroservice.Entities.Order;
import com.vedantu.ordersmicroservice.Entities.OrderInventory;
import com.vedantu.ordersmicroservice.Entities.StockInventory;
import com.vedantu.ordersmicroservice.Repositories.InventoryRepository;
import com.vedantu.ordersmicroservice.Repositories.StockInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author durgaprasad.kusuma
 */
@Service
public class OrderService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StockInventoryRepository stockInventoryRepo;

    /**
     * Method to get all the order items which are available in stock Inventory
     *
     * @param order {@link Order} order created by user
     * @return List<OrderInventory> list of all available items in stock from created order
     */
    public List<OrderInventory> getOrderItemsAvailableInStock(Order order) {

        return order.getItems()
                .stream()
                .filter(item -> hasInStock(item))
                .collect(Collectors.toList());
    }

    /**
     * Method to check whether placed orders items are still available in stock
     * assumption : if order quantity of same type are available in stock then only order else dont order(same type)
     *
     * TODO
     * this method has to be excecuted in synchronized way (if several orders placed on same inventory type)
     *
     * @param item {@link OrderInventory}
     * @return boolean
     */
    private boolean hasInStock(OrderInventory item) {

        StockInventory stockInventory = stockInventoryRepo.findById(item.getInventoryId()).orElse(null);
        if(stockInventory  != null) {
            if(stockInventory.getInStock() - item.getQuantity() >= 0) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public List<Order> getcurrentOrder(String accountId) {

        Account account = accountService.getAccountById(accountId);
        if(account != null) {
            return account.getCurrentOrders();
        } else {
            return new ArrayList<>();
        }
    }

}
