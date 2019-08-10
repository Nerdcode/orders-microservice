package com.vedantu.ordersmicroservice.Repositories;

import com.vedantu.ordersmicroservice.Entities.Inventory;
import com.vedantu.ordersmicroservice.Entities.StockInventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockInventoryRepository extends MongoRepository<StockInventory, String> {

}
