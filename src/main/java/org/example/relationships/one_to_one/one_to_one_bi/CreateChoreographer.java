package org.example.relationships.one_to_one.one_to_one_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.one_to_one.entity.ChoreographerBi;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsBi;


public class CreateChoreographer {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ChoreographerBi tempChoreographer = new ChoreographerBi("David", "Walles");

            ChoreographerDetailsBi tempDetail = new ChoreographerDetailsBi( 12, "salsa");

            tempChoreographer.setChoreographerDetailsBi(tempDetail);


            em.persist(tempChoreographer);

            em.getTransaction().commit();


        } finally{
            em.close();

        }
        emf.close();

    }
}
