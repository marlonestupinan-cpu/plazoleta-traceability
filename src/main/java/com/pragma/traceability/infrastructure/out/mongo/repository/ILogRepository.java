package com.pragma.traceability.infrastructure.out.mongo.repository;

import com.pragma.traceability.infrastructure.out.mongo.entity.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILogRepository extends MongoRepository<LogEntity, String> {

}
