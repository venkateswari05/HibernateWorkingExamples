package com.hibernate.GetAndLoad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptop_info")
public class Laptop {
	
	@Id
	private int laptop_id;
	private String brand;
	private int price;
	
	public Laptop() {
		
	}
	
	public Laptop(int laptop_id, String brand, int price) {
		super();
		this.laptop_id = laptop_id;
		this.brand = brand;
		this.price = price;
	}
	
	public int getLaptop_id() {
		return laptop_id;
	}
	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", brand=" + brand + ", price=" + price + "]";
	}
}
