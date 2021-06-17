package com.shahlam.Caching;

//this class only stores data. go to other class for further demo

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
        
        Alien obj1 = new Alien(101,"shah","green");   
        session.save(obj1);
        tx.commit(); 
        System.out.println(obj1); //see the values inserted
    }
}
/*
insert the remaining values before starting the lesson

create table alien_table (id integer not null, Alien_Color varchar(255), name varchar(255), primary key (id));
insert into alien_table values (101,"shah","green");
insert into alien_table values (102, "red","Rahul");
insert into alien_table values (103,  "blue","Mayank");
select * from alien_table;

 */
