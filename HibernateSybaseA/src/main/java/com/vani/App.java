package com.vani;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    session.beginTransaction();

    EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");
     
    Employee employee = new Employee("Nina", "Mayers", new Date(121212),
            "114-857-965");
    employee.setEmployeeDetail(employeeDetail);
    employeeDetail.setEmployee(employee);
     
     
    session.save(employee);

     
    List<Employee> employees = session.createQuery("from Employee").list();
    for (Employee employee1 : employees) {
        System.out.println(employee1.getFirstname() + " , "
                + employee1.getLastname() + ", "
                + employee1.getEmployeeDetail().getState());
    }

    session.getTransaction().commit();
    session.close();
    
    }
    
   
}
