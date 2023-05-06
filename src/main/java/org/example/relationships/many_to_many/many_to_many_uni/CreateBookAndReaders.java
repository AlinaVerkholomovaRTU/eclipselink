package org.example.relationships.many_to_many.many_to_many_uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_many.entity.BookUni;
import org.example.relationships.many_to_many.entity.ReaderUni;


import java.util.ArrayList;
import java.util.List;

public class CreateBookAndReaders {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            BookUni book1 = new BookUni("Gone with the wind", "M. Mitchell");
            BookUni book2 = new BookUni("Lord of the Rings", "J. R. R. Tolkien");

            ReaderUni reader = new ReaderUni("Alex", "Thomas", "a.thomas@mail.com");

            List<BookUni> books = new ArrayList<>();
            books.add(book1);
            books.add(book2);

            reader.setBooks(books);

            em.persist(book1);
            em.persist(book2);
            em.persist(reader);

            em.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            em.close();

        }
        emf.close();

    }

}

