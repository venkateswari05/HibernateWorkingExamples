package com.hibernate.ManyToManyRelation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student1")
public class Student {
	
	@Id
	private int roll_no;
	private String name;
	
	@ManyToMany
	private List<Laptop> laptop = new ArrayList<Laptop>();

	public Student() {
		
	}

	public Student(int roll_no, String name, List<Laptop> laptop) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.laptop = laptop;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", laptop=" + laptop + "]";
	}
	
	

}
