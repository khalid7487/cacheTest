package cacheExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session 
        Session session = factory.getCurrentSession();

        try {
            //create 3 student objects
            System.out.println("Creating3 student objects....");
            Student tempStudent1 = new Student("Hridoy", "Mizi", "hridoy7487@gmail.com");
            Student tempStudent2 = new Student("Rakib", "Islam", "rakib7487@gmail.com");
            Student tempStudent3 = new Student("Sabab", "Zaman", "sabab7487@gmail.com");
            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student....");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            factory.close();
        }
    }
}
