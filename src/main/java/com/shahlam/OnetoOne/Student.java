package com.shahlam.OnetoOne;

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	private int marks;
	
	//one student (this class) will have one laptop object
	@OneToOne //specify here if you are creating object of laptop in student table so compiler can specify the relationship/type btwn laptop & student
	private Laptop laptop;
	
	public Student() {}
	public Student(String name, int rollno, int marks, Laptop laptop) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.laptop = laptop;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + ", laptop=" + laptop + "]";
	}
	
	
}
