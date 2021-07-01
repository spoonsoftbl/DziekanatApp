package repository;

import entities.Subject;

import java.util.List;

public interface SubjectRepository {

    Subject findSubjectById (int t);

    List<Subject> findSubjectByName (String t);

    boolean addSubject (Subject t);

    boolean deleteSubject (int t);

    void setSubjectLecturer (int lecturerId, int subjectId);

    void setSubjectMajor (int majorId, int subjectId);

}
