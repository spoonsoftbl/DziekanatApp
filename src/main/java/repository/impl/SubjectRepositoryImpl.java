package repository.impl;

import entities.Lecturer;
import entities.Major;
import entities.Subject;
import repository.SubjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import static enum_parameters.Id.*;

public class SubjectRepositoryImpl implements SubjectRepository {

    EntityManager em;

    public SubjectRepositoryImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mojprojekt");
        this.em = emf.createEntityManager();
    }

    @Override
    public Subject findSubjectById(int t) {

        if(t < SUBJECT_ID.getMinId() || t > SUBJECT_ID.getMaxId())
            throw new IllegalArgumentException("Incorrect ID value");

        else {
            Subject tempSubject = em.find(Subject.class, t);

            return tempSubject;
        }
    }

    @Override
    public List<Subject> findSubjectByName(String t) {

        Query q = em.createQuery("SELECT s FROM Subject s WHERE s.subjectName = :subjectName");
        q.setParameter("subjectName", t);

        List<Subject> result = q.getResultList();

        if(!result.isEmpty()) {

            System.out.println("Search result: ");

            for (int i = 0; i < result.size(); i++)
                System.out.println("ID: " + result.get(i).getSubjectId() +" | " +  result.get(i).getSubjectName() + " | Major: " +
                        result.get(i).getSubjectMajor().getMajorName());

        return result;

        }
        else{
            System.out.println("Incorrect subject name!");
            return null;
        }
    }

    @Override
    public boolean addSubject(Subject t) {

        boolean status = false;

        if(t.getSubjectName() == null){
            System.out.println("Insert subject name! Subject name can not be empty");
            throw new IllegalArgumentException("Subject name can not be empty");
        }

        else {
            em.getTransaction().begin();

            em.persist(t);

            em.getTransaction().commit();
            em.close();

            System.out.println("New subject " + t.getSubjectName() + " was saved with id no " + t.getSubjectId());

            status = true;
            return status;
        }

    }

    @Override
    public boolean deleteSubject(int t) {

        boolean result = false;

        if(t < SUBJECT_ID.getMinId() || t >= SUBJECT_ID.getMaxId()) {
            System.out.println("Incorrect subject ID value!");
            throw new IllegalArgumentException("Incorrect ID value");
        }

        else {

            Subject tempSubject = em.find(Subject.class, t);

            System.out.println("Subject " + tempSubject.getSubjectId() + " " + tempSubject.getSubjectName() +
                    " was deleted.");

            em.getTransaction().begin();

            em.remove(tempSubject);

            em.getTransaction().commit();

            em.close();

            result = true;

            return result;

        }

    }

    @Override
    public void setSubjectLecturer(int lecturerId, int subjectId) {

        if(subjectId < SUBJECT_ID.getMinId() || subjectId > SUBJECT_ID.getMaxId()) {
            System.out.println("Incorrect subject ID value!");
            throw new IllegalArgumentException("Incorrect ID value");
        }

        if(lecturerId < LECTURER_ID.getMinId() || lecturerId > LECTURER_ID.getMaxId()) {
            System.out.println("Incorrect subject ID value!");
            throw new IllegalArgumentException("Incorrect ID value");
        }

        else {
            Lecturer tempLecturer = em.find(Lecturer.class, lecturerId);

            Subject tempSubject = em.find(Subject.class, subjectId);

            em.getTransaction().begin();

            tempSubject.setSubjectLecturer(tempLecturer);


            em.getTransaction().commit();

            em.close();

            System.out.println("Lecturer " + tempLecturer.getLecturerId() + " " + tempLecturer.getLecturerName() + " "
                    + tempLecturer.getLecturerLastname() + " was set for subject " + tempSubject.getSubjectName());
        }
    }


    @Override
    public void setSubjectMajor(int majorId, int subjectId) {

        if(subjectId < SUBJECT_ID.getMinId() || subjectId > SUBJECT_ID.getMaxId()) {
            System.out.println("Incorrect subject ID value!");
            throw new IllegalArgumentException("Incorrect ID value");
        }

        if(majorId < MAJOR_ID.getMinId() || majorId > MAJOR_ID.getMaxId()) {
            System.out.println("Incorrect subject ID value!");
            throw new IllegalArgumentException("Incorrect ID value");
        }

        else{

            Major tempMajor = em.find(Major.class, majorId);

            Subject tempSubject = em.find(Subject.class, subjectId);

            em.getTransaction().begin();

            tempSubject.setSubjectMajor(tempMajor);

            em.getTransaction().commit();
            em.close();

            System.out.println("Subject " + tempSubject.getSubjectName() + " was assigned to major " + tempMajor.getMajorName());
        }

    }
}
