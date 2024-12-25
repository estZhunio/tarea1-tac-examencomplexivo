package edu.ex.tap.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
	
	private @Id
	@GeneratedValue Long id_stu;
	
	@Column(unique = true)
	private String cardnumber_stu;

	@Column(length = 50)
	private String name_stu;
	
	@Column(length = 50)
	private String lastaname_stu;
	
	// @Temporal -> Nos permite mapear las fechas con la base de datos de una forma simple.
	// temporalType.DATE -> Acotara el campo solo a la Fecha, descartando la hora. 
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@ManyToMany
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private List<Course> courses;
	
	@Column(length = 40)
	private String email_stu;

	public Long getId_stu() {
		return id_stu;
	}

	public void setId_stu(Long id_stu) {
		this.id_stu = id_stu;
	}

	public String getCardnumber_stu() {
		return cardnumber_stu;
	}

	public void setCardnumber_stu(String cardnumber_stu) {
		this.cardnumber_stu = cardnumber_stu;
	}

	public String getName_stu() {
		return name_stu;
	}

	public void setName_stu(String name_stu) {
		this.name_stu = name_stu;
	}

	public String getLastaname_stu() {
		return lastaname_stu;
	}

	public void setLastaname_stu(String lastaname_stu) {
		this.lastaname_stu = lastaname_stu;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail_stu() {
		return email_stu;
	}

	public void setEmail_stu(String email_stu) {
		this.email_stu = email_stu;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

}
