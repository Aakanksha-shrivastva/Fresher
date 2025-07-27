package com.training.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Course;
import com.training.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	private CourseService courseServ;
	
	public CourseController(CourseService courseServ) {
		this.courseServ = courseServ;
	}

	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> allCourses = courseServ.getAllCourses();
		return ResponseEntity.ok(allCourses);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id){
		Course courseById = courseServ.getCourseById(id);
		return ResponseEntity.ok(courseById);
	}
}
