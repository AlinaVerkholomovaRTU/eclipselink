package org.example.performance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static java.lang.System.currentTimeMillis;

public class CreateRecords {

        public static void main(String [] args){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
            System.out.println("Is connected: " + emf.createEntityManager().isOpen());
            EntityManager em = emf.createEntityManager();

            try {

                int i = 1;
                long startTime = currentTimeMillis();

                while (i < 1001) {

                    Passport passport = new Passport("AB-1111", "ordinary");
                    em.getTransaction().begin();
                    em.persist(passport);
                    em.getTransaction().commit();

                    i++;
                }
                long stopTime = currentTimeMillis();
                long time = stopTime - startTime;

                System.out.println("Required time for creating 1000 rows is: " + time);

                System.out.println("Successful!");
            }
            finally {
                em.close();
                emf.close();
            }

        }

    }

