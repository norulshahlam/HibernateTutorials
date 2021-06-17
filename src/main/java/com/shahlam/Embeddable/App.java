package com.shahlam.Embeddable;

//how to store data of a variable having an object as one of its member class
//embeddable means the object of this class  will get embedded inside another table (Alien.class for this case)

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	  
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class); //for Hibernate Configuration file
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
    	//for embeddable ojb
    	AlienName an = new AlienName("nor","shah","lam");
       	
    	//for entity
        Alien obj1 = new Alien(104,an,"red");
    
        session.save(obj1);
        tx.commit();

        System.out.println(obj1); //see the values inserted
    }
}
