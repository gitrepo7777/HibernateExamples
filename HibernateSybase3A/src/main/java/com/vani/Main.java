package com.vani;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	public static void main(String[] args) {
		  
		SessionFactory sf =  HibernateUtil.getSessionFactory();
		
	        Session session = sf.openSession();
	        session.beginTransaction();
  
         
        Meeting meeting1 = new Meeting("Quaterly Sales meeting", new Date(8989));
        Meeting meeting2 = new Meeting("Weekly Status meeting", new Date(6767));
    
        session.save(meeting1); //vani
        session.save(meeting2); //vani
       
        Employee employee1 = new Employee("Sergey", "Brin");
        Employee employee2 = new Employee("Larry", "Page");
 
        employee1.getMeetings().add(meeting1);
        employee1.getMeetings().add(meeting2);
        employee2.getMeetings().add(meeting1);
         
        session.save(employee1);
        session.save(employee2);
         
        session.getTransaction().commit();
        session.close();
    }
}
