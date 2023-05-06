package org.example.lazy_loading;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class LazyLoadingExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            int id = 1;
            School school = em.find(School.class, id);

            System.out.println("School: " + school);

            System.out.println("Teachers: " + school.getTeachers());

            em.getTransaction().commit();


        } finally {
           em.close();

        }
        emf.close();


    }
}
