package com.shahlam.Caching;
/*shows how 2nd level caching is done. unlike 1st level is done by default, 2nd level requires some settings 
 * 2nd level cache means it wont use 2nd query from different session if the query is the same
1. dl dependencies thru pom.xml - net.sf.cache - latest version will do
2. dl dependencies thru pom.xml hibernate-ehcach
in hibernate config file, add:
<property name="hibernate.cache.use_second_level_cache">true</property>
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>

make sure version of hibernate core and hibernate ehcache is same in pom.xml

specify which class u 1 2 have the 2nd level caching using annotations
specify which strategy used in that class ie read-only, read-write, etc

*/
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FetchingLvl2 {

	public static void main(String[] args) {

		Alien obj1 = null;
		Configuration con = new Configuration().configure("setting1.xml").addAnnotatedClass(Alien.class); // for Hibernate Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		session1.beginTransaction();

		obj1 = (Alien) session1.get(Alien.class, 101); // fetch data by using class name and id as query value
		System.out.println(obj1); //print the query results
		session1.getTransaction().commit();
		session1.close();
		
		/*
		below query is the same as above using the diff session (session2). 
		now hibernate doesnt need to do another query but intstead take from the cache
		 */
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		obj1 = (Alien) session2.get(Alien.class, 101); // fetch data by using class name and id as query value
		System.out.println(obj1); //print the query results
		session2.getTransaction().commit();
		session2.close();
	}
}
/*
Caching is a mechanism to enhance the performance of a system. 
It is a buffer memorythat lies between the application and the database. 
Cache memory stores recently used data items in order to 
reduce the number of database hits as much as possible.
Caching is important to Hibernate as well. It utilizes a multilevel caching scheme 
*/