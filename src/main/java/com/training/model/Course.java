package com.training.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int courseid;
	@Column(nullable=false)
	private String coursename;
	@Column(nullable=false, name="duration(in months)")
	private int duration;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students = new HashSet<>();
	
	public Course() {
		
	}
	public Course(int courseid, String coursename, int duration) {
		
		this.courseid = courseid;
		this.coursename = coursename;
		this.duration = duration;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", duration=" + duration + ", students="
				+ students + "]";
	}	
}
