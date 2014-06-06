package com.vani;
 
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class Main {
 
    public static void main(String[] args) {
 
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);
 
        Employee emp1 = new Employee("Nina", "Mayers", new Date(687687),
        		"1212");
        Employee emp2 = new Employee("Tony", "Almeida", new Date(68768), "4343");
 
        emp1.setDepartment(department);
        emp2.setDepartment(department);
 
        session.save(emp1);
        session.save(emp2);
 
        session.getTransaction().commit();
        session.close();
    }
}