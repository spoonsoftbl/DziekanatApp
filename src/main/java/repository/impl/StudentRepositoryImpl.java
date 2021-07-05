package repository.impl;

import entities.Major;
import entities.Register;
import entities.Student;
import entities.Subject;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

import static enum_values.Id.STUDENT_ID;
import static enum_values.Id.SUBJECT_ID;

public class StudentRepositoryImpl implements StudentRepository {

    EntityManager em;

    Scanner scan;

    public StudentRepositoryImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mojprojekt");
        this.em = emf.createEntityManager();
        this.scan = new Scanner(System.in);
    }

    @Override
    public Student getStudentById(int id) {

        if(id < STUDENT_ID.getMinId() || id > STUDENT_ID.getMaxId()) {
            System.out.println("Incorrect subject ID value!");
            throw new IllegalArgumentException("Incorrect ID value");
        }
        else {

            Student tempStudent = em.find(Student.class, id);

            System.out.println("Search result: " + tempStudent);

            return tempStudent;
        }

    }

    @Override
    public List getStudentByLastName(String lastName) {

        List<Student> resultList= null;


        Query q = em.createQuery("SELECT s  FROM Student s WHERE s.studentLastname = :studentLastname");
        q.setParameter("studentLastname", lastName);

        resultList =q.getResultList();

        if(resultList.isEmpty()){
            resultList = null;
            System.out.println("There is no student with lastname " + lastName + " in the data base");
        }

        else{
            System.out.println("Search result: ");

            for(int i = 0; i < resultList.size(); i++){
                int n = 1;

                System.out.println(n + ". " + resultList.get(i));

                n++;
            }
        }

        return resultList;

    }

    @Override
    public List getStudentByNameAndLastName(String name, String lastName) {

        Query q = em.createQuery("SELECT s FROM Student s WHERE s.studentName = :studentName AND s.studentLastname = :studentLastname");
        q.setParameter("studentName", name);
        q.setParameter("studentLastname", lastName);

        List<Student> resultList = q.getResultList();

        if(resultList.isEmpty()){
            System.out.println("No student with name " + name +
                    " and last name " + lastName + " was found in the data base");
            resultList = null;
        }

        else{
            System.out.println("Search result: ");

            for ( int i = 0; i < resultList.size(); i++){

                int n=1;

                System.out.println(n + ". " + resultList.get(i));

                n++;

            }

        }

        return resultList;

    }

    @Override
    public Student saveStudent(Student t) {

        boolean result = false;

        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();

        em.close();

        System.out.println("Student " + t.getStudentName() + " " + t.getStudentLastname() + " was saved with id no " +
                t.getStudentId());

        result = true;

        return t;

    }

    @Override
    public void deleteStudent(int id) {

        Student tempStudent = em.find(Student.class, id);

        System.out.println("Following student was deleted: ");
        System.out.println(tempStudent);

        em.getTransaction().begin();

        em.remove(tempStudent);

        em.getTransaction().commit();

        em.close();

    }

    @Override
    public boolean updateStudentName(int id, String name) {

        boolean result = false;

        Student tempStudent = em.find(Student.class, id);

        System.out.println("New name " + name + " was set for student " + tempStudent.getStudentId() +
                " " + tempStudent.getStudentName() + " " + tempStudent.getStudentLastname());


        em.getTransaction().begin();

        tempStudent.setStudentName(name);

        em.getTransaction().commit();

        em.close();

        result = true;

        return result;

    }

    @Override
    public boolean updateStudentLastName(int id, String lastName) {

        boolean result = false;

        Student tempStudent = em.find(Student.class, id);

        System.out.println("New last name " + lastName + " was set for student " + tempStudent.getStudentId() +
                " " + tempStudent.getStudentName() + " " + tempStudent.getStudentLastname());


        em.getTransaction().begin();

        tempStudent.setStudentLastname(lastName);

        em.getTransaction().commit();

        em.close();

        result = true;

        return result;

    }

    @Override
    public boolean updateStudentEmail(int id, String email) {

        boolean result = false;

        Student tempStudent = em.find(Student.class, id);

        System.out.println("New last name " + email + " was set for student " + tempStudent.getStudentId() +
                " " + tempStudent.getStudentName() + " " + tempStudent.getStudentLastname());


        em.getTransaction().begin();

        tempStudent.setStudentEmail(email);

        em.getTransaction().commit();

        em.close();

        result = true;

        return result;

    }

    @Override
    public boolean setStudentMajor(int studId, int majorId) {

        boolean result = false;

        Major tempMajor = em.find(Major.class, majorId);

        Student tempStudent = em.find(Student.class, studId);


        em.getTransaction().begin();

        tempStudent.setStudentMajor(tempMajor);

        em.getTransaction().commit();

        System.out.println("Major " + tempMajor.getMajorName() + " was set for student " + tempStudent.getStudentId()
                + " " + tempStudent.getStudentName() + " " + tempStudent.getStudentLastname());
        System.out.println("Subject assigned to student in Register: ");

        List <Subject> resultList = tempMajor.getMajorSubjects();

        int n=1;

        for(int i = 0; i<resultList.size();i++){


            System.out.println(n + ". " + resultList.get(i).getSubjectName());

            n++;

            em.getTransaction().begin();

            Register newRegister1 = new Register();

            em.persist(newRegister1);

            newRegister1.setRegisterStudent(tempStudent);
            newRegister1.setRegisterSubjects((Subject) resultList.get(i));
            em.getTransaction().commit();


        }

        em.close();

        result = true;

        return result;
    }
}
