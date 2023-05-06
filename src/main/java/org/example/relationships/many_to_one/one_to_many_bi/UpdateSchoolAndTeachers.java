package org.example.relationships.many_to_one.one_to_many_bi;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.relationships.many_to_one.entity.SchoolBi;
import org.example.relationships.many_to_one.entity.TeacherBi;


public class UpdateSchoolAndTeachers {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        System.out.println("Is connected: " + emf.createEntityManager().isOpen());
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            int theId = 16;

            TeacherBi teacher = em.find(TeacherBi.class, theId);
            SchoolBi school = teacher.getSchool();

            if (school != null) {
                school.setName("Lyceum");
                school.setTeachers(null);
                em.persist(school);

                if (school.getTeachers() != null) {
                    for (TeacherBi teacherTemp : school.getTeachers()) {
                        teacherTemp.setFirstName("Adam");
                        em.persist(teacherTemp);
                    }
                }
                else{
                    System.out.println("Teachers not found");
                }
            }
            else
                System.out.println("School not found");

            //commit transaction
            em.getTransaction().commit();


        } finally{

            em.close();

        }
        emf.close();
    }
}
