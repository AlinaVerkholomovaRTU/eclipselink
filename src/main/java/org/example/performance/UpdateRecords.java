package org.example.performance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static java.lang.System.currentTimeMillis;

public class UpdateRecords {

        public static void main(String [] args){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
            System.out.println("Is connected: " + emf.createEntityManager().isOpen());
            EntityManager em = emf.createEntityManager();

            try {

                Long i = Long.valueOf(1);
                long startTime = currentTimeMillis();

                while (i < 1001) {
                    em.getTransaction().begin();

                    Passport passport = (Passport) em.find(Passport.class, i);
                    passport.setPassportType("Emergency");
                    em.persist(passport);
                    em.getTransaction().commit();

                    i++;
                }
                long stopTime = currentTimeMillis();
                long time = stopTime - startTime;

                System.out.println("Required time for updating 1000 rows is: " + time);

                System.out.println("Successful!");
            }
            finally {
                em.close();
                emf.close();
            }

        }

    }

