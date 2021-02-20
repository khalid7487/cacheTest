package cacheExample;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session 
        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudent = session.createQuery("from Student").list();

            displayStudents(theStudent);

            // query students: lastName ='Islam';
            theStudent = session.createQuery("from Student s where s.lastName='Islam'").list();
            
            System.out.println("\n\nStudent who have last name = Hossen");
            displayStudents(theStudent);
            
            //query students: lastName ='Rakib' OR firstName='zaman'
            theStudent = session.createQuery("from Student s where"
                    + " s.lastName='Zaman' OR s.firstName='Rakib' ").list();
           System.out.println("\n\nStudent who have last name of Zaman or firstName of Rakib");
           displayStudents(theStudent);    
           
           //emails end with .com
           theStudent =session.createQuery("from Student s where s.email"
                   + " LIKE '%.com'  ").list();
           System.out.println("\n\nStudent whos email ends with .com");
           displayStudents(theStudent);   
           
            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        } catch (Exception e) {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudent) {
        //display the sudents
        for (Student student : theStudent) {
            System.out.println(student);
        }
    }
}
