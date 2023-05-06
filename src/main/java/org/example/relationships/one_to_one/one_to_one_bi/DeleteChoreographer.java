package org.example.relationships.one_to_one.one_to_one_bi;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.one_to_one.entity.ChoreographerBi;


public class DeleteChoreographer {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

        int theId = 5;
        ChoreographerBi tempChoreographer = em.find(ChoreographerBi.class, theId);

        if (tempChoreographer != null)
            em.remove(tempChoreographer);
        else
            System.out.println("Choreographer not found");

        em.getTransaction().commit();

    } finally{
        em.close();

    }
        emf.close();

    }
}
