package com.training.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;

	 private String name;
	 
	 @Column(unique = true)
	 private String email;
	 private String password;
	 private String mobileNumber;
	 private String gender;
	 private String role; // STUDENT / ADMIN

	 @CreationTimestamp
	 private LocalDateTime joinedAt; 
	 @UpdateTimestamp
	 private LocalDateTime updatedAt;
	 
	 @ManyToMany(cascade=CascadeType.MERGE)
	 @JoinTable(
			    name = "student_courses",
			    joinColumns = @JoinColumn(name = "student_id"),
			    inverseJoinColumns = @JoinColumn(name = "course_id") 
			)
			private Set<Course> courses;

	public Student(int id, String name, String email, String password, String mobileNumber, String gender, String role,
			LocalDateTime joinedAt, LocalDateTime updatedAt, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.role = role;
		this.joinedAt = joinedAt;
		this.updatedAt = updatedAt;
		this.courses = courses;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", role=" + role + ", joinedAt=" + joinedAt
				+ ", updatedAt=" + updatedAt + ", courses=" + courses + "]";
	}
	 
	 
	    
}
