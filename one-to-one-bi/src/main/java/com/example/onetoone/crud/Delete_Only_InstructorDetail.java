package com.example.onetoone.crud;

import com.example.onetoone.model.Instructor;
import com.example.onetoone.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete_Only_InstructorDetail {

    public static void main(String[] args) {

        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try {


            //start a transaction
            session.beginTransaction();

            // get the instructor details
            Long theId = 2L;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("tempInstDetail : " + tempInstructorDetail);

            System.out.println("associated instructor : " + tempInstructorDetail.getInstructor());

            //remove the associated abject reference
            //break bidirectional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //leak connection
            session.close();

            factory.close();
        }


    }
}
