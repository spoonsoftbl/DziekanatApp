package repository.impl;

import entities.Lecturer;
import entities.Subject;
import repository.LecturerRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static enum_parameters.Id.LECTURER_ID;

public class LecturerRepositoryImpl implements LecturerRepository {

    Scanner scan = new Scanner(System.in);

    private EntityManager em;

    public LecturerRepositoryImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mojprojekt");
        this.em = emf.createEntityManager();
    }

    @Override
    public Lecturer getLecturerById(int t) {

        if(t < LECTURER_ID.getMinId() || t > LECTURER_ID.getMaxId()){
            System.out.println("Incorrect id value!");
            throw new IllegalArgumentException("Incorrect id value!");
        }

        else {
            Lecturer tempLecturer = em.find(Lecturer.class, t);

            return tempLecturer;
        }
    }

    @Override
    public Lecturer getLecturerByLastName(String t) {

        Lecturer tempLecturer = null;

        try{

        TypedQuery<Lecturer> l = em.createQuery("SELECT l FROM Lecturer l WHERE l.lecturerLastname =:lecturerLastname",
                Lecturer.class);

        l.setParameter("lecturerLastname", t);

        System.out.println("Searched lecturer is: " + l.getSingleResult());

        tempLecturer=  l.getSingleResult();}
        catch(NoResultException e){
            System.out.println("No result");
        }

        return tempLecturer;
    }

    @Override
    public Lecturer saveLecturer(Lecturer t) {


        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();

        em.close();

        String returned = "Lecturer " + t.getLecturerName() + " " + t.getLecturerLastname()
                + " saved with id no. " + t.getLecturerId();

        return t;
    }

    @Override
    public boolean deleteLecturer(int t) {

        if(t < LECTURER_ID.getMinId() || t > LECTURER_ID.getMaxId()){
            System.out.println("Incorrect id value!");
            throw new IllegalArgumentException("Incorrect id value!");
        }

        else {

            boolean result = false;

            Lecturer tempLecturer = em.find(Lecturer.class, t);

            System.out.println("Following lecturer will deleted: " + tempLecturer);

            em.getTransaction().begin();

            em.remove(tempLecturer);

            em.getTransaction().commit();

            em.close();

            result = true;

            return result;
        }
    }

    @Override
    public boolean setSubjectForLecturer(int s, int l) {

        boolean result = false;

        Subject tempSubject = em.find(Subject.class, s);

        Lecturer tempLecturer = em.find(Lecturer.class, l);

        em.getTransaction().begin();

        tempSubject.setSubjectLecturer(tempLecturer);

        em.getTransaction().commit();

        em.close();

        System.out.println("Following subject has been assigned to lecturer "
                + tempLecturer.getLecturerName() + " " + tempLecturer.getLecturerLastname() +": ");
        System.out.println(tempSubject.getSubjectName());

        result = true;

        return result;


    }

    @Override
    public List getLecturersSubjectList(int t) {

        Lecturer tempLecturer = em.find(Lecturer.class, t);

        Query q = em.createQuery("SELECT s FROM Subject s JOIN s.subjectLecturer l WHERE l.lecturerId = :lecturerId");
        q.setParameter("lecturerId", t);

        List<Subject> resultList = q.getResultList();

        if(resultList.isEmpty())System.out.println("Lecturer " + tempLecturer.getLecturerName() +" " +
                tempLecturer.getLecturerLastname() + " does not have any assigned subjects");

        else {

            System.out.println("Following subjects are assigned to lecturer: " +
                    tempLecturer.getLecturerName() + " " + tempLecturer.getLecturerLastname());

            for (int i = 0; i < resultList.size(); i++){

                int n = 1;

                System.out.println(n + ". " + resultList.get(i).getSubjectName());

                n++;
            }
        }

        return resultList;
    }
}
