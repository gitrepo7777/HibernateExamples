package roseindia.tutorial.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertClauseExample {
	
	private static final String QRY = "insert into insurance values(3, 'Liberty Mutual', 15000, '02-17-2012')";
	public static void main(String[] args) throws ParseException
	{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//session.createQuery(QRY);
		
		Insurance ins = new Insurance();
		ins.setLngInsuranceId(5);
		ins.setInsuranceName("Liberty Mutual3");
		ins.setInvestementAmount(18000);
		
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = df.parse("02-18-2013");
		ins.setInvestementDate(date);
		
		session.save(ins);
		tx.commit();
		session.flush();
		session.close();
		
		
	}

}
