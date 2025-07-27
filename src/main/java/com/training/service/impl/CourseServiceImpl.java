package com.training.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.training.model.Course;
import com.training.repository.CourseRepository;
import com.training.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	private CourseRepository courseRepo;
	
	public CourseServiceImpl(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> all = courseRepo.findAll();
		return all;
	}

	@Override
	public Course getCourseById(int courseid) {
		Optional<Course> byId = courseRepo.findById(courseid);
		
		if(byId.isPresent()) {
			return byId.get();
		}
		else {
			throw new RuntimeException("Course not found with id :"+courseid);
		}
	}

}
