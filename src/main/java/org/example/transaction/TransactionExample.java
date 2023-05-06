package org.example.transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class TransactionExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();



        try {
            em.getTransaction().begin();

            int amount = 100;
            BankAccount bankAccount1 = em.find(BankAccount.class, 1);
            BankAccount bankAccount2 = em.find(BankAccount.class, 2);

            if (bankAccount1 != null) {
                bankAccount1.setBalance(bankAccount1.getBalance() - amount);
                bankAccount2.setBalance(bankAccount2.getBalance() + amount);
                em.persist(bankAccount1);
                em.persist(bankAccount2);
            }
            else
                System.out.println("Bank account not found");

            em.getTransaction().commit();
            System.out.println("Committed!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Rollback!");
            e.printStackTrace();

        } finally {
            em.close();
        }

        emf.close();
    }

}
