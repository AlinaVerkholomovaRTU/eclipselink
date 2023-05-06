package org.example.aggregate_functions;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class AggregateFunctions {

        public static void main(String [] args){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
            System.out.println("Is connected: " + emf.createEntityManager().isOpen());
            EntityManager em = emf.createEntityManager();

            try {

//                Random rand = new Random();
//                int i = 1;
//                while (i < 1001) {
//                    int salaryRand = rand.nextInt(5001);
//                    em.getTransaction().begin();
//
//                    em.persist(new Employee("Andrew", salaryRand));
//                    em.getTransaction().commit();
//
//                    i++;
//                }


                long startTime1 = currentTimeMillis();

                Query query1 = em.createQuery("Select AVG(e.salary) FROM Employee e");
                Double result1 = (Double)query1.getSingleResult();

                long stopTime1 = currentTimeMillis();
                long time1 = stopTime1 - startTime1;

                System.out.println("Average salary is: " + result1);
                System.out.println("Time to get average salary is: " + time1);

                long startTime2 = currentTimeMillis();

                Query query2 = em.createQuery("Select MAX(e.salary) FROM Employee e");
                Double result2 = (Double)query2.getSingleResult();

                long stopTime2 = currentTimeMillis();
                long time2 = stopTime2 - startTime2;

                System.out.println("\nMax salary is: " + result2);
                System.out.println("Time to get max salary is: " + time2);

                long startTime3 = currentTimeMillis();

                Query query3 = em.createQuery("Select MIN(e.salary) FROM Employee e");
                Double result3 = (Double)query3.getSingleResult();

                long stopTime3 = currentTimeMillis();
                long time3 = stopTime3 - startTime3;

                System.out.println("\nMin salary is: " + result3);
                System.out.println("Time to get min salary is: " + time3);

                long startTime4 = currentTimeMillis();

                Query query4 = em.createQuery("Select SUM(e.salary) FROM Employee e");
                Double result4 = (Double)query4.getSingleResult();

                long stopTime4 = currentTimeMillis();
                long time4 = stopTime4 - startTime4;

                System.out.println("\nSum salary is: " + result4);
                System.out.println("Time to get sum salary is: " + time4);

                long startTime5 = currentTimeMillis();

                Query query5 = em.createQuery("Select COUNT(e) FROM Employee e");
                Long result5 = (Long)query5.getSingleResult();

                long stopTime5 = currentTimeMillis();
                long time5 = stopTime5 - startTime5;

                System.out.println("\nAmount of employees:: " + result5);
                System.out.println("Time to get sum salary is: " + time5);




                System.out.println("Successful!");
            }
            finally {
                em.close();
                emf.close();
            }

        }

    }

