package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
@Builder
public class Student {
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(max = 65)
	@NotNull
	private String firstName;
	
	@Size(max = 65)
	@NotNull
	private String lastName;
	
	
	@NotNull
	@Column(unique = true)
	private String mobile;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	
	
}
