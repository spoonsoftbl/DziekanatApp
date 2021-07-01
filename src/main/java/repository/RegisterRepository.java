package repository;

import entities.Student;
import entities.Subject;

public interface RegisterRepository {

    void setSubjectForStudent(int studentId, int subjectId);

    void setMarkForStudent (Student tempStud, Subject tempSub, float t);

    void setMarkAndComment (Student tempStudent, Subject tempSubject, float t, String comment);

    void getStudentListForSubject (int subjectId);

    void getSubjectListForStudent (int studentId);

    void getSubjectAverage (int subjectId);

    void getStudentAverage (int studentId);

}
