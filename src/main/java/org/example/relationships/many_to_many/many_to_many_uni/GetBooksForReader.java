package org.example.relationships.many_to_many.many_to_many_uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_many.entity.BookUni;
import org.example.relationships.many_to_many.entity.ReaderUni;


public class GetBooksForReader {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            int theId = 3;

            ReaderUni reader = em.find(ReaderUni.class, theId);

            if (reader != null) {

                for (BookUni book : reader.getBooks()) {
                    System.out.println(book);
                }
            }
            else {
                System.out.println("Reader not found");
            }

            em.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            em.close();

        }
        emf.close();
    }
}

