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

public class UpdateClauseExample {
	
	private static final String QRY = "update insurance invested_amount = :ins_amount where ID = :ins_id ";
	public static void main(String[] args) throws ParseException
	{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		Insurance ins = (Insurance)session.get(Insurance.class, new Long(4));
		
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = df.parse("02-16-2020");
		ins.setInvestementDate(date);
		
		ins.setInsuranceName("nnnn");
		
		session.saveOrUpdate(ins);
		//int i = qry.executeUpate();
		
		
		System.out.println("Update Done.");
		tx.commit();
		session.flush();
		session.close();
		System.out.println("Close Session");
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		ins.setInvestementAmount(35000);
		session2.merge(ins);
		tx2.commit();
		session2.flush();
		session2.close();
		
	}

}
