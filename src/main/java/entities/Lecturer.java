package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private int lecturerId;

    @Column(name = "lecturer_name")
    private String lecturerName;

    @Column(name = "lecturet_lastname")
    private String lecturerLastname;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="subjectLecturer",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Subject> lecturerSubject;
    
      public Lecturer() {
    }

    public Lecturer(String lecturerName, String lecturerLastname) {
        this.lecturerName = lecturerName;
        this.lecturerLastname = lecturerLastname;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerLastname() {
        return lecturerLastname;
    }

    public void setLecturerLastname(String lecturerLastname) {
        this.lecturerLastname = lecturerLastname;
    }

    public List<Subject> getLecturerSubject() {
        return lecturerSubject;
    }

    public void setLecturerSubject(List<Subject> lecturerSubject) {
        this.lecturerSubject = lecturerSubject;
    }

  

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId=" + lecturerId +
                ", lecturerName='" + lecturerName + '\'' +
                ", lecturerLastname='" + lecturerLastname + '\'' +
                '}';
    }
}
