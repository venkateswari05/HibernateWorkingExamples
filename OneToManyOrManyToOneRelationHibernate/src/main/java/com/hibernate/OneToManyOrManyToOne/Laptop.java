package com.hibernate.OneToManyOrManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "laptop_table")
public class Laptop {
	
	@Id
	private int laptop_id;
	private String name;
	private String modelSeries;
	
	@ManyToOne()
	private Student student;
	
	public Laptop() {
		
	}

	public Laptop(int laptop_id, String name, String modelSeries, Student student) {
		this.laptop_id = laptop_id;
		this.name = name;
		this.modelSeries = modelSeries;
		this.student = student;
	}

	public int getLaptop_id() {
		return laptop_id;
	}

	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelSeries() {
		return modelSeries;
	}

	public void setModelSeries(String modelSeries) {
		this.modelSeries = modelSeries;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", name=" + name + ", modelSeries=" + modelSeries + ", student="
				+ student + "]";
	}
	
	

}
