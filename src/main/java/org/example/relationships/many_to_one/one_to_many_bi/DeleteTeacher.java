package org.example.relationships.many_to_one.one_to_many_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_one.entity.TeacherBi;


public class DeleteTeacher {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            int teacherId = 16;

            TeacherBi teacher = em.find(TeacherBi.class, teacherId);

            if (teacher != null) {

                em.remove(teacher);

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
