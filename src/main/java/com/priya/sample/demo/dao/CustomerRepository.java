package com.priya.sample.demo.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    // Custom query methods (optional)
    List<CustomerEntity> findByLocation(String location);
}
