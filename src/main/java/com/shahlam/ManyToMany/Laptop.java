package com.shahlam.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	private int lid;
	private String lname;
	
	//multiple laptop will have multiple student hence student will be of ArrayList
	@ManyToMany
	private List<Student> student = new ArrayList <Student>();
	
	public Laptop() {}
	public Laptop(int lid, String lname) {
		super();
		this.lid = lid;
		this.lname = lname;
	}
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}	
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + ", student=" +  "]";
	}
	
	
	
}
