package com.shahlam.NoRelationship;

/* two tables are created without any relationship. this is an intro to relationships */

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		Laptop laptop = new Laptop(103,"Dell");
		Student s = new Student("shah",22,99);
		
		session.save(laptop);
		session.save(s);
		session.getTransaction().commit();
		System.out.println(s); // see the values inserted
	}
}