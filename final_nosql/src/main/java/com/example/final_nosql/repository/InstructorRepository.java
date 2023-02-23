package com.example.final_nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.final_nosql.model.Instructor;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
    Instructor findByEmail(String email);
}
