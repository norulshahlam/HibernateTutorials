package com.shahlam.CachingWquery;
/*
 * we use HQL and see if any 2nd level cache is used.
 */
import org.hibernate.Query;

//how to store data

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )    {
    	Configuration con = new Configuration().configure("setting1.xml").addAnnotatedClass(Alien.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		
		//create session1
		Session session1 = sf.openSession();
		session1.beginTransaction();
		Alien obj1 = null;
		Query q1 = session1.createQuery("from Alien where id=101"); // fetch data by using query instead of get method
		q1.setCacheable(true); //use 2nd level cache
		obj1=(Alien) q1.uniqueResult(); //uniqueResult() - return the single result
		System.out.println(obj1); //print the query results
		session1.getTransaction().commit();
		session1.close();
		
		/*
		below query is the same as above using the diff session (session2). 
		now hibernate doesnt need to do another query but instead take from the cache
		 */
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query q2 = session2.createQuery("from Alien where id=101"); // fetch data by using query instead of get method
		q2.setCacheable(true); //use 2nd level cache
		obj1=(Alien) q2.uniqueResult(); //uniqueResult() - return the single result
		System.out.println(obj1); //print the query results
		session2.getTransaction().commit();
		session2.close();
	}
}
/*
Caching is a mechanism to enhance the performance of a system. 
It is a buffer memory that lies between the application and the database. 
Cache memory stores recently used data items in order to 
reduce the number of database hits as much as possible.
Caching is important to Hibernate as well. It utilizes a multilevel caching scheme 

Mysql query. incase all data is lost

create database Hibernate;
use Hibernate;
create table alien_table (id integer not null, Alien_Color varchar(255), name varchar(255), primary key (id));
insert into alien_table values (101,"shah","green");
insert into alien_table values (102, "red","Rahul");
insert into alien_table values (103,  "blue","Mayank");
select * from alien_table;
*/