package org.example.relationships.one_to_one.one_to_one_uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsUni;
import org.example.relationships.one_to_one.entity.ChoreographerUni;


public class CreateChoreographer {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            ChoreographerDetailsUni tempDetails = new ChoreographerDetailsUni(12,
                    "tango");
            ChoreographerUni tempChoreographer = new ChoreographerUni("Paul", "Wall",
                    tempDetails);

            em.persist(tempDetails);

            em.persist(tempChoreographer);

            em.getTransaction().commit();


        } finally{
            em.close();

        }
        emf.close();

    }
}
