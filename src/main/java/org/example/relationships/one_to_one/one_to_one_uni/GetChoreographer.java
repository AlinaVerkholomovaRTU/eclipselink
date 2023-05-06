package org.example.relationships.one_to_one.one_to_one_uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.one_to_one.entity.ChoreographerUni;


public class GetChoreographer {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //get Choreographer by primary key / id
            int theId = 4;
            ChoreographerUni tempChoreographer = em.find(ChoreographerUni.class, theId);


            if (tempChoreographer != null)
                System.out.println(tempChoreographer);
            else
                System.out.println("Choreographer not found");

            //commit transaction
            em.getTransaction().commit();

        } finally{
            em.close();
        }
        emf.close();

    }
}
