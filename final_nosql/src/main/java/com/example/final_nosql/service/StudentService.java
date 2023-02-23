package com.example.final_nosql.service;

import com.example.final_nosql.model.Student;
import com.example.final_nosql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service

public class StudentService {
    @Autowired
    private StudentRepository repository;

    public String saveStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        if(repository.findByEmail(student.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }
        repository.save(student);
        return "Added student with id : " + student.getId();

    }


    public List<Student> getStudent() {
        return repository.findAll();
    }

    public Optional<Student> getStudent(String id) {
        return repository.findById(id);
    }


    public String deleteStudent(String id) {
        repository.deleteById(id);
        return "student deleted with id : " + id;
    }

    public List<Student> addCourseToAll(String course){
        List<Student> students = repository.findAll();
        for (Student student : students) {
            List<String> courses = student.getCourse();
            courses.add(course);
            student.setCourse(courses);
        }
        return repository.saveAll(students);


    }
}
