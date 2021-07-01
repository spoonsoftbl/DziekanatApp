package repository;

import entities.Student;

public interface StudentRepository {

    Student getStudentById(int id);

    void getStudentByLastName(String lastName);

    void getStudentByNameAndLastName(String name, String lastName);

    void saveStudent ();

    void deleteStudent (int id);

    void updateStudent (int id);

    void setStudentMajor (int studId, int majorId);

}
