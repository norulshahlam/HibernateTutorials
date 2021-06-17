package com.shahlam.ManyToMany;

/* here shows how define many-to-many where many student has many laptop     
 * and define many-to-many where many laptop will have many student
 * laptop must be defined as ArrayList as there are many laptops
 * student must be defined as ArrayList as there are many student
 * additional table is created for mapping as we cant 
 * have duplicate student id in student table that has >1 laptop
 * also in student class dont need to do the mapping as only one of them needs to do it
 * ie laptop table. so student table will have 'mappedBy' annotation indicating
 * that student class will not do the mapping		 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		// add two classes here as there is two db tables in use
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		
		
		Laptop laptop = new Laptop(102,"Dell");
		Student s = new Student("shah",21,90);
		s.getLaptop().add(laptop); // take PK of student table and insert into laptop table(NOTE: this is skipped bcos of @GetMapped)
		laptop.getStudent().add(s); //insert PK of student into laptop table to indicate the relationship btwn these 2 tables
	
		
		
		session.save(laptop);
		session.save(s);
		session.getTransaction().commit();
		System.out.println(s); // see the values inserted
		System.out.println(laptop); // see the values inserted
	}
}