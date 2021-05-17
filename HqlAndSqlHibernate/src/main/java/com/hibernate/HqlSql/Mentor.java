package com.hibernate.HqlSql;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "mentor_info")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class Mentor {

	@Id
	private int id;
	private String name;
	private int score;
	
	public Mentor() {
		
	}

	public Mentor(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
	
}
