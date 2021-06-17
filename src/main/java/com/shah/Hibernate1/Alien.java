package com.shah.Hibernate1;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // must indicate @Entity when using Hibernate
@Table(name = "Alien_Table") // define table name. else default table name will be class name
public class Alien {

	@Id // must have primary key when using Hibernate
	private int id;

	// @Transient //if you 1 2 exclude a column when creating a new table
	private String name;

	@Column(name = "Alien_Color") // u can specify column name by using @Column
	private String color;

	public Alien() {
	}

	public Alien(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", color=" + color + "]";
	}

}
