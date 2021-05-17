package com.hibernate.onetoonerelation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * This project gives you the brief demo on one to one relationship.
 * @author VenkateswariParimi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Laptop laptop = new Laptop(212, "Dell", "12Eh", new Student());
    	Student student = new Student(1, "Rajendra", laptop);
    	laptop.setStudent(student);
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        
        SessionFactory sf = config.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(student);
        session.save(laptop);
        
        tx.commit();    
        
    }
}

