import entities.Major;
import entities.Subject;
import org.junit.Assert;
import org.junit.Test;
import repository.impl.MajorRepositoryImpl;
import repository.impl.SubjectRepositoryImpl;

import java.util.List;

public class SubjectRepositoryImplTest {

    SubjectRepositoryImpl sri = new SubjectRepositoryImpl();
    MajorRepositoryImpl mri = new MajorRepositoryImpl();

    @Test
    public void findSubjectById_IdValue_10(){

    //given
    int subjectId = 10;

    //when
    Subject subject = sri.findSubjectById(subjectId);

    //then
    Assert.assertEquals(subjectId, subject.getSubjectId());

    }

    @Test(expected = IllegalArgumentException.class)
    public void findSubjectById_Exception_IdValue_0(){

        //given
        int t =9;

        //when
        sri.findSubjectById(t);

    }

    @Test(expected = IllegalArgumentException.class)
    public void findSubjectById_Exception_IdValue_100(){

        //given
        int t =100;

        //when
        sri.findSubjectById(t);

    }

    @Test
    public void findSubjectByName_correctValue(){

        //given
        String name = "Matematyka";

        //when
        List<Subject> result = sri.findSubjectByName(name);

        //then
        Assert.assertNotNull(result);

    }

    @Test
    public void findSubjectByName_incorrectValue(){

        //given
        String name = "ąą";

        //when
        List<Subject> result = sri.findSubjectByName(name);

        //then
        Assert.assertNull("Incorrect subject name!", result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addSubject_incorrectValue(){

        //given
        Subject tempSubject = new Subject();

        //when
        sri.addSubject(tempSubject);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setSubjectLecturer_incorrectSubjectId_9(){
        
        //given
        int tempSubjectId = 9;
        int tempLecturerId = 100;
        
        //then
        sri.setSubjectLecturer(tempLecturerId, tempSubjectId);
    }

    @Test
    public void addSubject_correctValue(){

        //given
        String tempName = "Test";
        Subject tempSubject = new Subject(tempName);

        //when
        sri.addSubject(tempSubject);



        //then
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteSubject_incorrectValue_9(){

        //given
        int tempId = 9;

        //then
        sri.deleteSubject(tempId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteSubject_incorrectValue_100(){

        //given
        int tempId = 100;

        //then
        sri.deleteSubject(tempId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSubjectLecturer_incorrectValue_subjectId_9(){

        //given
        int subjectId = 9;
        int lecturerId = 100;

        //then
        sri.setSubjectLecturer(lecturerId, subjectId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSubjectLecturer_incorrectValue_subjectId_9_lecturerId_99(){

        //given
        int subjectId = 9;
        int lecturerId = 99;

        //then
        sri.setSubjectLecturer(lecturerId, subjectId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSubjectLecturer_incorrectValue_subjectId_10_lecturerId_99(){

        //given
        int subjectId = 10;
        int lecturerId = 99;

        //then
        sri.setSubjectLecturer(lecturerId, subjectId);

    }

    @Test
    public void setSubjectLecturer_correctValue(){

        //given
        int subjectId = 10;
        int lecturerId = 100;

        //then
        sri.setSubjectLecturer(lecturerId, subjectId);

        sri = new SubjectRepositoryImpl();

        Subject tempSubject = sri.findSubjectById(10);

        Assert.assertNotNull(tempSubject.getSubjectLecturer());

    }


    @Test
    public void deleteSubject_correctValue(){

        //given
        int subjectId = 15;

        //when
        sri.deleteSubject(subjectId);

        //then
        Assert.assertTrue(true);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSubjectMajor_incorrectValue_major_0(){

        //given
        int majorId = 0;
        int subjectId = 10;

        //when
        sri.setSubjectMajor(majorId, subjectId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSubjectMajor_incorrectValue_major_11(){

        //given
        int majorId = 11;
        int subjectId = 10;

        //when
        sri.setSubjectMajor(majorId, subjectId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSubjectMajor_incorrectValue_subject_9(){

        //given
        int majorId = 1;
        int subjectId = 9;

        //when
        sri.setSubjectMajor(majorId, subjectId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSubjectMajor_incorrectValue_subject_100(){

        //given
        int majorId = 1;
        int subjectId = 100;

        //when
        sri.setSubjectMajor(majorId, subjectId);

    }

    @Test
    public void setSubjectMajor_correctValue(){

        //given
        int majorId = 1;
        int subjectId = 10;

        //when
        sri.setSubjectMajor(majorId, subjectId);

        sri = new SubjectRepositoryImpl();
        String subjectMajorName = sri.findSubjectById(subjectId).getSubjectMajor().getMajorName();
        String majorName = mri.getMajorById(majorId).getMajorName();

        //then
        Assert.assertEquals(subjectMajorName, majorName);

    }

    @Test
    public void saveMajorTest(){

        //given
        Major tempMajor = new Major ("Test");

        //when
        mri.saveMajor(tempMajor);

        //then
        Assert.assertTrue(true);

    }

    public void deleteMajor_incorrectValue_0(){

    }



}
