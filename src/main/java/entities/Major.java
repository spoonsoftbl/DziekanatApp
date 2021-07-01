package entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="major_id")
    private int majorId;

    @Column(name = "major_name")
    private String majorName;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentMajor",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Student> majorStudents;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="subjectMajor",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Subject> majorSubjects;

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<Student> getMajorStudents() {
        return majorStudents;
    }

    public void setMajorStudents(List<Student> majorStudents) {
        this.majorStudents = majorStudents;
    }

    public List<Subject> getMajorSubjects() {
        return majorSubjects;
    }

    public void setMajorSubjects(List<Subject> majorSubjects) {
        this.majorSubjects = majorSubjects;
    }

    public Major() {
    }

    public Major(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
