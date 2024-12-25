package edu.ex.tap.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	private @Id
	@GeneratedValue Long id_cou;

	@Column(length = 50)
	private String name_cou;
	
	@Column(length = 50)
	private String schedule_cou;
	
	@Column(length = 100)
	private String cicle_cou;
	
	@Column(length = 100)
	private String career_cou;
	
	public Long getId_cou() {
		return id_cou;
	}

	public void setId_cou(Long id_cou) {
		this.id_cou = id_cou;
	}

	public String getName_cou() {
		return name_cou;
	}

	public void setName_cou(String name_cou) {
		this.name_cou = name_cou;
	}

	public String getSchedule_cou() {
		return schedule_cou;
	}

	public void setSchedule_cou(String schedule_cou) {
		this.schedule_cou = schedule_cou;
	}

	public String getCicle_cou() {
		return cicle_cou;
	}

	public void setCicle_cou(String cicle_cou) {
		this.cicle_cou = cicle_cou;
	}

	public String getCareer_cou() {
		return career_cou;
	}

	public void setCareer_cou(String career_cou) {
		this.career_cou = career_cou;
	}
	
}
