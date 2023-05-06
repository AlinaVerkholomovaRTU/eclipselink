package org.example.caching;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class UnitCachingExample {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();


        Product product1 = em.find(Product.class, 1);
        System.out.println(product1);

        em.close();

        EntityManager em2 = emf.createEntityManager();

        Product product2 = em2.find(Product.class, 1);
        System.out.println(product2);

        em2.close();

        emf.close();

    }
}