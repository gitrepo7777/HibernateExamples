package roseindia.tutorial.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteClauseExample {
	
	private static final String QRY = "update insurance invested_amount = :ins_amount where ID = :ins_id ";
	public static void main(String[] args) throws ParseException
	{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		Insurance ins = (Insurance)session.get(Insurance.class, new Long(3));
		
		
		session.delete(ins);
		System.out.println("Delete Done.");
		tx.commit();
		session.flush();
		session.close();
		
		
	}

}
