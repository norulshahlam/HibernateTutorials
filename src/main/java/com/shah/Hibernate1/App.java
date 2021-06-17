package com.shah.Hibernate1;

/*
 * How to insert dependencies, create entity, sessionFactory, session, add data into db
 * in configure(), u must insert hibernate config file name except if file name is default name: hibernate.cfg.xml
 * we show how to add and fetch data from db
 */
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
    	//hib setting and config
    	 Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class); //for Hibernate Configuration file.
         ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
         SessionFactory sf = con.buildSessionFactory(reg);
         Session session = sf.openSession();
         Transaction tx = session.beginTransaction();
       
         
         //for fectching data
         Alien obj2 = null;
         obj2 = (Alien) session.get(Alien.class, 107);
         
    	//for add obj
    	 Alien obj1 = new Alien(110,"dad","green"); //create and add values by using constructors
         session.save(obj1);
         
         //commit after doing query
         tx.commit();          
         
         System.out.println("fetched: "+obj2); //see the values inserted
         System.out.println("added: "+obj1); //see the values inserted
    }
}
