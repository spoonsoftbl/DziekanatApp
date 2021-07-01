package repository;

import entities.Lecturer;
import entities.Subject;

import java.util.List;

public interface LecturerRepository {

    Lecturer getLecturerById(int t);

    Lecturer getLecturerByLastName(String t);

    Lecturer saveLecturer (Lecturer t);

    boolean deleteLecturer (int t);

    boolean setSubjectForLecturer (int s, int l);

    List getLecturersSubjectList (int t);
}
