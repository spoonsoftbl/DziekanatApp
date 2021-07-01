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

        Student tempStudent = em.find(Student.class, id);

        System.out.println("Search result: " + tempStudent);

        return tempStudent;

    }

    @Override
    public void getStudentByLastName(String lastName) {

        Query q = em.createQuery("SELECT s  FROM Student s WHERE s.studentName = :studentName");
        q.setParameter("studentName", lastName);

        List<Student> resultList =q.getResultList();

        if(resultList.isEmpty())System.out.println("There is no student with lastname " + lastName + " in the data base");

        else{
            System.out.println("Search result: ");

            for(int i = 0; i < resultList.size(); i++){
                int n = 1;

                System.out.println(n + ". " + resultList.get(i));

                n++;
            }
        }

    }

    @Override
    public void getStudentByNameAndLastName(String name, String lastName) {

        Query q = em.createQuery("SELECT s FROM Subject s WHERE s.studentName = :studentName AND s.studentLastname = :studentLastname");
        q.setParameter("studentName", name);
        q.setParameter("studentLastname", lastName);

        List<Student> resultList = q.getResultList();

        if(resultList.isEmpty())System.out.println("No student with name " + name +
                " and last name " + lastName + " was found in the data base");

        else{
            System.out.println("Search result: ");

            for ( int i = 0; i < resultList.size(); i++){

                int n=1;

                System.out.println(n + ". " + resultList.get(i));

                n++;

            }

        }

    }

    @Override
    public void saveStudent() {

        Scanner scan = new Scanner (System.in);


        System.out.println("Insert student's name: ");
        String name = scan.nextLine();

        System.out.println("Insert student's last name: ");
        String lastName = scan.nextLine();

        System.out.println("Insert student's sex (M - for man / W - for woman: ");
        String tempSex = scan.nextLine();
        char sex = tempSex.charAt(0);

        System.out.println("Insert student's e-mail: ");
        String email = scan.nextLine();

        Student t = new Student(name, lastName, sex, email);


        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();

        em.close();

        System.out.println("Student " + t.getStudentName() + " " + t.getStudentLastname() + " was saved with id no " +
                t.getStudentId());

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
    public void updateStudent(int id) {

        em.getTransaction().begin();

        Student tempStudent = em.find(Student.class, id);

        System.out.println("Updating student: ");
        System.out.println(tempStudent);


        System.out.println("Choose data to update");
        System.out.println("1. Name");
        System.out.println("2. Last name");
        System.out.println("3. Sex (insert M for Man / W for Woman");
        System.out.println("4. Major");
        System.out.println("5. Email");
        System.out.println("0. Break");

        int i = scan.nextInt();
        scan.nextLine();



        switch(i){
            case 1:
                System.out.println("Insert new name: ");
                String newName = scan.nextLine();
                tempStudent.setStudentName(newName);
                System.out.println("Data updated");
                break;

            case 2:
                System.out.println("Insert new last name: ");
                String newLastName = scan.nextLine();
                tempStudent.setStudentLastname(newLastName);
                System.out.println("Data updated");
                break;
            case 3:
                System.out.println("Insert correct sex (M for man, W for woman): ");
                String newSex = scan.nextLine();
                char n = newSex.charAt(0);
                tempStudent.setStudentSex(n);
                System.out.println("Data updated");
                break;
            case 4:
                System.out.println("List of all majors below, please select correct major.");
                System.out.println("Insert new major ID: ");
                Query q = em.createQuery("Select m FROM Major m");
                List<Major> resultList = q.getResultList();

                for(int x = 0; x < resultList.size(); x++)
                    System.out.println(resultList.get(x).getMajorId() + " " + resultList.get(x).getMajorName());

                int newMajor = scan.nextInt();
                scan.nextLine();

                Major tempMajor = em.find(Major.class, newMajor);

                tempStudent.setStudentMajor(tempMajor);
                System.out.println("Data updated");
                break;
            case 5:
                System.out.println("Insert new e-mail address: ");
                String newMail = scan.nextLine();
                tempStudent.setStudentEmail(newMail);
                System.out.println("Data updated");
                break;
                default:
                    System.out.println("Wrong operation was chosen!");
                    System.out.println("Try again...");

        }

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void setStudentMajor(int studId, int majorId) {

        Major tempMajor = em.find(Major.class, majorId);

        Student tempStudent = em.find(Student.class, studId);


        em.getTransaction().begin();

        tempStudent.setStudentMajor(tempMajor);

        em.getTransaction().commit();

        System.out.println("Major " + tempMajor.getMajorName() + " was set for student " + tempStudent.getStudentId()
                + " " + tempStudent.getStudentName() + " " + tempStudent.getStudentLastname());
        System.out.println("Subject assigned to student in Register: ");

        List <Subject> result = tempMajor.getMajorSubjects();

        int n=1;

        for(int i = 0; i<result.size();i++){


            System.out.println(n + ". " + result.get(i).getSubjectName());

            n++;

            em.getTransaction().begin();

            Register newRegister1 = new Register();

            em.persist(newRegister1);

            newRegister1.setRegisterStudent(tempStudent);
            newRegister1.setRegisterSubjects((Subject) result.get(i));
            em.getTransaction().commit();


        }

        em.close();


    }
}
