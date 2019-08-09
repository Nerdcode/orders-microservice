package com.vedantu.ordersmicroservice.Repositories;

import com.vedantu.ordersmicroservice.Entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

}
