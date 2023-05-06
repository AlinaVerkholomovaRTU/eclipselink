package org.example.relationships.many_to_one.one_to_many_uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_one.entity.SchoolUni;
import org.example.relationships.many_to_one.entity.TeacherUni;


public class CreateSchoolAndTeachers {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            SchoolUni schoolUni = new SchoolUni("school1", "Riga");
            TeacherUni teacherUni1 = new TeacherUni("Anna", "Smith");
            TeacherUni teacherUni2 = new TeacherUni("Marie", "Boyd");

            teacherUni1.setSchool(schoolUni);
            teacherUni2.setSchool(schoolUni);

            em.persist(schoolUni);
            em.persist(teacherUni1);
            em.persist(teacherUni2);

            em.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            em.close();

        }
        emf.close();

    }
}
