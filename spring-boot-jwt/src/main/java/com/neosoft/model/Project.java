package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;


@Data
@Entity
@Table(name="project")
public class Project {
	
	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotNull
	private String projectName;
	
	@NotNull
	@Column(name = "duration")
	private String projectDuration;
	
	@ManyToOne
	@JoinColumn(name = "student_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Student student;
	

}
