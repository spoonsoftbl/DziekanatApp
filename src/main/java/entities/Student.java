package entities;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int studentId;

    @Column(name="student_name")
    private String studentName;

    @Column(name="student_lastname")
    private String studentLastname;

    @Column(name="student_sex")
    private char studentSex;

    @ManyToOne(fetch=FetchType.LAZY,
            cascade={CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="student_major")
    private Major studentMajor;

    @Column(name="student_email")
    private String studentEmail;

    public Student() {
    }


    public Student(String studentName, String studentLastname, char studentSex, String studentEmail) {
        this.studentName = studentName;
        this.studentLastname = studentLastname;
        this.studentSex = studentSex;
        this.studentEmail = studentEmail;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public char getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(char studentSex) {
        this.studentSex = studentSex;
    }

    public Major getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(Major studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentLastname='" + studentLastname + '\'' +
                ", studentSex=" + studentSex +
                ", studentMajor=" + studentMajor +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
