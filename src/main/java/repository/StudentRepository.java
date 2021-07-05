package repository;

import entities.Student;

import java.util.List;

public interface StudentRepository {

    Student getStudentById(int id);

    List getStudentByLastName(String lastName);

    List getStudentByNameAndLastName(String name, String lastName);

    Student saveStudent (Student t);

    void deleteStudent (int id);

    boolean updateStudentName (int id, String name);

    boolean updateStudentLastName (int id, String lastName);

    boolean updateStudentEmail (int id, String email);

    boolean setStudentMajor (int studId, int majorId);

}
