package com.example.final_nosql.repository;

import com.example.final_nosql.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
