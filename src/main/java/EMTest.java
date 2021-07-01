import entities.Lecturer;
import entities.Major;
import entities.Register;
import repository.impl.LecturerRepositoryImpl;
import repository.impl.MajorRepositoryImpl;
import repository.impl.StudentRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMTest {

    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mojprojekt");
//
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        Register tempRegister = new Register();
//
//        em.persist(tempRegister);
//
//        tempRegister.get
//
//        em.getTransaction().commit();
//
//        em.close();
//
//        emf.close();
//
//        System.out.println("Sukces");


        StudentRepositoryImpl sri = new StudentRepositoryImpl();

        sri.setStudentMajor(100000, 1);

    }
}
