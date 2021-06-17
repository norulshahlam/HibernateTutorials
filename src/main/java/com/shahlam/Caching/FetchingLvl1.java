package com.shahlam.Caching;
/*
 * user uses query to get results from db
 * but if user uses same query for then 2nd time, in the same session,
 * hibernate wont go to db instead will fetch from the 1st level cache.
 * Caching is provided by hibernate, 1st level cache is by default available.
 * 
 * for 2nd level cache, diff session can access within the same application but
 * user have to use 3rd party lib (ehcache), configure it
 * 
 * this class shows that if subsequent query is the same as the previous ones
 * within the same session, hibernate wont execute query. instead it gets the
 * resutls from 1st level cache. this can be proven by looking at the console
 */

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FetchingLvl1 {

	public static void main(String[] args) {

		Alien obj1 = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		Transaction tx = session1.beginTransaction();

		obj1 = (Alien) session1.get(Alien.class, 101); // fetch data by using class name and id as query value
		System.out.println(obj1); //print the query results
		
		/*
		below query is the same as above using the same session (session1). so hibernate 
		doesnt need to do another query but intstead take from the cache
		 */
		obj1 = (Alien) session1.get(Alien.class, 101); // fetch data by using class name and id as query value
		System.out.println(obj1); //print the query results
		
		
		tx.commit();
	}

}
/*
Caching is a mechanism to enhance the performance of a system. 
It is a buffer memorythat lies between the application and the database. 
Cache memory stores recently used data items in order to 
reduce the number of database hits as much as possible.
Caching is important to Hibernate as well. It utilizes a multilevel caching scheme 
*/