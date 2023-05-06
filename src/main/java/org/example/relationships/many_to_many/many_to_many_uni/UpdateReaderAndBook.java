package org.example.relationships.many_to_many.many_to_many_uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_many.entity.BookUni;
import org.example.relationships.many_to_many.entity.ReaderUni;


public class UpdateReaderAndBook {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            int theId = 5;

            ReaderUni reader = em.find(ReaderUni.class, theId);
            reader.setLastName("Smith");

            if (reader.getBooks() != null) {

                for (BookUni book : reader.getBooks()) {
                    book.setTitle("The Hobbit");
                    em.persist(book);
                }
            }
            else {
                System.out.println("Book is not found");
            }
            em.persist(reader);

            em.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            em.close();

        }
        emf.close();
    }
}