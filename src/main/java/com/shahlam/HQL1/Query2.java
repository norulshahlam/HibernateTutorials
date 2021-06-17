package com.shahlam.HQL1;

/* for query that specifies column name & return single result, 
 * use uniqueResult(); for single result,
 * will return Object[] containing results. if query select 5 rows,
 * then Object[] size is 5. each elements represents columns		
 * 
 * for query has custom column with multiple results;
 * use createQuery() for multiple results,
 * results will be in List<Object[]> type
 * use for loop to print data as shown below 	
 * also how to limit query results
 * 
 * query for 'greater than'	
 * "select rollno, name from Student s where s.marks>50"
 * alias 's' is used to avoid confusion as other tables may have same column name
 * and this might result in join query
 * 
 * query for total marks
 * 
 * 	*/

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.List;
public class Query2 {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); // for Hibernate
		// Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();

		System.out.println("\ncustom column query with single results:");
		Query r = session.createQuery("select rollno, name from Student where id=47"); // u can add where clause
		Object[] s = (Object[]) r.uniqueResult();

		// 1st way to print result
		for (Object st : s)
			System.out.println("1st way: " + st);

		// 2nd way to print result
		System.out.println("2nd way: " + s[0] + ", " + s[1]);

		
		// for query that specifies column name instead of * it will return List<Object[]>
		System.out.println("\n\ncustom column query with many results:");
		Query t = session.createQuery("select rollno, name from Student"); // u can add where clause
		t.setFirstResult(0); //limit results
		t.setMaxResults(5);
		List<Object[]> l = t.list();
		for(Object[] result:l) 
			System.out.println(result[0]+", "+result[1]);
	
		
		// for query that specifies column name, returnd many results, using '>'
		System.out.println("\n\ncustom column query with many results & greater than");
		Query d = session.createQuery("select rollno, name from Student s where s.marks>50"); // u can add where clause
		d.setFirstResult(0);  //limit results
		d.setMaxResults(5);
		List<Object[]> e = d.list();
		for(Object[] result:e) 
			System.out.println(result[0]+", "+result[1]);
			
		System.out.println("\n\nget total marks");
		Query q = session.createQuery("select sum(marks) from Student s where s.marks>50"); // u can add where clause
		Object p = (Object) q.uniqueResult();
		System.out.println("total marks: "+p);
		
		
		session.getTransaction().commit();
	}
}