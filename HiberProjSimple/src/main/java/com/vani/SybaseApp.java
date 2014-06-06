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
public class SybaseApp 
{
	private static Session session = null;
	private static Session sybaseSession = null;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       //simpleTest();
       //sybaseTest();
      getMyEvent();
       
    }
    
    private static void simpleTest()
    {
    	session = getSession();
        Transaction tx = session.beginTransaction();
        Event e = new Event();
        e.setId(9999L);
        e.setName("TestEvent");
        session.save(e);
        tx.commit();
    }

    private static void getMyEvent()
    {
    	/*Session sess = getSybaseSession();
    	Transaction tx = sess.beginTransaction();
    	Event event = (Event)sess.get(Event.class, 100L);
    	tx.commit();
    	return event;*/
    	
    	try{
    			Session session = getSybaseSession();
    		
    			//Using from Clause
    		 	String SQL_QUERY ="from Event";
    		 	Query query = session.createQuery(SQL_QUERY);
    		 	for(Iterator it=query.iterate();it.hasNext();){
    		 		Event e =(Event)it.next();
    		 		System.out.println("ID: " + e.getId());
    		 		System.out.println(" Name: " + e.getName());
    		 	}
    		 	
    	       
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}finally{
    		System.out.println("Finally");
    		if(session != null)
    		session.close();
    	}

    	
    }
    
    
    
    private static void sybaseTest()
    {
    	sybaseSession = getSybaseSession();
        Transaction tx = sybaseSession.beginTransaction();
        Event e = new Event();
        e.setId(9999L);
        e.setName("TestEvent");
        sybaseSession.save(e);
        
        tx.commit();
    }
 
    public static Session getSybaseSession()
    {
		if(sybaseSession == null)
		{
			System.out.println("Create sybase session");
			sybaseSession = HibernateUtil.getSybaseSessionFactory().openSession();
		} else {
			
			System.out.println("returning existing sybase session");
		}
		return sybaseSession; 
	
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
