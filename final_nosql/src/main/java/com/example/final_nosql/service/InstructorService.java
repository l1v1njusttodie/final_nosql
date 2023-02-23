package com.example.final_nosql.service;

import com.example.final_nosql.model.Instructor;
import com.example.final_nosql.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service

public class InstructorService {
    @Autowired
    private InstructorRepository repository;

    public String saveInstructor(Instructor instructor) {
        instructor.setId(UUID.randomUUID().toString());
        repository.save(instructor);
        return "Added instructor with id : " + instructor.getId();
    }


    public List<Instructor> getInstructor() {
        return repository.findAll();
    }

    public Optional<Instructor> getInstructor(String id) {
        return repository.findById(id);
    }


    public String deleteInstructor(String id) {
        repository.deleteById(id);
        return "instructor deleted with id : " + id;
    }

}
