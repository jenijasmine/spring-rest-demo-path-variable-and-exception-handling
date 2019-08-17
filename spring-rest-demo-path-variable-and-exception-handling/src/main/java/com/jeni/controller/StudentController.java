package com.jeni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeni.entity.Student;
import com.jeni.exceptions.StudentErrorResponse;
import com.jeni.exceptions.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	List<Student> students;
	
	@PostConstruct
	public void generateStudentList() {
		students = new ArrayList<Student>();
		
		students.add(new Student(1,"Jenifa","Nadarajan"));
		students.add(new Student(2,"Varshitha","Balaji"));
		students.add(new Student(3,"Melita","Hephzibah"));
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return students;
	}
	
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable String id) {
		int intid = -1;
		try { 
			intid = Integer.parseInt(id);
		} catch(NumberFormatException nex) {
			throw new StudentNotFoundException("student id invalid!!");
		}
		Student tempStudent = null;
		for(Student s: students) {
			if(s.getId() == intid) {
				tempStudent = s;
				break;
			}
		}
		
		if(tempStudent == null) {
			throw new StudentNotFoundException("student id not found - " + id);
		}
		//return students.get(intid);
		return tempStudent;
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		student.setId(students.get(students.size() -1).getId() +1);
		students.add(student);
		return student;
	   	
	}
	
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
		StudentErrorResponse error= new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	

}
