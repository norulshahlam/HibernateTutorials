package com.shahlam.Lazy2;

/*
 * How to fetch data using the lazy method 
 * To do this, go to the class where want to enquire, (Alien.class for this) and indicate EAGER. by default it will be LAZY.
 * Here Alien has multiple Laptops but when a query for Alien is fired, hibernate only queries for alien class. this is lazy
 * in contrast, EAGER does the opp.if u want the Laptop in ALien to get queried, in Alien.java, 
 * under @OneToMany, add value FetchType.
 */

import java.util.Collection;

import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FetchData {

	public static void main(String[] args) {

		// add two classes here as there is two db tables in use
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();

		//fetching Alien table of id=1
		Alien a1 = (Alien) session.get(Alien.class, 1);
		System.out.println(a1.getName());
		
		/*this is to show that hibernate will query alien and laptop if user specify both. else, 
		 * it will only do alien by default as shown from above query		*/
//		Collection<Laptop> laps = a1.getLaps();
//		for (Laptop l : laps)
//			System.out.println(l);

		session.getTransaction().commit();
	}
}
