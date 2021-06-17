package com.shahlam.ManyToMany;

import java.util.ArrayList; 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	private int marks;
	
	/* multiple student (on student class) will have multiple laptop hence laptop must of List<Laptop> type
	 * Persistence(ManytoMany): means Student class will know the link (ManytoMany) with laptop and it will do the mapping accordingly.
	 * mappedBy: if you dont want this class to do the mapping, use this keyword
	 */
	 @ManyToMany(mappedBy="student") 
	private List<Laptop> laptop = new ArrayList<Laptop>();
	 
	public Student() {}	
	public Student(String name, int rollno, int marks) {
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
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
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + ", laptop=" + laptop + "]";
	}
}