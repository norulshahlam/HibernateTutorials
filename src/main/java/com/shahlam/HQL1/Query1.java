package com.shahlam.HQL1;
/*
 * using HQL
 * if your query begins with 'select *' or returning all rows
 * result will return List of Student type (for multiple result), Object of Student type for single result
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Query1 {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); // for Hibernate
		// Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		//for select * with many rows returned use List to store results and use createQuery();
		//as the results will return as List type
		Query q =  session.createQuery("from Student"); //u can add where clause
		List<Student> s = q.list();
		for(Student st : s)
			System.out.println(st);
		
		//for specific(one) result, use Object to store results cos for 1 value, it will return result as object type NOT List
		//also use uniqueResult();
		Query r =  session.createQuery("from Student where id=3"); 
		Student ss = (Student) r.uniqueResult(); //uniqueResult() - return the single result
		System.out.println(ss);
		
		session.getTransaction().commit();
	}

}
