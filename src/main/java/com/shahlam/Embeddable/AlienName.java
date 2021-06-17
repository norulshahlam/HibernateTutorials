package com.shahlam.Embeddable;

import javax.persistence.Embeddable;

/* rather than using @entity which makes a class into a table/entity, using 
 * @Embeddable mean the object of this class will get embedded inside another 
 * table (Alien.class for this case) like object as member of a class		 */
@Embeddable 
public class AlienName {

	private String fname;
	private String mname;
	private String lname;
	
	
	public AlienName(String fname, String mname, String lname) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
	}
	
	public AlienName() {}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "AlienName [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
}