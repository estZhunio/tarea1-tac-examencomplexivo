package edu.ex.tap.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ex.tap.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
