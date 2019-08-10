package com.vedantu.ordersmicroservice.Services;

import com.vedantu.ordersmicroservice.Entities.Inventory;
import com.vedantu.ordersmicroservice.Entities.OrderInventory;
import com.vedantu.ordersmicroservice.Entities.StockInventory;
import com.vedantu.ordersmicroservice.Repositories.InventoryRepository;
import com.vedantu.ordersmicroservice.Repositories.StockInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author durgaprasad.kusuma
 */
@Service
public class InventoryService {

    @Autowired
    private StockInventoryRepository stockInventoryRepository;

    /**
     * Method to update stock quantity after order gets placed
     *
     * @param orderedInventories Placed order items
     */
    public void updateInventory(List<OrderInventory> orderedInventories) {

        for(OrderInventory orderInventory : orderedInventories) {
            StockInventory stockInventory = stockInventoryRepository.findById(orderInventory.getInventoryId())
                                                                    .orElse(null);

            if(stockInventory != null) {
                int updatedInStockQuantity = stockInventory.getInStock() - orderInventory.getQuantity();
                stockInventory.setInStock(updatedInStockQuantity);
                stockInventoryRepository.save(stockInventory);
            }
        }

    }
}
