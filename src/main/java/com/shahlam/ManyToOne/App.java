package com.shahlam.ManyToOne;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * here shows how to make one-to-many where 1 student has many laptop.    
 * and define many-to-one where many laptop will have one student
 * laptop must be defined as ArrayList as there are many laptops
 * there wont be additional table created for mapping as we can 
 * have duplicate laptop id in student table for student that has >1 laptop
 * since there are 2 annotations, (@OneToMany in student, @ManyToOne in laptop), 
 * there will be 2 mappings made. this will cause redundancies. just 1 mapping will do
 * ie laptop table. so in student class will have 'mappedBy' annotation indicating
 * student class not to do the mapping		*/

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
		laptop.setStudent(s); //take PK of laptop and insert into student table

		session.save(laptop);
		session.save(s);
		session.getTransaction().commit();
		System.out.println(s); // see the values inserted
		System.out.println(laptop); // see the values inserted
	}
}