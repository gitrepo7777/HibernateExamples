package com.annotation;

import javax.persistence.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class TestAnnotation {
	public static void main(String args[]){
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("annotation");
		EntityManager manager=factory.createEntityManager();
		
		System.out.println("Before Creating!!!!!!!!!!!!");
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();	
		manager.persist(new Message("My Entity Test One More Example New"));
		manager.flush();
		transaction.commit();
		
		long l1 = System.currentTimeMillis();
		System.out.println("First time calling Message Object");
		getMessage(manager,1);
		long l2 = System.currentTimeMillis();
		System.out.println("**** Time for first invocation ="+ (l2 -l1));
		
		
		System.out.println("Second time calling Message Object");
		getMessage(manager,1);

		long l3 = System.currentTimeMillis();
		System.out.println("**** Time for Second invocation ="+ (l3 -l2));
		
		factory.close();
	}
	

	public static void getMessage(EntityManager manager,long id){
		EntityTransaction transaction1=manager.getTransaction();
		transaction1.begin();	
		Query q=manager.createQuery("from Message m where m.id="+id);
		Message m=(Message)q.getSingleResult();
		System.out.println(m.getMessage_text());
		transaction1.commit();
	}
	
	
}
