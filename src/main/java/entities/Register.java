package entities;

import javax.persistence.*;

@Entity
@Table(name="register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="register_id")
    private int registerId;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade={CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student registerStudent;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade={CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="subject_id")
    private Subject registerSubjects;


    @Column(name="mark")
    private float mark;

    @Column(name="comment")
    private String registerComment;

    public Register() {
    }

    public Register(Student registerStudent, Subject registerSubjects, float mark, String registerComment) {
        this.registerStudent = registerStudent;
        this.registerSubjects = registerSubjects;
        this.mark = mark;
        this.registerComment = registerComment;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public Student getRegisterStudent() {
        return registerStudent;
    }

    public void setRegisterStudent(Student registerStudent) {
        this.registerStudent = registerStudent;
    }

    public Subject getRegisterSubjects() {
        return registerSubjects;
    }

    public void setRegisterSubjects(Subject registerSubjects) {
        this.registerSubjects = registerSubjects;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getRegisterComment() {
        return registerComment;
    }

    public void setRegisterComment(String registerComment) {
        this.registerComment = registerComment;
    }

    @Override
    public String toString() {
        return "Register{" +
                "registerId=" + registerId +
                ", registerStudent=" + registerStudent +
                ", registerSubjects=" + registerSubjects +
                ", mark=" + mark +
                ", registerComment='" + registerComment + '\'' +
                '}';
    }
}
