package com.shahlam.HQL1;
/* instead of using HQL, we can also using sql (native query) in hibernate		*/
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Sql1 {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); // for Hibernate
		// Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		//1.
		System.out.println("\nSelect * from Student where rollno>10 and rollno<15");
		SQLQuery query = session.createSQLQuery("select * from Student where rollno>10 and rollno<15");
		query.addEntity(Student.class); //we are specifying what is the type of results
		List<Student> students = query.list();
		for(Student s : students)
			System.out.println(s);
		
		//2.
		System.out.println("\nselect name, marks from Student where rollno>10 and rollno<15");
		SQLQuery q = session.createSQLQuery("select name, marks from Student where rollno>10 and rollno<15");
		
		/* Set a strategy for handling the query results. This can be used to change
		 "shape" of the query result. */
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); //convert entity to map
		List s = q.list();
		for(Object o : s) {
			Map m = (Map) o;
			System.out.println(m.get("name")+ ", "+m.get("marks"));
		}
		session.getTransaction().commit();
	}
}