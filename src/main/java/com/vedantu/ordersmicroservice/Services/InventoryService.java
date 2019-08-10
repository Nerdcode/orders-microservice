package com.vedantu.ordersmicroservice.Services;

import com.vedantu.ordersmicroservice.Entities.Inventory;
import com.vedantu.ordersmicroservice.Entities.OrderInventory;
import com.vedantu.ordersmicroservice.Entities.StockInventory;
import com.vedantu.ordersmicroservice.Repositories.InventoryRepository;
import com.vedantu.ordersmicroservice.Repositories.StockInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Method to store all the newly added inventory
     *
     * @param stockInventory
     * @return
     */
    public List<StockInventory> addInventory(List<StockInventory> stockInventory) {

        //TODO : can check if the same type of inventory is already exists. if also just increase the instockQuantity
        return stockInventory.parallelStream()
                    .map(sInv -> stockInventoryRepository.save(sInv))
                    .collect(Collectors.toList());
    }

    /**
     * Method to get all stock inventory available
     *
     * @return
     */
    public List<StockInventory> getAllStockInventory() {

        return stockInventoryRepository.findAll();
    }
}
