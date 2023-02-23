package com.example.final_nosql.resource;

import java.util.List;
import java.util.Optional;

import com.example.final_nosql.model.Student;
import com.example.final_nosql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/addStudent")
	public String saveStudent(@RequestBody Student student) {
		service.saveStudent(student);
		return "Added student with id : " + student.getId();
	}

	@GetMapping("/findAllStudent")
	public List<Student> getStudent() {
		return service.getStudent();
	}

	@GetMapping("/findAllStudent/{id}")
	public Optional<Student> getStudent(@PathVariable String id) {
		return service.getStudent(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		service.deleteStudent(id);
		return "student deleted with id : " + id;
	}

	@PutMapping("/addCourses")
	public List<Student> updateCourses(@RequestBody String course){
		return service.addCourseToAll(course);
	}
}
