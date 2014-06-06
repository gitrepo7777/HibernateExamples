package com.vani;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final SessionFactory sybaseSessionFactory;
	 
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        try {
            // Create the SessionFactory from sybase.hibernate.cfg.xml
        	sybaseSessionFactory  = new Configuration().configure("sybase.hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
   
    public static SessionFactory getSybaseSessionFactory() {
        return sybaseSessionFactory;
    }
    
    
}
