package com.example.final_nosql.service;

import com.example.final_nosql.model.Group;
import com.example.final_nosql.model.Student;
import com.example.final_nosql.repository.GroupRepository;
import com.example.final_nosql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service

public class GroupService {
    @Autowired
    private GroupRepository repository;
    private StudentRepository repStudent;


    public String saveGroup(Group instructor) {
        instructor.setId(UUID.randomUUID().toString());
        repository.save(instructor);
        return "Added instructor with id : " + instructor.getId();
    }


    public List<Group> getGroup() {
        return repository.findAll();
    }

    public Optional<Group> getGroup(String id) {
        return repository.findById(id);
    }


    public String deleteGroup(String id) {
        repository.deleteById(id);
        return "instructor deleted with id : " + id;
    }
    public Group addStudentToGroup(Student student, String id){
//        Group groups = repository.findById(id).orElseThrow();
//            int total = groups.getNumberOfStudents() + 1;
//            groups.setNumberOfStudents(total);
//        return repository.save(groups);
        Group group = repository.findById(id).orElseThrow(() -> new RuntimeException("asdfg"));
        List<Student> students = group.getStudents();
        students.add(student);
        group.setNumberOfStudents(students.size());
        group.setStudents(students);

        return repository.save(group);


    }
}
