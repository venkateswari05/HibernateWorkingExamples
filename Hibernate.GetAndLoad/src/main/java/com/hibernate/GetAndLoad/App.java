package com.hibernate.GetAndLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	//Here the laptop object in the transient state after closing the application will lost the object details.
    	Laptop laptop = new Laptop(1, "Dell", 700);
    	
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        SessionFactory factory = config.buildSessionFactory(reg.build());
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        //In the following line the object state we are moved to the Persistance state.
        session.save(laptop);
        
        //This object change will automatically updates the database no need to again save the object
        //Because it is in persistance state.
        laptop.setBrand("Lenovo");
        
        tx.commit();
        
        //Here only object data was changed. The database details will not change.
        //Here the object was moved to persistance state.
        laptop.setBrand("Acer");
        
        session.close();
        
        session = factory.openSession();
        
        tx = session.beginTransaction();
        
        //In get method when we executed it will hit the query to the DB and returns the object.
        Laptop laptop1 = (Laptop) session.get(Laptop.class, 1);
        //Here laptop already in persistenace state because it was not created it was fetched from db.
        
        System.out.println(laptop1);
        
        
        Laptop laptop2 = (Laptop) session.load(Laptop.class, 1);
        //Here the the load will create the proxy object of the Laptop but it will not execute query until we user the object.
        
        //Here we are using laptop2 object at execution of the this line the load method executes the query.
        System.out.println(laptop2);
        
        tx.commit();
        session.close();
        
    }
}
