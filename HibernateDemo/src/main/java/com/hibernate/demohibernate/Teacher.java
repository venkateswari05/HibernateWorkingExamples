package com.hibernate.demohibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Teacher_details")
public class Teacher
{
	@Id
	private int id;
	private String Name;
	private String role;
	@Column(name = "School_Name")
	private String Sname;
	
	@Transient
	private String Address;

	public Teacher() {
	
	}

	public Teacher(int id, String name, String role, String sname, String address)
	{
		this.id = id;
		Name = name;
		this.role = role;
		Sname = sname;
		Address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", Name=" + Name + ", role=" + role + ", Sname=" + Sname + ", Address=" + Address
				+ "]";
	}
	
}
