import entities.Student;
import org.junit.Assert;
import org.junit.Test;
import repository.impl.StudentRepositoryImpl;

import java.util.List;

public class StudentRepositoryImplTest {

    StudentRepositoryImpl sri = new StudentRepositoryImpl();

    @Test(expected = IllegalArgumentException.class)
    public void getStudentByIdTest_incorrectValue_99999(){

        //given
        int id = 99999;

        //when
        sri.getStudentById(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStudentByIdTest_incorrectValue_1000000(){

        //given
        int id = 1000000;

        //when
        sri.getStudentById(id);
    }

    @Test
    public void getStudentByIdTest_correctValue(){

        //given
        int id = 100000;

        //when
        Student tempStudent = sri.getStudentById(id);

        //then
        Assert.assertEquals(id, tempStudent.getStudentId());

    }

    @Test
    public void getStudentByLastNameTest_incorrectValue(){

        //given
        String lastName = "AAAAAa";

        //when
        List resultList = sri.getStudentByLastName(lastName);

        //then
        Assert.assertNull(resultList);

    }

    @Test
    public void getStudentByLastNameTest_correctValue(){

        //given
        String lastName = "Skonieczny";

        List resultList = sri.getStudentByLastName(lastName);

        //then
        Assert.assertNotNull(resultList);

    }

    @Test
    public void getStudentByNameAndLastNameTest_incorrectValue(){

        //given
        String name = "A";
        String lastName = "A";

        List resultList = sri.getStudentByNameAndLastName(name, lastName);

        //then
        Assert.assertNull(resultList);

    }

    @Test
    public void getStudentByNameAndLastNameTest_correctValue(){

        //given
        String name = "Krzysztof";
        String lastName = "Skonieczny";

        List resultList = sri.getStudentByNameAndLastName(name, lastName);

        //then
        Assert.assertNotNull(resultList);

    }

    @Test
    public void saveStudentTest(){

        //given
        Student tempStudent = new Student("Michał", "Koleszka", 'M', "michukoles@gmail.com");

        //when
        sri.saveStudent(tempStudent);

        //then
        Assert.assertNotNull(tempStudent.getStudentId());

    }
    

}
