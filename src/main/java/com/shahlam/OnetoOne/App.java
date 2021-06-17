package com.shahlam.OnetoOne;

/* here student and laptop table has linked by One-to-One relationship
 * one student will only have one laptop. the mapping will be done in student table (or class), 
 * where there additional column is added in student table having laptop id
 * this means student class knows about the relationship with the laptop	*/

import org.hibernate.Session;   
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App {

	public static void main(String[] args) {
		// add two classes here as there is two db tables in use
		Configuration con = new Configuration().configure("setting1.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		//create and add data using constructor
		Laptop laptop = new Laptop(101,"Dell");
		Student s = new Student("shah",20,99,laptop);
		 //'laptop' is the additional column (of laptop PK) to be added in student table

	
		session.save(laptop);
		session.save(s);
		
		session.getTransaction().commit();
		System.out.println(s); // see the values inserted
		System.out.println(laptop); // see the values inserted
	}

}
