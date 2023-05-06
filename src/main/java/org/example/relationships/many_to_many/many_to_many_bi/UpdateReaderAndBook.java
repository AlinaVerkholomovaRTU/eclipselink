package org.example.relationships.many_to_many.many_to_many_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_many.entity.BookBi;
import org.example.relationships.many_to_many.entity.ReaderBi;


public class UpdateReaderAndBook {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            int theId = 6;
            BookBi book = em.find(BookBi.class, theId);

            book.setAuthor("J. London");
            if (book.getReaders() != null) {
                for (ReaderBi reader : book.getReaders()) {
                    reader.setEmail("new@mail.com");
                    em.persist(reader);
                }
            }
            else {
                System.out.println("Readers not found");
            }
            em.persist(book);

            em.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            em.close();

        }
        emf.close();
    }
}