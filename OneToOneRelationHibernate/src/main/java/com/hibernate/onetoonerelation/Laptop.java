package com.hibernate.onetoonerelation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "laptop_info")
public class Laptop {
	
	@Id
	private int latptop_id;
	private String name;
	private String model_series;
	
	@OneToOne(mappedBy = "laptop")
	private Student student;

	public Laptop(int latptop_id, String name, String model_series, Student student) {
		super();
		this.latptop_id = latptop_id;
		this.name = name;
		this.model_series = model_series;
		this.student = student;
	}

	public int getLatptop_id() {
		return latptop_id;
	}

	public void setLatptop_id(int latptop_id) {
		this.latptop_id = latptop_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel_series() {
		return model_series;
	}

	public void setModel_series(String model_series) {
		this.model_series = model_series;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [latptop_id=" + latptop_id + ", name=" + name + ", model_series=" + model_series + ", student="
				+ student + "]";
	}
	
	

}
