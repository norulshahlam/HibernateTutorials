package com.shahlam.CachingWquery;

import javax.persistence.Cacheable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity //make this class into a table
@Table(name="Alien_Table") //define table name. else default table name will be class name
@Cacheable //this will allow this class to get cached
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) //once u allow caching, specify the strategy
public class Alien {
	
	@Id	//every table in hibernate must have primary key
	private int id;
	
	//@Transient //if you 1 2 exclude a column when creating a new table
	private String name;
	
	@Column(name="Alien_Color") //u can specify column name by using @Column
	private String color;
	
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
