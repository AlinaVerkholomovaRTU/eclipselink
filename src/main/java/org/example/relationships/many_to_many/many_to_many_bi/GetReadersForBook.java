package org.example.relationships.many_to_many.many_to_many_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_many.entity.BookBi;
import org.example.relationships.many_to_many.entity.ReaderBi;


public class GetReadersForBook {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            int theId = 6;

            BookBi book = em.find(BookBi.class, theId);


            if (book != null) {

                for (ReaderBi reader : book.getReaders()) {
                    System.out.println(reader);
                }
            }
            else {
                System.out.println("Book not found");
            }

            em.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            em.close();

        }
        emf.close();
    }
}

