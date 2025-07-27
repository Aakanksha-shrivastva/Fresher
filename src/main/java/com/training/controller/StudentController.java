package com.training.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.StudentDto;
import com.training.model.Student;
import com.training.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	@PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto dto) {
        Student saved = studentServ.createStudent(dto);
        return ResponseEntity.ok(saved);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody StudentDto student){
		Student updateStudent = studentServ.updateStudent(id, student);
		return ResponseEntity.ok(updateStudent);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		
		Student studentById = studentServ.getStudentById(id);
		return ResponseEntity.ok(studentById);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents = studentServ.getAllStudents();
		return ResponseEntity.ok(allStudents);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		studentServ.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully!!");
	}
	
	@PostMapping("/{id}/enroll")
    public ResponseEntity<Student> enrollInCourses(@PathVariable int id,@RequestBody Set<Integer> courseid) {
		Student student = studentServ.enrollInCourses(id, courseid);
		return ResponseEntity.ok(student);
	}
		
}
