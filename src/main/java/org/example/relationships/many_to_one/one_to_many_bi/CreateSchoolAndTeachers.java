package org.example.relationships.many_to_one.one_to_many_bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_one.entity.SchoolBi;
import org.example.relationships.many_to_one.entity.TeacherBi;


import java.util.ArrayList;
import java.util.List;


public class CreateSchoolAndTeachers {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            SchoolBi school = new SchoolBi("schoolBi", "Riga");
            TeacherBi teacher1 = new TeacherBi("Anna", "Smith");
            TeacherBi teacher2 = new TeacherBi("Marie", "Boyd");
            teacher1.setSchool(school);
            teacher2.setSchool(school);

            List<TeacherBi> teachers = new ArrayList<TeacherBi>();
            teachers.add(teacher1);
            teachers.add(teacher2);

            school.setTeachers(teachers);

            em.persist(school);
            em.persist(teacher1);
            em.persist(teacher2);
            em.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {

            em.close();

        }
        emf.close();

    }
}
