package com.tayna.shared.repository;

import com.tayna.shared.model.shared;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedRepository extends MongoRepository<Shared, String> {
    
}
