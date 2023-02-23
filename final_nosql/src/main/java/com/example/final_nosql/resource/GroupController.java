package com.example.final_nosql.resource;

import java.util.List;
import java.util.Optional;

import com.example.final_nosql.model.Group;
import com.example.final_nosql.model.Student;
import com.example.final_nosql.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GroupController {

    @Autowired
    private GroupService service;

    @PostMapping("/addGroup")
    public String saveGroup(@RequestBody Group group) {
        service.saveGroup(group);
        return "Added group with id : " + group.getId();
    }

    @GetMapping("/findAllGroup")
    public List<Group> getGroup() {
        return service.getGroup();
    }

    @GetMapping("/findAllGroup/{id}")
    public Optional<Group> getGroup(@PathVariable String id) {
        return service.getGroup(id);
    }

    @DeleteMapping("/deletegroup/{id}")
    public String deleteGroup(@PathVariable String id) {
        service.deleteGroup(id);
        return "group deleted with id : " + id;
    }

    @PutMapping("/addStudentToGroup/{id}")
    public Group updateGroup(@PathVariable String id, @RequestBody Student student){
        return service.addStudentToGroup(student, id);
    }
}