package com.neosoft.springboot.security;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="security")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	private boolean active;
	private String roles;

}
