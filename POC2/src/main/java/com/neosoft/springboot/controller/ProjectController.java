package com.neosoft.springboot.controller;

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
import com.neosoft.springboot.model.Project;
import com.neosoft.springboot.myexception.ResourceNotFoundException;
import com.neosoft.springboot.repository.ProjectRepository;
import com.neosoft.springboot.repository.StudentRepository;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectrepo;
	
	@Autowired
	private StudentRepository studentrepo;
	
	
	

	 //Add project
    @PostMapping("/student/{studentId}/project")
	public Project createProject(@PathVariable Integer studentId, @Valid @RequestBody Project project){
		return studentrepo.findById(studentId).map(student -> {
			project.setStudent(student);
			return projectrepo.save(project);
		}).orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId));
	}

    //Get Project
  	@GetMapping("getProject")
  	public List<Project> getAllProject(){
  		return projectrepo.findAll();
  		
  	}
  	
    //Get project by id
    @GetMapping("/project/{id}")
	public Optional<Project> getProjectById(@PathVariable Integer id) {
		return projectrepo.findById(id);
	}
    
    //Delete project
    @DeleteMapping("/project/{id}")
	public void deleteStudent(@PathVariable Integer id) {
    	projectrepo.findById(id).map(project -> {
    		projectrepo.delete(project);
			return project;
		}).orElseThrow(() -> new ResourceNotFoundException("Project", "project_id", id));
	}
}
