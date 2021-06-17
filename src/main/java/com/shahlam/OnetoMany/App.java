	package com.shahlam.OnetoMany;

/*
 * here shows how to make one-to-many where 1 student has many laptop.   
 * laptop must be defined as ArrayList as there are many laptop objects
 * unlike one-to-one where mapping is done in student table, 
 * here the mapping will be done on an additional table bcos we cant have 
 * duplicate student id in student table when a student has >1 laptop
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		// add two classes here as there is two db tables in use
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class); // for Hibernate Configuration													// file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		Laptop laptop = new Laptop(1088,"Dell");
		Student s = new Student("shah",12,99);
		s.getLaptop().add(laptop);  // take PK of student table and insert into laptop table
	
		session.save(laptop);
		session.save(s);
		session.getTransaction().commit();
		System.out.println(s); // see the values inserted
		System.out.println(laptop); // see the values inserted
	}
}
/*
 * here shows how to make one-to-many where 1 student has many laptop.  
 * and define many-to-one where many laptop will have one student
 * laptop must be defined as ArrayList as there are many laptops
 * there wont be additional table created for mapping as we can  have duplicate student id in student table that has >1 laptop
 */
