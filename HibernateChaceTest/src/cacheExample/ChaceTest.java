/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacheExample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author KHALID
 */
public class ChaceTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee emp=(Employee) session.get(Employee.class, 1);
        emp.setEmp_name("Update Name");         
        session.getTransaction().commit();
        session.close();
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Employee emp2=(Employee) session2.get(Employee.class, 1);
        session2.getTransaction().commit();
        session2.close();
    }
    
}
