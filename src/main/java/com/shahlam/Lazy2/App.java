package com.shahlam.Lazy2;

/*
Eager Loading is a design pattern in which data initialization occurs on the spot  
Lazy Loading is a design pattern which is used to defer initialization of an object as long as it's possible

Lazy Loading
Advantages:
Initial load time much smaller than in the other approach
Less memory consumption than in the other approach

Disadvantages:
Delayed initialization might impact performance during unwanted moments
In some cases you need to handle lazily-initialized objects with a special care or you might end up with an exception

Eager Loading:
Advantages:
No delayed initialization related performance impacts

Disadvantages:
Long initial loading time
Loading too much unnecessary data might impact performance

here is only the initialisation of tables (if no table is created). then add additional data in query given,
then change to 'update' from 'create' in hib config. then go to FetchData.java for demo.

 */

import org.hibernate.Session;    
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		// add two classes here as there is two db tables in use
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		Laptop l = new Laptop(101,"Dell",1000);
		Alien a = new Alien(1,"Shah");
		a.getLaps().add(l); //take PK of Laptop into Alien
		l.setAlien(a); //insert PK of Alien into Laptop. 
		session.save(l);
		session.save(a);
		
		session.getTransaction().commit();
		System.out.println(a); // see the values inserted
		System.out.println(l);
	}
}
/*
SQL code to insert the remaining data. make sure u drop schema 
so all tables will be deleted. run the app once so hibernate will
create tables for you and from mysql, add more data below. after running the inserted obj once,
change to update in hib config. this is for initiating tables. for fetching is at FetchData.class

insert into alien values (2, "Rahul");
insert into alien values (3, "Mayank");
insert into laptop values (102,"Apple",2000,3);
insert into laptop values (103,"Asus",800,1);
insert into laptop values (104,"Acer",1500,3);
insert into laptop values (105,"Samsung",1400,1);
select * from laptop;
select * from alien;

https://stackoverflow.com/questions/46646253/eclipse-java-how-do-i-include-jersey-archetype-in-maven/46646551

 */
