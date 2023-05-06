package org.example.relationships.many_to_one.one_to_many_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_one.entity.SchoolBi;
import org.example.relationships.many_to_one.entity.TeacherBi;


public class GetTeachersForSchool {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            int schoolId = 5;

            SchoolBi school = em.find(SchoolBi.class, schoolId);

            if (school != null) {

                for (TeacherBi teacher : school.getTeachers()){
                    System.out.println(teacher);
                }

            }
            else {
                System.out.println("School not found");
            }

            em.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            em.close();

        }
        emf.close();
    }
}
