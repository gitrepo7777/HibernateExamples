package com.vani;

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
    {
        System.out.println( "Hello World!" );
        /*Employee emp = new Employee();
        emp.setBirthDate(new java.util.Date());
        emp.setCellphone("212.999.9999");
        emp.setFirstname("TestFirstName");
        emp.setLastname("TestlastName");
        
        
        App.save(emp);*/
        App.list();
        Employee emp = App.read(1L);
        System.out.println(emp.getFirstname());
        System.out.println(emp.getLastname());
        
        emp.setLastname("UpdateLastName");
        App.update(emp);
        
        emp = App.read(1L);
        System.out.println(emp.getFirstname());
        System.out.println(emp.getLastname());
        
        
        
    }
    
    private static Employee save(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
     
        Long id = (Long) session.save(employee);
        employee.setId(id);
             
        session.getTransaction().commit();
             
        session.close();
     
        return employee;
    }
    
    private static List list() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
     
        List<Employee> employees = session.createQuery("from Employee").list();
        session.close();
        return employees;
    }
    
    private static Employee read(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
     
        Employee employee = (Employee) session.get(Employee.class, id);
        session.close();
        return employee;
    }
    
    private static Employee update(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
     
        session.beginTransaction();
     
        session.merge(employee);
     
        session.getTransaction().commit();
     
        session.close();
        return employee;
     
    }
    
    private static void delete(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
     
        session.beginTransaction();
     
        session.delete(employee);
     
        session.getTransaction().commit();
     
        session.close();
    }
}
