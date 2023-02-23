package com.example.final_nosql.resource;

import java.util.List;
import java.util.Optional;

import com.example.final_nosql.model.Instructor;
import com.example.final_nosql.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class InstructorController {

    @Autowired
    private InstructorService service;

    @PostMapping("/addInstructor")
    public String saveInstructor(@RequestBody Instructor instructor) {
        service.saveInstructor(instructor);
        return "Added instructor with id : " + instructor.getId();
    }

    @GetMapping("/findAllInstructor")
    public List<Instructor> getInstructor() {
        return service.getInstructor();
    }

    @GetMapping("/findAllInstructor/{id}")
    public Optional<Instructor> getInstructor(@PathVariable String id) {
        return service.getInstructor(id);
    }

    @DeleteMapping("/deleteinstuctor/{id}")
    public String deleteInstructor(@PathVariable String id) {
        service.deleteInstructor(id);
        return "instructor deleted with id : " + id;
    }

}