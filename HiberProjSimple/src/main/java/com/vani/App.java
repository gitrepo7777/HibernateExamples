package com.vani;

import java.sql.Connection;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Session session = null;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        session = getSession();
        Transaction tx = session.beginTransaction();
        
        Event e = new Event();
        e.setId(9999L);
        e.setName("TestEvent");
        
        session.save(e);
        
        
        
        
       /* session = getSession();
        tx = session.beginTransaction();*/
        Event event = (Event)session.get(Event.class, 100L);
        System.out.println(event.getName());
        tx.commit();
       
        
    }
    
 
    
    public static Session getSession()
    {
    
    		if(session == null)
    		{
    			System.out.println("Create session");
    			session = HibernateUtil.getSessionFactory().openSession();
    		} else {
    			
    					System.out.println("returning existing session");
    		}
    		return session; 
    		
    			
    }
}
