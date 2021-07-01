package repository.impl;

import entities.Major;
import entities.Register;
import entities.Student;
import entities.Subject;
import repository.RegisterRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RegisterRepositoryImpl implements RegisterRepository {

    EntityManager em;

    public RegisterRepositoryImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mojprojekt");
        this.em = emf.createEntityManager();
    }

    @Override
    public void setSubjectForStudent(int studentId, int subjectId) {

        Student tempStudent = em.find(Student.class, studentId);

        Subject tempSubject = em.find(Subject.class, subjectId);

        Register tempRegister = new Register ();

        em.getTransaction().begin();

        tempRegister.setRegisterSubjects(tempSubject);

        tempRegister.setRegisterStudent(tempStudent);

        em.getTransaction().commit();
        em.close();

        System.out.println("Subject " + tempSubject.getSubjectName() + " set for student " + tempStudent.getStudentId()
        + " | " + tempStudent.getStudentName() + " " + tempStudent.getStudentLastname());

    }

    @Override
    public void setMarkForStudent(Student tempStud, Subject tempSub, float mark) {


        Query q = em.createQuery("SELECT r FROM Register r WHERE r.registerStudent = " +
                ":registerStudent AND r.registerSubjects = :registerSubjects");

        q.setParameter("registerStudent", tempStud);
        q.setParameter("registerSubjects", tempSub);

        Register result = (Register) q.getSingleResult();

        em.getTransaction().begin();

        result.setMark(mark);

        em.getTransaction().commit();
        em.close();

        System.out.println("Degree " + mark + " set for student " + tempStud.getStudentId() + " " + tempStud.getStudentName() + " "
        + tempStud.getStudentLastname() + " for subject " + tempSub.getSubjectName());

    }

    @Override
    public void setMarkAndComment(Student tempStudent, Subject tempSubject, float t, String comment) {


        Query q = em.createQuery("SELECT r FROM Register r WHERE r.registerStudent = " +
                ":registerStudent AND r.registerSubjects = :registerSubjects");

        q.setParameter("registerStudent", tempStudent);
        q.setParameter("registerSubjects", tempSubject);

        Register result = (Register) q.getSingleResult();

        em.getTransaction().begin();

        result.setMark(t);
        result.setRegisterComment(comment);

        em.getTransaction().commit();
        em.close();

        System.out.println("Degree " + t + " set for student " + tempStudent.getStudentId() + " " + tempStudent.getStudentName() + " "
                + tempStudent.getStudentLastname() + " for subject " + tempSubject.getSubjectName());

    }

    @Override
    public void getStudentListForSubject(int subjectId) {

        Subject tempSubject = em.find(Subject.class, subjectId);

        Query q = em.createQuery("SELECT r FROM Register r WHERE r.registerSubjects = :registerSubjects");
        q.setParameter("registerSubjects", tempSubject);

        List<Register> resultList = q.getResultList();

        for(int i = 0; i < resultList.size(); i++){
            int n = 1;

            System.out.println(n + ". " + resultList.get(i).getRegisterStudent().getStudentId() + " : " +
                    resultList.get(i).getRegisterStudent().getStudentName() + " " + resultList.get(i).getRegisterStudent().getStudentLastname());

            n++;
        }

    }

    @Override
    public void getSubjectListForStudent(int studentId) {

        Student tempStudent = em.find(Student.class, studentId);

        Query q = em.createQuery("SELECT r FROM Register r WHERE r.registerStudent = :registerStudent");
        q.setParameter("registerStudent", tempStudent);

        List<Register> resultList = q.getResultList();

        int size = resultList.size();

        for(int i = 0; i < resultList.size(); i++){

            int n = 1;

            System.out.println(n + ". " +"ID: " + resultList.get(i).getRegisterSubjects().getSubjectId()
                    + " | " + resultList.get(i).getRegisterSubjects().getSubjectName());

            n++;

        }

    }

    @Override
    public void getSubjectAverage(int subjectId) {

        Subject tempSubject = em.find(Subject.class, subjectId);

        Query q = em.createQuery("SELECT r.mark FROM Register r WHERE r.registerSubjects = :registerSubjects");
        q.setParameter("registerSubjects", tempSubject);

        List result = q.getResultList();

        int resultSize = result.size();

        float a = 0;

        for(int i = 0; i < resultSize; i++){

            a += (float) result.get(i);

        }

        float average = a / resultSize;

        System.out.println("Subject: " + tempSubject.getSubjectName() + " - Average: " + average);

    }

    @Override
    public void getStudentAverage(int studentId) {

        Student tempStudent = em.find(Student.class, studentId);

        Query q = em.createQuery("SELECT r.mark FROM Register r WHERE r.registerStudent = :registerStudent");
        q.setParameter("registerStudent", tempStudent);

        List result = q.getResultList();

        int resultSize = result.size();

        float a = 0;

        for(int i = 0; i < resultSize; i++){

            a += (float) result.get(i);

        }

        float average = a / resultSize;

        System.out.println("Student: " + tempStudent.getStudentId() + " " + tempStudent.getStudentName()
                + " " + tempStudent.getStudentLastname() + " - Average: " + average);

    }
}
