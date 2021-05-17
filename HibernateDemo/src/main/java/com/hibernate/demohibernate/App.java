package com.hibernate.demohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * this maven project will gives u the brief demo of creating hibernate project by using tables.
 * @author VenkateswariParimi
 *
 */
public class App
{
	public static void main( String[] args )
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Teacher.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        SessionFactory factory= con.buildSessionFactory(reg.build());
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Teacher tch = new Teacher(1, "Psychoo", "ChemistryTecaher","svs","Undrajavaram");
        Teacher tch1 = new Teacher(2, "chintu", "MathsTecaher","vvs","mandapaka");
        Teacher tch2 = new Teacher(3, "swetha", "EnglishTecaher","mps","mandapaka");
        Teacher tch3 = new Teacher(4, "rani", "teluguTecaher","bps","tanuku");
        session.save(tch);
        session.save(tch1);
        session.save(tch2);
        session.save(tch3);
        
        Teacher gettch = (Teacher) session.get(Teacher.class, 1);
        
        tx.commit();
        
        System.out.println(gettch);		
	}
}
