package com.vedantu.ordersmicroservice.Repositories;

import com.vedantu.ordersmicroservice.Entities.OrderInventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderInventoryRepository extends MongoRepository<OrderInventory,String> {
}
