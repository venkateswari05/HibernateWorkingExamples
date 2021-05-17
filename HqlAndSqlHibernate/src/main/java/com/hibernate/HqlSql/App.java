package com.hibernate.HqlSql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * this project is about hibernate query language.
 * @author VenkateswariParimi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Mentor.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        SessionFactory factory = config.buildSessionFactory(reg.build());
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Mentor> ment = new ArrayList<Mentor>();
        Mentor m2 = new Mentor(1,"Rajendra", 50);
        Mentor m4 = new Mentor(2,"Chintu", 60);
        Mentor m3 = new Mentor(3,"swetha", 100);
        ment.add(m2);
        ment.add(m3);
        ment.add(m4);
        
        session.save(m2);
        session.save(m3);
        session.save(m4);
        Query<Mentor> q1 = session.createQuery("from Mentor", Mentor.class);
        
        List<Mentor> men =  q1.list();
        
        for(Mentor mentor : men) {
        	System.out.println(mentor);
        }
        
        Query<Mentor> q2 = session.createQuery("from Mentor m where m.score > 50", Mentor.class);
        
        List<Mentor> men1 =  q2.list();
        
        for(Mentor mentor : men1) {
        	System.out.println(mentor);
        }
        
        Query<Object[]> q3 = session.createQuery("select id, name, score from Mentor m where m.score > 90", Object[].class);
        
        List<Object[]> men2 = q3.list();
        
        for(Object[] m: men2) {
        	System.out.println(m[0] + " : " + m[1] + " ; " + m[2]);
        }
        
        Query<Mentor> q4 = session.createQuery("from Mentor m where m.id = :mentor_id", Mentor.class);
        q4.setParameter("mentor_id", 1);
        Mentor m1 = q4.uniqueResult();
        System.out.println(m1);
        
        Query<Long> q5 = session.createQuery("select sum(score) from Mentor", Long.class);
        Long sumOfScores = q5.uniqueResult();
        System.out.println(sumOfScores);
        
        
        NativeQuery<Mentor> query = session.createNativeQuery("select * from mentor_info", Mentor.class);
        List<Mentor> qmen = query.list();
        
        for(Mentor m : qmen) {
        	System.out.println(m);
        }
        
        @SuppressWarnings("unchecked")
		NativeQuery<Object[]> query1 = session.createNativeQuery("select id, name, score from mentor_info m where m.score > ?");
        query1.setParameter(1, 50);
        List<Object[]> qmen1 = (List<Object[]>) query1.list();
        
        for(Object[] o: qmen1) {
        	System.out.println(o[0] + " : " + o[1] + " : " + o[2]);
        }
        
        @SuppressWarnings("unchecked")
		NativeQuery<BigDecimal> query2 = session.createNativeQuery("select sum(score) from mentor_info");
        BigDecimal sum =  query2.uniqueResult();
        System.out.println(sum);
        
       
        tx.commit();
        session.close();
    }
}

