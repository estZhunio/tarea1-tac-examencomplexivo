package edu.ex.tap.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ex.tap.model.entity.Course;
import edu.ex.tap.model.entity.Student;
import edu.ex.tap.model.repository.CourseRepository;
import edu.ex.tap.model.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private  StudentRepository repository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/all")
	public List<Student> all() {
		return repository.findAll();
	}
	
	@PostMapping("/create")
	public Student newStudent(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@PutMapping("/{id}")
	public Student replaceStudent(@PathVariable Long id, @RequestBody Student student) {
		return repository.findById(id)
		.map(s -> {
			s.setName_stu(student.getName_stu());
			s.setLastaname_stu(student.getLastaname_stu());
			s.setBirthdate(student.getBirthdate());
			s.setName_stu(student.getName_stu());
			return repository.save(s);
		})
		.orElseGet(() -> {
			return repository.save(student);
		});
	}
	
	@GetMapping("/search/{id}")
	 public Student searchStudent(@PathVariable Long id) {
	    
	    return repository.findById(id).orElse(null);
	 }
	
	@PutMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<Student> enrollStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = repository.findById(studentId)
                .orElseThrow(() -> null);

        // Buscar el curso
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> null);

        // Agregar el curso al estudiante
        student.getCourses().add(course);

        // Guardar cambios en la base de datos
        repository.save(student);

        return ResponseEntity.ok(student);
    }
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
	    repository.deleteById(id);
	}	
}

