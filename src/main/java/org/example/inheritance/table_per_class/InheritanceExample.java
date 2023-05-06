package org.example.inheritance.table_per_class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class InheritanceExample {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Customer customer = new Customer();
            customer.setAmount(50);

            Individual tempIndividual = new Individual();
            tempIndividual.setName("Margaret");
            tempIndividual.setAmount(200);

            LegalEntity company = new LegalEntity();
            company.setRegisterNumber(1234566789);
            company.setAmount(500);

            em.persist(customer);
            em.persist(tempIndividual);
            em.persist(company);

            em.getTransaction().commit();


        } finally{
            em.close();

        }
        emf.close();

        }
}
