package com.neosoft.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.neosoft.model.Student;
import com.neosoft.springboot.myexception.ResourceNotFoundException;
import com.neosoft.dao.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentrepo;
	
	
	
	
	//Add Student
	@PostMapping("/addStudnet")
	public Student addStudent(@Valid @RequestBody Student student)
	{
		return studentrepo.save(student);
	}
	
	//Get Student
	@GetMapping("/getStudent")
	public List<Student> getAllStudent(){
		return studentrepo.findAll();
		
	}
	
	
	
	//Get Student by id
    @GetMapping("/student/{id}")
	public Optional<Student> getStudentById(@PathVariable Integer id) {
		return studentrepo.findById(id);
	}
    
  //Delete student
    @DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable Integer studentId) {
		studentrepo.findById(studentId).map(student -> {
			studentrepo.delete(student);
			return student;
		}).orElseThrow(() -> new ResourceNotFoundException("Student", "student_id", studentId));
	}
    

}
