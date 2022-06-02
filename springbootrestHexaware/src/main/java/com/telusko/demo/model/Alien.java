package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alien {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String lenguage;
	
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
	public String getPoints() {
		return lenguage;
	}
	public void setPoints(String lenguage) {
		this.lenguage = lenguage;
	}
}
