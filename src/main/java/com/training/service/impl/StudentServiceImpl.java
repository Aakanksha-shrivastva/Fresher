package com.training.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.training.dto.StudentDto;
import com.training.model.Course;
import com.training.model.Student;
import com.training.repository.CourseRepository;
import com.training.repository.StudentRepository;
import com.training.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepo;
	private CourseRepository courseRepo;

	public StudentServiceImpl(StudentRepository studentRepo, CourseRepository courseRepo) {
		this.studentRepo = studentRepo;
		this.courseRepo = courseRepo;

	}

	@Override 
	public Student createStudent(StudentDto studentDto) {
		Student stu=new Student();
		stu.setName(studentDto.getName());
		stu.setEmail(studentDto.getEmail());
		stu.setPassword(studentDto.getPassword());
		stu.setMobileNumber(studentDto.getMobileNumber());
		stu.setGender(studentDto.getGender());
		stu.setRole("STUDENT");

		if (studentDto.getCourseid() != null && !studentDto.getCourseid().isEmpty()) {
            Set<Course> courses = studentDto.getCourseid().stream()
                .map(id -> courseRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Invalid Course ID: " + id)))
                .collect(Collectors.toSet());

            stu.setCourses(courses);
        }
		
		return studentRepo.save(stu);
	}

	@Transactional
	@Override
	public Student updateStudent(int studentId, StudentDto studentDto) {
		
	      Student student = studentRepo.findById(studentId)
	                .orElseThrow(() -> new RuntimeException("Student not found"));
		
	    student.setName(studentDto.getName());
		student.setEmail(studentDto.getEmail());
		student.setMobileNumber(studentDto.getMobileNumber());
		student.setGender(studentDto.getGender());

		if(studentDto.getPassword()!=null) {
			student.setPassword(studentDto.getPassword());
		}
		if (studentDto.getCourseid() != null && !studentDto.getCourseid().isEmpty()) {
            Set<Course> courses = new HashSet<>(courseRepo.findAllById(studentDto.getCourseid()));
            student.setCourses(courses);
        }
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentRepo.findById(studentId)
				.orElseThrow(()->new RuntimeException("Student not found"));
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> all = studentRepo.findAll();
		return all;
	}

	@Override
	public void deleteStudent(int studentId) {
		if(!studentRepo.existsById(studentId)) {
			throw new RuntimeException("Student not found!!");
		}
		studentRepo.deleteById(studentId);
	}

	 @Override
	    public Student enrollInCourses(int studentId, Set<Integer> courseIds) {
	        Student student = studentRepo.findById(studentId)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        Set<Course> courses = new HashSet<>(courseRepo.findAllById(courseIds));
	        student.getCourses().addAll(courses);

	        return studentRepo.save(student);
	    }

	@Override
	public Student getStudentByEmail(String email) {
		return studentRepo.findByEmail(email)
				.orElseThrow(()->new RuntimeException("Student not found"));
	}

}
