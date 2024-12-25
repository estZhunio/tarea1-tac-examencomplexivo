package edu.ex.tap.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ex.tap.model.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{

}
