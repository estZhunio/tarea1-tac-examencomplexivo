package edu.ex.tap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ex.tap.model.entity.Course;
import edu.ex.tap.model.repository.CourseRepository;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	
	@Autowired
	private CourseRepository repository;
	
	
	@GetMapping("/all")
	public List<Course> all() {
		return repository.findAll();
	}
	
	@PostMapping("/create")
	public Course newCourse(@RequestBody Course course) {
		return repository.save(course);
	}
	
	@PutMapping("/{id}")
	public Course replaceCourse(@PathVariable Long id, @RequestBody Course course) {
		return repository.findById(id)
		.map(c -> {
			c.setName_cou(course.getName_cou());
			c.setSchedule_cou(course.getSchedule_cou());
			c.setCicle_cou(course.getCicle_cou());
			c.setCareer_cou(course.getCareer_cou());
			return repository.save(c);
		})
		.orElseGet(() -> {
			return repository.save(course);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
		
	
}
