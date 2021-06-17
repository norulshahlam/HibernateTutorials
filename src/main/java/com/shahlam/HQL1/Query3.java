package com.shahlam.HQL1;
import java.util.List;

/*
 * hiberntae query using variable
 */
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Query3 {

	public static void main(String[] args) {

	
		int min = 40;
		int max = 50;

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); // for Hibernate
		// Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();

		//1.
		//if your result is one value, use uniqueResult and use Object (or Integer) to store results 
		//Query r =  session.createQuery("select sum(marks) from Student where marks>"+b); //another way of query using variable
		System.out.println("query using sum()");
		Query r =  session.createQuery("select sum(marks) from Student where marks <:min");
		
		/* set variables if u are using variables in query	*/
		r.setParameter("min", min);
		Object marks = r.uniqueResult();
		System.out.println(marks);
		
		// for query that specifies column name, return many results, using '>'
		System.out.println("\n\ncustom column query with many results & greater than");
		Query d = session.createQuery("select rollno, name from Student s where s.marks>:min and s.marks<:max"); // u can add where clause
		d.setParameter("min", min);
		d.setParameter("max", max);
		List<Object[]> e = d.list();
		for(Object[] result:e) 
			System.out.println(result[0]+", "+result[1]);

		session.getTransaction().commit();

	}
}