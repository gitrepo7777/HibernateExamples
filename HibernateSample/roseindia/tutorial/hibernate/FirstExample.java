
package roseindia.tutorial.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * @author Deepak Kumar
 *
 * http://www.roseindia.net
 * Hibernate example to inset data into Contact table
 */
public class FirstExample {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try{
			
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
			 
			   tx = session.beginTransaction();
			 
				//Create new instance of Contact and set values in it by reading them from form object
			 	System.out.println("Inserting Record");
				Contact contact = new Contact();
				contact.setId(6);
				contact.setFirstName("Deepak");
				contact.setLastName("Kumar");
				contact.setEmail("deepak_38@yahoo.com");
				session.save(contact);
				System.out.println("Done");
				
				tx.commit();
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			if(session != null){
				session.flush();
				session.close();

			}
			
			}
		
	}
}
