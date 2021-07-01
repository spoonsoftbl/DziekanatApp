package repository;

import entities.Major;

import java.util.List;

public interface MajorRepository {

    List getAllMajors();

    Major getMajorById (int id);

    Major getMajorByName (String name);

    boolean saveMajor (Major major);

    boolean deleteMajor (int id);

    void setSubjectForMajor (int subjectID, int majorID);

    List getMajorSubjects (int id);
}
