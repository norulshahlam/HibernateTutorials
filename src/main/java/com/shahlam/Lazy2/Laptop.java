package com.shahlam.Lazy2;

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	private int lid;
	private String brand;
	private int price;
	@ManyToOne //multiple laptop will belong to one student
	private Alien alien;
	
	public Laptop() {}
	public Laptop(int lid, String brand, int price) {
		this.lid = lid;
		this.brand = brand;
		this.price = price;
	}
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
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
	public Alien getAlien() {
		return alien;
	}
	public void setAlien(Alien alien) {
		this.alien = alien;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + ", price=" + price +"]";
	}
		
}
