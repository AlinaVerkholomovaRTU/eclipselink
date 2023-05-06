package org.example.relationships.many_to_many.many_to_many_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_many.entity.BookBi;
import org.example.relationships.many_to_many.entity.ReaderBi;


import java.util.ArrayList;
import java.util.List;

public class CreateBookAndReaders {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            BookBi book = new BookBi("Gone with the wind", "M. Mitchell");
            ReaderBi reader1 = new ReaderBi("Alex", "Thomas", "a.thomas@mail.com");
            ReaderBi reader2 = new ReaderBi("Meredith", "Johns", "m.johns@mail.com");

            List<ReaderBi> readers = new ArrayList<>();
            readers.add(reader1);
            readers.add(reader2);

            book.setReaders(readers);

            em.persist(book);
            em.persist(reader1);
            em.persist(reader2);

            em.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            em.close();

        }
        emf.close();

    }

}

