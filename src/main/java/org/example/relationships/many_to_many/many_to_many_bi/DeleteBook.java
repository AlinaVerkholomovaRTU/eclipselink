package org.example.relationships.many_to_many.many_to_many_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_many.entity.BookBi;


public class DeleteBook {
    public static void main(String[] args) {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            int theId = 1;

            BookBi book = em.find(BookBi.class, theId);

            if (book != null) {

                em.remove(book);
            }

            em.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            em.close();

        }
        emf.close();
    }
}

