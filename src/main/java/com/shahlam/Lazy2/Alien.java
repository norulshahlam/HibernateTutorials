package com.shahlam.Lazy2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alien {

	@Id
	private int id;
	private String name;
	
	/* one Alien (this class) will have multiple laptop hence laptop must of List<Laptop> type
	 * Persistence(OnetoMany): means Alien class will know the link (OneToMany) with laptop and it will do the mapping accordingly.
	 * mappedBy: if you dont want this class to do the mapping, use this keyword
	 */
	
	@OneToMany(mappedBy="alien",fetch=FetchType.EAGER) 	//or LAZY
	private Collection <Laptop> laps = new ArrayList<Laptop>(); //specify here if you are creating object of laptop in student table so compiler can specify the relationship/type btwn laptop & student

	public Alien() {}
	public Alien(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Collection<Laptop> getLaps() {
		return laps;
	}

	public void setLaps(Collection<Laptop> laps) {
		this.laps = laps;
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", laps=" + laps + "]";
	}

	
	
	

}
