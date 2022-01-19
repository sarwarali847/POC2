package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.springboot.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
