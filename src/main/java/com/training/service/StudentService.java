package com.training.service;

import java.util.List;
import java.util.Set;

import com.training.dto.StudentDto;
import com.training.model.Student;

public interface StudentService {

	 	Student createStudent(StudentDto studentDto);
	    Student updateStudent(int studentId, StudentDto studentDto);
	    Student getStudentById(int studentId);
	    Student getStudentByEmail(String email);
	    List<Student> getAllStudents();
	    void deleteStudent(int studentId);
	    Student enrollInCourses(int studentId, Set<Integer> courseid);
}
