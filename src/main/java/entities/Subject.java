package entities;

import javax.persistence.*;

@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id")
    private int subjectId;

    @Column(name="subject_name")
    private String subjectName;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="subject_lecturer")
    private Lecturer subjectLecturer;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="subject_major")
    private Major subjectMajor;

    public Subject() {
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Lecturer getSubjectLecturer() {
        return subjectLecturer;
    }

    public void setSubjectLecturer(Lecturer subjectLecturer) {
        this.subjectLecturer = subjectLecturer;
    }

    public Major getSubjectMajor() {
        return subjectMajor;
    }

    public void setSubjectMajor(Major subjectMajor) {
        this.subjectMajor = subjectMajor;
    }



    @Override
    public String toString() {
        return "Subjects{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectLecturer=" + subjectLecturer +
                ", subjectMajor=" + subjectMajor +
                '}';
    }
}
