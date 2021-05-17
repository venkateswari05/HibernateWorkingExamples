package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/** 
 * This project gives you the brief demo on caching techniques.
 * @author VenkateswariParimi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Teacher.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        
        SessionFactory sf = config.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        
        Teacher teacher = (Teacher) session.get(Teacher.class, 1);
        System.out.println(teacher);
        session.close();
        
        Session session2 = sf.openSession();
        
        Teacher teacher2 = (Teacher) session2.get(Teacher.class, 1);
        System.out.println(teacher2);
        session2.close();
        
    }
}
