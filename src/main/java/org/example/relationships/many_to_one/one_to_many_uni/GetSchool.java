package org.example.relationships.many_to_one.one_to_many_uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_one.entity.SchoolUni;


public class GetSchool {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            int schoolId = 4;

            SchoolUni schoolUni = em.find(SchoolUni.class, schoolId);

            if (schoolUni != null) {

                System.out.println(schoolUni);

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
