package repository.impl;

import entities.Major;
import entities.Subject;
import repository.MajorRepository;

import javax.persistence.*;
import java.util.List;

import static enum_parameters.Id.MAJOR_ID;

public class MajorRepositoryImpl implements MajorRepository {

    private EntityManager em;

    public MajorRepositoryImpl() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mojprojekt");
        em = emf.createEntityManager();

    }


    @Override
    public List getAllMajors() {

        Query q = em.createQuery("SELECT m FROM Major m");

        List <Major> resultList = q.getResultList();

        for(int i = 0; i < resultList.size(); i++)
            System.out.println(" Major ID: " + resultList.get(i).getMajorId() +
                " major name " + resultList.get(i).getMajorName());

        return resultList;
    }

    @Override
    public Major getMajorById(int id) {

        if(id < MAJOR_ID.getMinId() || id > MAJOR_ID.getMaxId()){
            System.out.println("Incorrect ID value!");
            throw new IllegalArgumentException();
        }

        else {
            Major tempMajor = em.find(Major.class, id);

            System.out.println("Searched Major with id " + id + " is: ");
            System.out.println(tempMajor);

            return tempMajor;
        }
    }

    @Override
    public Major getMajorByName(String name) {
        
        Major tempMajor = null;

        try {
            Query q = em.createQuery("SELECT m FROM Major m WHERE m.majorName = :majorName");
            q.setParameter("majorName", name);

            tempMajor = (Major) q.getSingleResult();


            System.out.println("Searched major is: " + tempMajor);

            
        }catch(NoResultException ex){
            System.out.println("Incorrect value!");
            throw new NoResultException("Incorrect value");
        }

        return tempMajor;
    }

    @Override
    public boolean saveMajor(Major major) {

        boolean result = false;

        System.out.println("Saving major " + major.getMajorName());

        em.getTransaction().begin();

        em.persist(major);

        em.getTransaction().commit();

        em.close();

        System.out.println("Major " + major.getMajorName() + "saved with id no. " + major.getMajorId());

        result = true;

        return result;
    }

    @Override
    public boolean deleteMajor(int id) {

        boolean result = false;

        if(id < MAJOR_ID.getMinId() || id > MAJOR_ID.getMaxId()){
            System.out.println("Incorrect ID value!");
            throw new IllegalArgumentException();
        }
        else {

            Major tempMajor = em.find(Major.class, id);

            System.out.println("Following major will be deleted: " + tempMajor);

            em.getTransaction().begin();

            em.remove(tempMajor);

            em.getTransaction().commit();

            em.close();

            result = true;
        }

        return result;

    }

    @Override
    public void setSubjectForMajor(int subjectID, int majorID) {

        Subject tempSubject = em.find(Subject.class, subjectID);

        Major tempMajor = em.find(Major.class, majorID);

        if(!tempSubject.getSubjectMajor().getMajorSubjects().isEmpty())
            System.out.println("Current major for subject " + tempSubject.getSubjectName() + " is " +
                    tempSubject.getSubjectMajor().getMajorName() + " and it will be updated to " + tempMajor.getMajorName());

        em.getTransaction().begin();

        tempSubject.setSubjectMajor(tempMajor);

        em.getTransaction().commit();

        em.close();

        System.out.println("Following subject has been assigned to major "
                + tempMajor.getMajorName() + ": ");
        System.out.println(tempSubject.getSubjectName());

    }

    @Override
    public List getMajorSubjects(int id) {

        if(id < MAJOR_ID.getMinId() || id > MAJOR_ID.getMaxId()){
            System.out.println("Incorrect ID value!");
            throw new IllegalArgumentException();
        }


        else {

            List<Subject> resultList = null;

            Major tempMajor = em.find(Major.class, id);

            if (tempMajor == null)
                System.out.println("Major does not exist");

            else {
            Query q = em.createQuery("SELECT s FROM Subject s JOIN s.subjectMajor m WHERE m.majorId = :majorId");
            q.setParameter("majorId", id);

            resultList = q.getResultList();



                System.out.println("Following subjects are assigned to major " + tempMajor.getMajorName() + ": ");

                for (int i = 0; i < resultList.size(); i++) {

                    int n = 1;

                    System.out.println(n + ". " + resultList.get(i).getSubjectName());

                    n++;
                }
            }

            return resultList;

        }

    }
}
