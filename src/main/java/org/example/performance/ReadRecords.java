package org.example.performance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static java.lang.System.currentTimeMillis;

public class ReadRecords {

        public static void main(String [] args){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
            System.out.println("Is connected: " + emf.createEntityManager().isOpen());
            EntityManager em = emf.createEntityManager();

            try {

                Long i = 1L;
                long startTime = currentTimeMillis();

                while (i < 1001L) {

                    em.getTransaction().begin();
                    em.find(Passport.class, i);
                    em.getTransaction().commit();

                    i++;
                }
                long stopTime = currentTimeMillis();
                long time = stopTime - startTime;

                System.out.println("Required time for reading 1000 rows is: " + time);

                System.out.println("Successful!");
            }
            finally {
                em.close();
                emf.close();
            }

        }

    }

