package com.hibernate.OneToManyOrManyToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * This project gives you the brief demo on one to one relation.
 * @author VenkateswariParimi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	List<Laptop> list1 = new ArrayList<Laptop>();
    	Laptop l1 = new Laptop(201, "Asus", "12wsd", new Student());
    	Laptop l2 = new Laptop(202, "Dell", "ins123", new Student());
    	Student student = new Student(1, "Rajendra", list1);
    	l1.setStudent(student);
    	l2.setStudent(student);
    	list1.add(l1);
    	list1.add(l2);
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        
        SessionFactory sf = config.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(student);
        session.save(l1);
        session.save(l2);
        
        tx.commit();
    }
}
