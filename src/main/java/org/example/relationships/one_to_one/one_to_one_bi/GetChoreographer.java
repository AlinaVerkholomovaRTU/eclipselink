package org.example.relationships.one_to_one.one_to_one_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsBi;

public class GetChoreographer {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            int theId = 5;

            ChoreographerDetailsBi tempDetail = em.find(ChoreographerDetailsBi.class, theId);

            System.out.println(tempDetail);

            System.out.println(tempDetail.getChoreographerBi());

            em.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            em.close();
        }
        emf.close();

    }
}
