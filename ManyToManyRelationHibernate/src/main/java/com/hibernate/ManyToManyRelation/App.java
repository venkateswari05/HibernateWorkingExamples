package com.hibernate.ManyToManyRelation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * this project is about Many to many relation.
 * @author VenkateswariParimi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	List<Laptop> laptop = new ArrayList<Laptop>();
    	List<Student> student = new ArrayList<Student>();
    	
    	List<Laptop> laptop1 = new ArrayList<Laptop>();
    	List<Student> student1 = new ArrayList<Student>();
    	
    	List<Laptop> laptop2 = new ArrayList<Laptop>();
    	List<Student> student2 = new ArrayList<Student>();
    	
    	
    	Laptop l1 = new Laptop(201, "Dell", "Insi12", null);
    	Laptop l2 = new Laptop(202, "Asus", "Insi12", null);
    	Laptop l3 = new Laptop(203, "Lenovo", "Insi12", null);
    	Laptop l4 = new Laptop(204, "Acer", "Insi12", null);
    	
    	laptop.add(l1);
    	laptop.add(l2);
    	laptop1.add(l3);
    	laptop1.add(l4);
    	laptop2.add(l1);
    	
    	Student s1 = new Student(1, "chintu", laptop);
    	Student s2 = new Student(2, "swetha", laptop1);
    	Student s3 = new Student(3, "Psychoo", laptop2);
    	
    	student.add(s1);
    	student1.add(s2);
    	student2.add(s3);
    	student2.add(s1);
    	
    	l1.setStudent(student2);
    	l2.setStudent(student);
    	l3.setStudent(student1);
    	l4.setStudent(student1);
    	
    	    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        
        SessionFactory sf = config.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(s1);
        session.save(s2);
        session.save(s3);
        
        session.save(l1);
        session.save(l2);
        session.save(l3);
        session.save(l4);
        
        tx.commit();
    }
}
