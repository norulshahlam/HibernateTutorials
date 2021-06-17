package com.shahlam.HQL1;
/*
 * insert data of 50 rows
 */
import java.util.Random;

/*
we are learning how to use HQL (Hibernate Query language)
1st we will randomly add 50 value in the table using random() and for loop
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); // for Hibernate
		// Configuration file
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		//insert 50 random values in student table
		Random r = new Random();
		for(int i=0; i<50; i++) {
			Student s = new Student();
			s.setRollno(i);
			s.setName("name"+i);
			s.setMarks(r.nextInt(100)); //random value not more than 100
			session.save(s);
		}
		
		session.getTransaction().commit();

	}

}
