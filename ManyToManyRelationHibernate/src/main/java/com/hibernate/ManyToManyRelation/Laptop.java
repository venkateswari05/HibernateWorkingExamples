package com.hibernate.ManyToManyRelation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "laptop1")
public class Laptop {
	
	@Id
	private int laptop_id;
	private String name;
	private String model_series;
	
	@ManyToMany(mappedBy = "laptop")
	private List<Student> student = new ArrayList<Student>();

	public Laptop() {
		
	}

	public Laptop(int laptop_id, String name, String model_series, List<Student> student) {
		super();
		this.laptop_id = laptop_id;
		this.name = name;
		this.model_series = model_series;
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

	public String getModel_series() {
		return model_series;
	}

	public void setModel_series(String model_series) {
		this.model_series = model_series;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", name=" + name + ", model_series=" + model_series + ", student="
				+ student + "]";
	}
}
