package com.vedantu.ordersmicroservice.Repositories;

import com.vedantu.ordersmicroservice.Entities.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.RepositoryDefinition;

public interface AddressRepository extends MongoRepository<Address, String> {

}
