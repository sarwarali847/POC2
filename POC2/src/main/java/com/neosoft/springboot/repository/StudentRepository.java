package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


	

}
