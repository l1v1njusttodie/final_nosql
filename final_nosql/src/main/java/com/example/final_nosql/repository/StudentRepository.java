package com.example.final_nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.final_nosql.model.Student;


public interface StudentRepository extends MongoRepository<Student, String>{
    Student findByEmail(String email);

}
